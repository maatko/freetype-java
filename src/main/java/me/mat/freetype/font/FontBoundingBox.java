package me.mat.freetype.font;

import me.mat.freetype.NativeImplementation;

public class FontBoundingBox extends NativeImplementation {

    public FontBoundingBox(long address) {
        super(address);
    }

    /**
     * The vertical maximum (top-most).
     *
     * @return {@link Long}
     */

    public long getYMax() {
        return FT_Y_MAX_BBox(address);
    }

    /**
     * The horizontal maximum (right-most).
     *
     * @return {@link Long}
     */

    public long getXMax() {
        return FT_X_MAX_BBox(address);
    }

    /**
     * The vertical minimum (bottom-most).
     *
     * @return {@link Long}
     */

    public long getYMin() {
        return FT_Y_MIN_BBox(address);
    }

    /**
     * The horizontal minimum (left-most).
     *
     * @return {@link Long}
     */

    public long getXMin() {
        return FT_X_MIN_BBox(address);
    }

    @Override
    public String toString() {
        return "FontBoundingBox {\n" +
                "\txMin = " + getXMin() + "\n" +
                "\tyMin = " + getYMin() + "\n" +
                "\txMax = " + getXMax() + "\n" +
                "\tyMax = " + getYMax() + "\n" +
                "}\n";
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_X_MIN_BBox(long address);

    static native long FT_Y_MIN_BBox(long address);

    static native long FT_X_MAX_BBox(long address);

    static native long FT_Y_MAX_BBox(long address);

}
