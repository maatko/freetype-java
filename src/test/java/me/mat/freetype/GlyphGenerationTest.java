package me.mat.freetype;

import me.mat.freetype.bitmap.Bitmap;
import me.mat.freetype.font.FontFace;
import me.mat.freetype.glyph.GlyphSlot;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GlyphGenerationTest {

    @Test
    public void generate() {
        final File directory = new File("target", "test-glyphs");
        if (!directory.exists()) {
            if (!directory.mkdirs())
                throw new RuntimeException("Failed to create the glyphs directory");
        }

        Freetype.init();
        {
            FontFace fontFace = Freetype.newFontFace(new File("CascadiaCode.ttf"));
            if (fontFace != null) {
                fontFace.setPixelSizes(0, 1024);
                for (int i = 'A'; i <= 'Z'; i++) {
                    System.out.println("Creating a glyph for '" + (char) i + "'");
                    BufferedImage image = createGlyph(fontFace, (char) i);
                    if (image != null) {
                        try {
                            ImageIO.write(image, "PNG", new File(directory, (char) i + ".png"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if (!fontFace.free())
                    throw new RuntimeException("Failed to free the FontFace");
            } else {
                throw new RuntimeException("Failed to create the FontFace");
            }
        }
        if (!Freetype.free())
            throw new RuntimeException("Failed to free the Freetype library");
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
