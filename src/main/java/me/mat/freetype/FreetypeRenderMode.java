package me.mat.freetype;

public enum FreetypeRenderMode {

    FT_RENDER_MODE_NORMAL,
    FT_RENDER_MODE_LIGHT,
    FT_RENDER_MODE_MONO,
    FT_RENDER_MODE_LCD,
    FT_RENDER_MODE_LCD_V,
    FT_RENDER_MODE_SDF,

    FT_RENDER_MODE_MAX;

    /**
     * Calculates the load flag for the current {@link FreetypeRenderMode}
     * <br>
     * You should use only _one_ of the {@link FreetypeRenderMode} values in your
     * `load_flags`.  They can't be ORed.
     *
     * @return {@link Integer}
     */

    public int get() {
        return (ordinal() & 15) << 16;
    }

}
