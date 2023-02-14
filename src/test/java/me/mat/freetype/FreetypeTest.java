package me.mat.freetype;

import me.mat.freetype.font.FontFace;
import me.mat.freetype.font.FontSize;
import me.mat.freetype.font.FontSizeMetrics;

import java.io.File;

public class FreetypeTest {

    public static void main(String[] args) {
        Freetype.init();
        {
            FontFace fontFace = Freetype.newFontFace(new File("C:/Windows/Fonts/Arial.ttf"));
            if (fontFace != null) {
                System.out.println(fontFace);
                FontSize fontSize = fontFace.getFontSize();
                if (fontSize != null) {
                    FontSizeMetrics fontSizeMetrics = fontSize.getFontSizeMetrics();
                    if (fontSizeMetrics != null) {
                        System.out.println(fontSizeMetrics.getMaxAdvance());
                    } else {
                        System.err.println("fontSizeMetrics is null");
                    }
                } else {
                    System.err.println("fontSize is null");
                }
                if (!fontFace.free())
                    System.err.println("Failed to free the font Face");
            } else {
                System.err.println("Failed to create the font Face");
            }
        }
        Freetype.free();
    }

}
