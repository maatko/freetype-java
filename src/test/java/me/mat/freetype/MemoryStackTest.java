package me.mat.freetype;

import me.mat.freetype.memory.MemoryStack;
import org.junit.jupiter.api.Test;

import java.nio.IntBuffer;
import java.util.Arrays;

public class MemoryStackTest {

    @Test
    public void memoryStack() {
        try (final Freetype freetype = new Freetype()) {
            try (MemoryStack stack = new MemoryStack()) {
                IntBuffer buffer = stack.mallocInt(10);
                for (int i = 0; i < 10; i++)
                    buffer.put(i);
                buffer.flip();
                int[] data = new int[10];
                buffer.get(data);
                System.out.println(Arrays.toString(data));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
