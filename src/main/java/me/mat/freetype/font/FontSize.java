package me.mat.freetype.font;

import lombok.Getter;
import me.mat.freetype.FreetypeImplementation;

public class FontSize extends FreetypeImplementation {

    @Getter
    private final FontFace fontFace;

    public FontSize(FontFace fontFace, long address) {
        super(address);

        this.fontFace = fontFace;
    }

    /**
     * Metrics for this size object. This field is read-only.
     *
     * @return {@link FontSizeMetrics}
     */

    public FontSizeMetrics getFontSizeMetrics() {
        long address = FT_Metrics_FontSize(this.address);
        if (address == -1)
            return null;
        return new FontSizeMetrics(address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_Metrics_FontSize(long address);

}
