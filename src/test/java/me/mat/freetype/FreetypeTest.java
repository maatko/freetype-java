package me.mat.freetype;

import me.mat.freetype.font.FontFace;

import java.io.File;

public class FreetypeTest {

    public static void main(String[] args) {
        Freetype.init();
        {
            FontFace fontFace = Freetype.newFontFace(new File("C:/Windows/Fonts/Arial.ttf"));
            if (fontFace != null) {
                System.out.println(fontFace);
                if (!fontFace.free())
                    System.err.println("Failed to free the font Face");
            } else {
                System.err.println("Failed to create the font Face");
            }
        }
        Freetype.free();
    }

}
