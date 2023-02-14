package me.mat.freetype.bitmap;

import me.mat.freetype.util.NativeImplementation;

import java.nio.ByteBuffer;

public class Bitmap extends NativeImplementation {

    public Bitmap(long address) {
        super(address);
    }

    /**
     * The pixel mode, i.e., how pixel bits are stored.
     * See FT_Pixel_Mode for possible values.
     *
     * @return {@link Short}
     */

    public short getPixelMode() {
        return FT_Pixel_Mode_Bitmap(address);
    }

    /**
     * This field is only used with FT_PIXEL_MODE_GRAY;
     * it gives the number of gray levels used in the bitmap.
     *
     * @return {@link Integer}
     */

    public int getNumberOfGrays() {
        return FT_Num_Grays_Bitmap(address);
    }

    /**
     * A typeless pointer to the bitmap buffer.
     * This value should be aligned on 32-bit boundaries in most cases.
     *
     * @return {@link ByteBuffer}
     */

    public ByteBuffer getBuffer() {
        return FT_Buffer_Bitmap(address);
    }

    /**
     * The pitch's absolute value is the number of bytes taken by one bitmap row,
     * including padding. However, the pitch is positive when the bitmap has a ‘down’ flow,
     * and negative when it has an ‘up’ flow. In all cases,
     * the pitch is an offset to add to a bitmap pointer in order to go down one row.
     * <p>
     * Note that ‘padding’ means the alignment of a bitmap to a byte border,
     * and FreeType functions normally align to the smallest possible integer value.
     * <p>
     * For the B/W rasterizer, pitch is always an even number.
     * <p>
     * To change the pitch of a bitmap (say, to make it a multiple of 4),
     * use FT_Bitmap_Convert. Alternatively, you might use callback functions to
     * directly render to the application's surface; see the file example2.cpp in the tutorial for a demonstration.
     *
     * @return {@link Integer}
     */

    public int getPitch() {
        return FT_Pitch_Bitmap(address);
    }

    /**
     * The number of pixels in bitmap row.
     *
     * @return {@link Long}
     */

    public long getWidth() {
        return FT_Width_Bitmap(address);
    }

    /**
     * The number of bitmap rows.
     *
     * @return {@link Long}
     */

    public long getRows() {
        return FT_Rows_Bitmap(address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_Rows_Bitmap(long address);

    static native long FT_Width_Bitmap(long address);

    static native int FT_Pitch_Bitmap(long address);

    static native ByteBuffer FT_Buffer_Bitmap(long address);

    static native int FT_Num_Grays_Bitmap(long address);

    static native short FT_Pixel_Mode_Bitmap(long address);

}
