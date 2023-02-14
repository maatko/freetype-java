package me.mat.freetype.glyph;

import lombok.Getter;
import me.mat.freetype.bitmap.Bitmap;
import me.mat.freetype.font.FontFace;
import me.mat.freetype.font.FontVector;
import me.mat.freetype.util.NativeImplementation;

public class GlyphSlot extends NativeImplementation {

    @Getter
    private final FontFace fontFace;

    public GlyphSlot(FontFace fontFace, long address) {
        super(address);

        this.fontFace = fontFace;
    }

    /**
     * The bitmap's top bearing expressed in integer pixels.
     * This is the distance from the baseline to the top-most glyph scanline,
     * upwards y coordinates being positive.
     *
     * @return {@link Integer}
     */

    public int getBitmapTop() {
        return FT_Bitmap_Top_GlyphSlot(address);
    }

    /**
     * The bitmap's left bearing expressed in integer pixels.
     *
     * @return {@link Integer}
     */

    public int getBitmapLeft() {
        return FT_Bitmap_Left_GlyphSlot(address);
    }

    /**
     * This field is used as a bitmap descriptor.
     * Note that the address and content of the bitmap buffer can change between
     * calls of FT_Load_Glyph and a few other functions.
     *
     * @return {@link Bitmap}
     */

    public Bitmap getBitmap() {
        long address = FT_Bitmap_GlyphSlot(this.address);
        if (address == -1)
            return null;
        return new Bitmap(address);
    }

    /**
     * This shorthand is, depending on FT_LOAD_IGNORE_TRANSFORM,
     * the transformed (hinted) advance width for the glyph, in 26.6 fractional pixel format.
     * As specified with FT_LOAD_VERTICAL_LAYOUT,
     * it uses either the horiAdvance or the vertAdvance value of metrics field.
     *
     * @return {@link FontVector}
     */

    public FontVector getAdvance() {
        long address = FT_Advance_GlyphSlot(this.address);
        if (address == -1)
            return null;
        return new FontVector(address);
    }

    /**
     * The advance height of the unhinted glyph. Its value is expressed in 16.16 fractional pixels,
     * unless FT_LOAD_LINEAR_DESIGN is set when loading the glyph.
     * This field can be important to perform correct WYSIWYG layout. Only relevant for scalable glyphs.
     *
     * @return {@link Long}
     */

    public long getAdvanceHeight() {
        return FT_Linear_Vert_Advance_GlyphSlot(address);
    }

    /**
     * The advance width of the unhinted glyph. Its value is expressed in 16.16 fractional pixels,
     * unless FT_LOAD_LINEAR_DESIGN is set when loading the glyph.
     * This field can be important to perform correct WYSIWYG layout. Only relevant for scalable glyphs.
     *
     * @return {@link Long}
     */

    public long getAdvanceWidth() {
        return FT_Linear_Hori_Advance_GlyphSlot(address);
    }

    /**
     * The metrics of the last loaded glyph in the slot.
     * The returned values depend on the last load flags (see the FT_Load_Glyph API function)
     * and can be expressed either in 26.6 fractional pixels or font units.
     * <p>
     * Note that even when the glyph image is transformed, the metrics are not.
     *
     * @return {@link GlyphMetrics}
     */

    public GlyphMetrics getGlyphMetrics() {
        long address = FT_Metrics_GlyphSlot(this.address);
        if (address == -1)
            return null;
        return new GlyphMetrics(address);
    }

    /**
     * [Since 2.10] The glyph index passed as an argument
     * to FT_Load_Glyph while initializing the glyph slot.
     *
     * @return {@link Integer}
     */

    public int getGlyphIndex() {
        return FT_Glyph_Index_GlyphSlot(address);
    }

    /**
     * In some cases (like some font tools), several glyph slots per face object can be a good thing.
     * As this is rare, the glyph slots are listed through a direct,
     * single-linked list using its next field.
     *
     * @return {@link GlyphSlot}
     */

    public GlyphSlot getNextGlyphSlot() {
        long address = FT_Next_GlyphSlot(this.address);
        if (address == -1)
            return null;
        return new GlyphSlot(fontFace, address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_Next_GlyphSlot(long address);

    static native int FT_Glyph_Index_GlyphSlot(long address);

    static native long FT_Metrics_GlyphSlot(long address);

    static native long FT_Linear_Hori_Advance_GlyphSlot(long address);

    static native long FT_Linear_Vert_Advance_GlyphSlot(long address);

    static native long FT_Advance_GlyphSlot(long address);

    static native long FT_Bitmap_GlyphSlot(long address);

    static native int FT_Bitmap_Left_GlyphSlot(long address);

    static native int FT_Bitmap_Top_GlyphSlot(long address);

}
