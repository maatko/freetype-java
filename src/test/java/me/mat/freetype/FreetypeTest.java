package me.mat.freetype;

import me.mat.freetype.font.Face;

import java.io.File;

public class FreetypeTest {

    public static void main(String[] args) {
        Freetype.init();
        {
            Face face = Freetype.newFace(new File("C:/Windows/Fonts/Arial.ttf"));
            if (face != null) {
                System.out.println("Family name: " + face.getFamilyName());
                System.out.println("Style name: " + face.getStyleName());
                System.out.println("Face Index: " + face.getFaceIndex());
                System.out.println("Number of Faces: " + face.getNumberOfFaces());
                System.out.println("Face Flags: " + face.getFaceFlags());
                System.out.println("Style flags: " + face.getStyleFlags());
                System.out.println("Number of Glyphs: " + face.getNumberOfGlyphs());
                if (!face.free())
                    System.err.println("Failed to free the font Face");
            } else {
                System.err.println("Failed to create the font Face");
            }
        }
        Freetype.free();
    }

}
