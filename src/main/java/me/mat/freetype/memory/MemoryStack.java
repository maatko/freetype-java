package me.mat.freetype.memory;

import java.nio.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryStack implements AutoCloseable {

    private final List<Buffer> allocateMemory = new CopyOnWriteArrayList<>();

    @Override
    public void close() {
        allocateMemory.forEach(MemoryStack::FT_Free_MemoryStack);
        allocateMemory.clear();
    }

    /**
     * Allocates a {@link ByteBuffer} on the {@link MemoryStack}
     *
     * @param capacity {@link Integer} capacity of the buffer
     * @return {@link ByteBuffer}
     */

    public ByteBuffer malloc(int capacity) {
        final long size = capacity * Byte.BYTES;
        final ByteBuffer buffer = FT_Allocate_MemoryStack(size, capacity);
        if (buffer == null)
            throw new OutOfMemoryError("Failed to allocate " + size + " bytes of memory for the buffer");
        return buffer.order(ByteOrder.nativeOrder());
    }

    /**
     * Allocates a {@link CharBuffer} on the {@link MemoryStack}
     *
     * @param capacity {@link Integer} capacity of the buffer
     * @return {@link CharBuffer}
     */

    public CharBuffer mallocChar(int capacity) {
        return malloc(capacity * Character.BYTES).asCharBuffer();
    }

    /**
     * Allocates a {@link ShortBuffer} on the {@link MemoryStack}
     *
     * @param capacity {@link Integer} capacity of the buffer
     * @return {@link ShortBuffer}
     */

    public ShortBuffer mallocShort(int capacity) {
        return malloc(capacity * Short.BYTES).asShortBuffer();
    }

    /**
     * Allocates a {@link IntBuffer} on the {@link MemoryStack}
     *
     * @param capacity {@link Integer} capacity of the buffer
     * @return {@link IntBuffer}
     */

    public IntBuffer mallocInt(int capacity) {
        return malloc(capacity * Integer.BYTES).asIntBuffer();
    }

    /**
     * Allocates a {@link FloatBuffer} on the {@link MemoryStack}
     *
     * @param capacity {@link Integer} capacity of the buffer
     * @return {@link FloatBuffer}
     */

    public FloatBuffer mallocFloat(int capacity) {
        return malloc(capacity * Float.BYTES).asFloatBuffer();
    }

    /**
     * Allocates a {@link DoubleBuffer} on the {@link MemoryStack}
     *
     * @param capacity {@link Integer} capacity of the buffer
     * @return {@link DoubleBuffer}
     */

    public DoubleBuffer mallocDouble(int capacity) {
        return malloc(capacity * Double.BYTES).asDoubleBuffer();
    }

    /**
     * Allocates a {@link LongBuffer} on the {@link MemoryStack}
     *
     * @param capacity {@link Integer} capacity of the buffer
     * @return {@link LongBuffer}
     */

    public LongBuffer mallocLong(int capacity) {
        return malloc(capacity * Long.BYTES).asLongBuffer();
    }

    /**
     * Frees the provided @{@link Buffer} from the {@link MemoryStack}
     *
     * @param buffer {@link Buffer}
     */

    public void free(Buffer buffer) {
        if (allocateMemory.contains(buffer)) {
            allocateMemory.remove(buffer);
        }
        FT_Free_MemoryStack(buffer);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native ByteBuffer FT_Allocate_MemoryStack(long size, long capacity);

    static native void FT_Free_MemoryStack(Buffer buffer);

}
