package me.mat.freetype.font;

import me.mat.freetype.util.NativeImplementation;

public class FontVector extends NativeImplementation {

    public FontVector(long address) {
        super(address);
    }

    /**
     * The vertical coordinate.
     *
     * @return {@link Long}
     */

    public long getY() {
        return FT_Y_FontVector(address);
    }

    /**
     * The horizontal coordinate.
     *
     * @return {@link Long}
     */

    public long getX() {
        return FT_X_FontVector(address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_X_FontVector(long address);

    static native long FT_Y_FontVector(long address);

}
