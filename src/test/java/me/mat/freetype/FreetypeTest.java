package me.mat.freetype;

import me.mat.freetype.font.FontFace;

import java.io.File;

public class FreetypeTest {

    public static void main(String[] args) {
        Freetype.init();
        {
            FontFace fontFace = Freetype.newFontFace(new File("C:/Windows/Fonts/Arial.ttf"));
            if (fontFace != null) {

                fontFace.setPixelSizes(0, 50);
                if (!fontFace.loadChar('A', 1 << 2)) {
                    System.out.println("FreeType could not generate character.");
                }
                System.out.println(fontFace.getGlyphSlot().getAdvanceWidth());
                System.out.println(fontFace.getGlyphSlot().getGlyphMetrics().getHeight());

                if (!fontFace.free())
                    System.err.println("Failed to free the font Face");
            } else {
                System.err.println("Failed to create the font Face");
            }
        }
        Freetype.free();
    }

}
