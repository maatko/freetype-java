package me.mat.freetype.font;

import me.mat.freetype.FreetypeImplementation;

public class FontMatrix extends FreetypeImplementation {

    public FontMatrix(long address) {
        super(address);
    }

    /**
     * Matrix coefficient.
     *
     * @return {@link Long}
     */

    public long getYY() {
        return FT_YY_FontMatrix(address);
    }

    /**
     * Matrix coefficient.
     *
     * @return {@link Long}
     */

    public long getYX() {
        return FT_YX_FontMatrix(address);
    }

    /**
     * Matrix coefficient.
     *
     * @return {@link Long}
     */

    public long getXY() {
        return FT_XY_FontMatrix(address);
    }

    /**
     * Matrix coefficient.
     *
     * @return {@link Long}
     */

    public long getXX() {
        return FT_XX_FontMatrix(address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_XX_FontMatrix(long address);

    static native long FT_XY_FontMatrix(long address);

    static native long FT_YX_FontMatrix(long address);

    static native long FT_YY_FontMatrix(long address);

}
