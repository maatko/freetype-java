package me.mat.freetype.glyph;

import me.mat.freetype.FreetypeImplementation;

public class GlyphMetrics extends FreetypeImplementation {

    public GlyphMetrics(long address) {
        super(address);
    }

    /**
     * Advance height for vertical layout.
     * Positive values mean the glyph has a positive advance downward.
     *
     * @return {@link Long}
     */

    public long getVerticalAdvance() {
        return FT_Vert_Advance_GlyphMetrics(address);
    }

    /**
     * Top side bearing for vertical layout.
     * Larger positive values mean further below the vertical glyph origin.
     *
     * @return {@link Long}
     */

    public long getVerticalBearingY() {
        return FT_Vert_BearingY_GlyphMetrics(address);
    }

    /**
     * Left side bearing for vertical layout.
     *
     * @return {@link Long}
     */

    public long getVerticalBearingX() {
        return FT_Vert_BearingX_GlyphMetrics(address);
    }

    /**
     * Advance width for horizontal layout.
     *
     * @return {@link Long}
     */

    public long getHorizontalAdvance() {
        return FT_Hori_Advance_GlyphMetrics(address);
    }

    /**
     * Top side bearing for horizontal layout.
     *
     * @return {@link Long}
     */

    public long getHorizontalBearingY() {
        return FT_Hori_BearingY_GlyphMetrics(address);
    }

    /**
     * Left side bearing for horizontal layout.
     *
     * @return {@link Long}
     */

    public long getHorizontalBearingX() {
        return FT_Hori_BearingX_GlyphMetrics(address);
    }

    /**
     * The glyph's height.
     *
     * @return {@link Long}
     */

    public long getHeight() {
        return FT_Height_GlyphMetrics(address);
    }

    /**
     * The glyph's width.
     *
     * @return {@link Long}
     */

    public long getWidth() {
        return FT_Width_GlyphMetrics(address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_Width_GlyphMetrics(long address);

    static native long FT_Height_GlyphMetrics(long address);

    static native long FT_Hori_BearingX_GlyphMetrics(long address);

    static native long FT_Hori_BearingY_GlyphMetrics(long address);

    static native long FT_Hori_Advance_GlyphMetrics(long address);

    static native long FT_Vert_BearingX_GlyphMetrics(long address);

    static native long FT_Vert_BearingY_GlyphMetrics(long address);

    static native long FT_Vert_Advance_GlyphMetrics(long address);

}
