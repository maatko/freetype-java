package me.mat.freetype.font;

import me.mat.freetype.FreetypeImplementation;

public class FontSizeMetrics extends FreetypeImplementation {

    public FontSizeMetrics(long address) {
        super(address);
    }

    /**
     * The maximum advance width in 26.6 fractional pixels,
     * rounded to an integer value. See {@link FontFace} for the details.
     * <p>
     * <br>
     * max horizontal advance, in 26.6 pixels
     *
     * @return {@link Long}
     */

    public long getMaxAdvance() {
        return FT_Max_Advance_FontSizeMetrics(address);
    }

    /**
     * The height in 26.6 fractional pixels,
     * rounded to an integer value. See {@link FontFace} for the details.
     * <p>
     * <br>
     * text height in 26.6 frac. pixels
     *
     * @return {@link Long}
     */

    public long getHeight() {
        return FT_Height_FontSizeMetrics(address);
    }

    /**
     * The descender in 26.6 fractional pixels,
     * rounded down to an integer value. See {@link FontFace} for the details.
     * <p>
     * <br>
     * descender in 26.6 frac. pixels
     *
     * @return {@link Long}
     */

    public long getDescender() {
        return FT_Descender_FontSizeMetrics(address);
    }

    /**
     * The ascender in 26.6 fractional pixels,
     * rounded up to an integer value. See {@link FontFace} for the details.
     * <p>
     * <br>
     * ascender in 26.6 frac. pixels
     *
     * @return {@link Long}
     */

    public long getAscender() {
        return FT_Ascender_FontSizeMetrics(address);
    }

    /**
     * A 16.16 fractional scaling value to convert vertical metrics from font units to 26.6
     * fractional pixels. Only relevant for scalable font formats.
     * <p>
     * <br>
     * units to 26.6 fractional pixels
     *
     * @return {@link Long}
     */

    public long getYScale() {
        return FT_Y_Scale_FontSizeMetrics(address);
    }

    /**
     * A 16.16 fractional scaling value to convert horizontal metrics from font units to 26.6
     * fractional pixels. Only relevant for scalable font formats.
     * <p>
     * <br>
     * scaling values used to convert font
     *
     * @return {@link Long}
     */

    public long getXScale() {
        return FT_X_Scale_FontSizeMetrics(address);
    }

    /**
     * The height of the scaled EM square in pixels,
     * hence the term ‘ppem’ (pixels per EM).
     * It is also referred to as ‘nominal height’.
     * <p>
     * <br>
     * vertical pixels per EM
     *
     * @return {@link Integer}
     */

    public int getYPPEM() {
        return FT_Y_PPEM_FontSizeMetrics(address);
    }

    /**
     * The width of the scaled EM square in pixels,
     * hence the term ‘ppem’ (pixels per EM).
     * It is also referred to as ‘nominal width’.
     * <p>
     * <br>
     * horizontal pixels per EM
     *
     * @return {@link Integer}
     */

    public int getXPPEM() {
        return FT_X_PPEM_FontSizeMetrics(address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native int FT_X_PPEM_FontSizeMetrics(long address);

    static native int FT_Y_PPEM_FontSizeMetrics(long address);

    static native long FT_X_Scale_FontSizeMetrics(long address);

    static native long FT_Y_Scale_FontSizeMetrics(long address);

    static native long FT_Ascender_FontSizeMetrics(long address);

    static native long FT_Descender_FontSizeMetrics(long address);

    static native long FT_Height_FontSizeMetrics(long address);

    static native long FT_Max_Advance_FontSizeMetrics(long address);

}
