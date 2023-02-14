package me.mat.freetype.util;

import java.nio.ByteBuffer;

public class MemoryUtil {

    public static native ByteBuffer createBuffer(int size);

    public static native void fillBuffer(byte[] bytes, ByteBuffer buffer, int length);

    public static native void deleteBuffer(ByteBuffer buffer);

}
