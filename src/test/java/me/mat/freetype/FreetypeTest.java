package me.mat.freetype;

import me.mat.freetype.bitmap.Bitmap;
import me.mat.freetype.font.FontFace;
import me.mat.freetype.glyph.GlyphSlot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FreetypeTest {

    public static void main(String[] args) {
        Freetype.init();
        {
            FontFace fontFace = Freetype.newFontFace(new File("C:/Windows/Fonts/Arial.ttf"));
            if (fontFace != null) {
                fontFace.setPixelSizes(0, 1024);

                for (int i = 'A'; i < 'Z'; i++) {
                    BufferedImage image = createGlyph(fontFace, (char) i);
                    if (image != null) {
                        try {
                            ImageIO.write(image, "PNG", new File("target/" + (char) i + ".png"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                if (!fontFace.free())
                    System.err.println("Failed to free the font Face");
            } else {
                System.err.println("Failed to create the font Face");
            }
        }
        Freetype.free();
    }

    static BufferedImage createGlyph(FontFace fontFace, char charCode) {
        if (!fontFace.loadChar(charCode, 1 << 2))
            return null;

        GlyphSlot glyphSlot = fontFace.getGlyphSlot();
        if (glyphSlot == null)
            return null;

        Bitmap bitmap = glyphSlot.getBitmap();
        if (bitmap == null)
            return null;

        int bitmapWidth = (int) bitmap.getWidth();
        int bitmapHeight = (int) bitmap.getRows();
        byte[] glyphBitmap = new byte[bitmapWidth * bitmapHeight];
        bitmap.getBuffer().get(glyphBitmap, 0, bitmapWidth * bitmapHeight);

        BufferedImage glyphImage = new BufferedImage(bitmapWidth, bitmapHeight, BufferedImage.TYPE_INT_ARGB);
        int x = 0;
        int y = 0;
        for (int byteAsInt : glyphBitmap) {
            int argb = (byteAsInt << 24) | (byteAsInt << 16) | (byteAsInt << 8) | byteAsInt;
            glyphImage.setRGB(x, y, argb);
            x++;
            if (x >= bitmapWidth) {
                x = 0;
                y++;
            }
            if (y >= bitmapHeight) {
                break;
            }
        }

        return glyphImage;
    }

}
