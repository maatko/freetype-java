package me.mat.freetype;

import me.mat.freetype.bitmap.Bitmap;
import me.mat.freetype.font.FontFace;
import me.mat.freetype.font.FreetypeFaceException;
import me.mat.freetype.glyph.FreetypeGlyphException;
import me.mat.freetype.glyph.GlyphSlot;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class GlyphGenerationTest {

    @Test
    public void generate() {
        final File directory = new File("target", "test-glyphs");
        if (!directory.exists()) {
            if (!directory.mkdirs())
                throw new RuntimeException("Failed to create the glyphs directory");
        }
        try (final Freetype freetype = new Freetype()) {
            try (FontFace fontFace = freetype.newFontFace(new File("CascadiaCode.ttf"))) {
                fontFace.setPixelSizes(0, 1024);
                for (int i = 'A'; i <= 'Z'; i++) {
                    ImageIO.write(
                            createGlyph(fontFace,
                                    (char) i,
                                    Freetype.FT_LOAD_RENDER
                            ),
                            "PNG",
                            new File(directory,
                                    (char) i + ".png")
                    );
                }
            } catch (FreetypeFaceException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a {@link BufferedImage} glyph
     * from the provided {@link Character}
     *
     * @param fontFace {@link FontFace} that you want to use
     * @param charCode {@link Character} glyph that you want to generate
     * @return {@link BufferedImage}
     */

    static BufferedImage createGlyph(FontFace fontFace, char charCode, int flags) throws FreetypeGlyphException {
        fontFace.loadChar(charCode, flags);

        GlyphSlot glyphSlot = fontFace.getGlyphSlot();
        assert glyphSlot != null;

        glyphSlot.renderGlyph(FreetypeRenderMode.FT_RENDER_MODE_NORMAL);

        Bitmap bitmap = glyphSlot.getBitmap();
        assert bitmap != null;

        final int width = (int) bitmap.getWidth();
        final int height = (int) bitmap.getRows();

        final byte[] glyphBitmap = new byte[width * height];
        bitmap.getBuffer().flip();
        bitmap.getBuffer().get(glyphBitmap, 0, glyphBitmap.length);

        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                byte pixel = glyphBitmap[x + y * width];
                image.setRGB(x, y, (pixel << 24) | (pixel << 16) | (pixel << 8) | pixel);
            }
        }

        return image;
    }

}
