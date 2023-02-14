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
                    try {
                        ImageIO.write(image, "PNG", new File(directory, (char) i + ".png"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
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

    /**
     * Creates a {@link BufferedImage} glyph
     * from the provided {@link Character}
     *
     * @param fontFace {@link FontFace} that you want to use
     * @param charCode {@link Character} glyph that you want to generate
     * @return {@link BufferedImage}
     */

    static BufferedImage createGlyph(FontFace fontFace, char charCode) {
        assert fontFace.loadChar(charCode, Freetype.FT_LOAD_RENDER);

        GlyphSlot glyphSlot = fontFace.getGlyphSlot();
        assert glyphSlot != null;

        Bitmap bitmap = glyphSlot.getBitmap();
        assert bitmap != null;

        final int width = (int) bitmap.getWidth();
        final int height = (int) bitmap.getRows();

        final byte[] glyphBitmap = new byte[width * height];
        bitmap.getBuffer().get(glyphBitmap, 0, width * height);

        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                final int value = glyphBitmap[x + y * width] & 0xFF;
                image.setRGB(x, y, (value << 24) | (value << 16) | (value << 8) | value);
            }
        }

        return image;
    }

}
