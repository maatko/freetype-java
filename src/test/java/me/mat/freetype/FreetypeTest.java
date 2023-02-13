package me.mat.freetype;

import me.mat.freetype.font.FontFace;

import java.io.File;
import java.util.Arrays;

public class FreetypeTest {

    public static void main(String[] args) {
        Freetype.init();
        {
            FontFace fontFace = Freetype.newFontFace(new File("C:/Windows/Fonts/Arial.ttf"));
            if (fontFace != null) {
                System.out.println("Family name: " + fontFace.getFamilyName());
                System.out.println("Style name: " + fontFace.getStyleName());
                System.out.println("Face Index: " + fontFace.getFaceIndex());
                System.out.println("Number of Faces: " + fontFace.getNumberOfFaces());
                System.out.println("Face Flags: " + fontFace.getFaceFlags());
                System.out.println("Style flags: " + fontFace.getStyleFlags());
                System.out.println("Number of Glyphs: " + fontFace.getNumberOfGlyphs());
                System.out.println("Bitmap Strikes: " + fontFace.getBitmapStrikes());
                System.out.println("AvailableSizes: " + Arrays.toString(fontFace.getAvailableSizes()));
                System.out.println("Number of Character maps: " + fontFace.getNumberOfCharacterMaps());
                System.out.println("Character maps: " + Arrays.toString(fontFace.getCharacterMaps()));
                System.out.println("Font BoundingBox: " + fontFace.getFontBoundingBox());
                System.out.println("Units per EM: " + fontFace.getUnitsPerEM());
                System.out.println("Ascender: " + fontFace.getAscender());
                System.out.println("Descender: " + fontFace.getDescender());
                System.out.println("Height: " + fontFace.getHeight());
                System.out.println("Max Advance Width: " + fontFace.getMaxAdvanceWidth());
                System.out.println("Max Advance Height: " + fontFace.getMaxAdvanceHeight());
                System.out.println("Underline Position: " + fontFace.getUnderlinePosition());
                System.out.println("Underline Thickness: " + fontFace.getUnderlineThickness());
                System.out.println("GlyphSlot: " + fontFace.getGlyphSlot());
                System.out.println("Size: " + fontFace.getSize());
                System.out.println("CharMap: " + fontFace.getCharMap());
                if (!fontFace.free())
                    System.err.println("Failed to free the font Face");
            } else {
                System.err.println("Failed to create the font Face");
            }
        }
        Freetype.free();
    }

}
