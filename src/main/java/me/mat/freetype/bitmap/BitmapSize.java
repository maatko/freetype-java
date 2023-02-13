package me.mat.freetype.bitmap;

import me.mat.freetype.NativeImplementation;

public class BitmapSize extends NativeImplementation {

    public BitmapSize(long address) {
        super(address);
    }

    /**
     * The vertical ppem (nominal height) in 26.6 fractional pixels.
     *
     * @return {@link Long}
     */

    public long getYPPM() {
        return FT_Y_PPEM_BitmapSize(address);
    }

    /**
     * The horizontal ppem (nominal width) in 26.6 fractional pixels.
     *
     * @return {@link Long}
     */

    public long getXPPM() {
        return FT_X_PPEM_BitmapSize(address);
    }

    /**
     * The nominal size of the strike in 26.6 fractional points.
     * This field is not very useful.
     *
     * @return {@link Long}
     */

    public long getSize() {
        return FT_Size_BitmapSize(address);
    }

    /**
     * The average width, in pixels, of all glyphs in the strike.
     *
     * @return {@link Short}
     */

    public short getWidth() {
        return FT_Width_BitmapSize(address);
    }

    /**
     * The vertical distance, in pixels,
     * between two consecutive baselines. It is always positive.
     *
     * @return {@link Short}
     */

    public short getHeight() {
        return FT_Height_BitmapSize(address);
    }

    @Override
    public String toString() {
        return "BitmapSize {\n" +
                "height = " + getHeight() + "\n" +
                "width = " + getWidth() + "\n" +
                "size = " + getSize() + "\n" +
                "x_ppm = " + getXPPM() + "\n" +
                "y_ppm = " + getYPPM() + "\n" +
                "}\n";
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native short FT_Height_BitmapSize(long address);

    static native short FT_Width_BitmapSize(long address);

    static native long FT_Size_BitmapSize(long address);

    static native long FT_X_PPEM_BitmapSize(long address);

    static native long FT_Y_PPEM_BitmapSize(long address);


}
