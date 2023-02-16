package me.mat.freetype;

import me.mat.freetype.font.FontFace;
import me.mat.freetype.memory.MemoryStack;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.LongBuffer;

public class CharMapTest {

    @Test
    public void charMap() {
        try (final Freetype freetype = new Freetype()) {
            try (FontFace fontFace = freetype.newFontFace(new File("CascadiaCode.ttf"))) {
                try (MemoryStack memoryStack = new MemoryStack()) {
                    final LongBuffer buffer = memoryStack.mallocLong(1);
                    long charCode = fontFace.getFirstChar(buffer);
                    long glyphIndex;
                    while ((glyphIndex = buffer.get()) != 0) {
                        System.out.println(charCode + ", " + glyphIndex);
                        charCode = fontFace.getNextChar(charCode, buffer);
                        buffer.flip();
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (FreetypeException e) {
            throw new RuntimeException(e);
        }
    }

}
