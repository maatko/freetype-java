package me.mat.freetype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FreetypeLoadTarget {

    FT_LOAD_TARGET_NORMAL(FreetypeRenderMode.FT_RENDER_MODE_NORMAL),
    FT_LOAD_TARGET_LIGHT(FreetypeRenderMode.FT_RENDER_MODE_LIGHT),
    FT_LOAD_TARGET_MONO(FreetypeRenderMode.FT_RENDER_MODE_MONO),
    FT_LOAD_TARGET_LCD(FreetypeRenderMode.FT_RENDER_MODE_LCD),
    FT_LOAD_TARGET_LCD_V(FreetypeRenderMode.FT_RENDER_MODE_LCD_V),
    FT_LOAD_TARGET_SDF(FreetypeRenderMode.FT_RENDER_MODE_SDF);

    @Getter
    private final FreetypeRenderMode renderMode;

    /**
     * Returns the load flag for the current {@link FreetypeLoadTarget}
     *
     * @return {@link Integer}
     */

    public int get() {
        return renderMode.get();
    }

}
