package me.mat.freetype.font;

import lombok.Getter;
import me.mat.freetype.bitmap.BitmapSize;
import me.mat.freetype.glyph.GlyphSlot;
import me.mat.freetype.util.MemoryUtil;
import me.mat.freetype.util.NativeImplementation;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class FontFace extends NativeImplementation {

    private final ByteBuffer buffer;

    @Getter
    private final int faceIndex;

    public FontFace(long address, ByteBuffer buffer, int faceIndex) {
        super(address);

        this.buffer = buffer;
        this.faceIndex = faceIndex;
    }

    /**
     * Return a zero-terminated list of Unicode variation selectors found for
     * the specified character code.
     *
     * @param charCode The character codepoint in Unicode.
     * @return An array of variation selector code points that are
     * active for the given character, or `NULL` if the corresponding list is
     * empty.
     * @apiNote The last item in the array is~0; the array is owned by the @FT_Face
     * object but can be overwritten or released on the next call to a
     * FreeType function.
     */

    public int[] getVariantsOfChar(long charCode) {
        return FT_Face_GetVariantsOfChar(address, charCode);
    }

    /**
     * Return a zero-terminated list of Unicode variation selectors found in
     * the font.
     *
     * @return An array of selector code points, or `NULL` if there is
     * *   no valid variation selector cmap subtable.
     * @apiNote The last item in the array is~0; the array is owned by the @FT_Face
     * object but can be overwritten or released on the next call to a
     * FreeType function.
     */

    public int[] getVariantSelectors() {
        return FT_Face_GetVariantSelectors(address);
    }

    /**
     * Check whether this variation of this Unicode character is the one to
     * be found in the charmap.
     *
     * @param charCode        The character codepoint in Unicode.
     * @param variantSelector The Unicode codepoint of the variation selector.
     * @return 1~if found in the standard (Unicode) cmap, 0~if found in the variation
     * selector cmap, or -1 if it is not a variation.
     * @apiNote This function is only meaningful if the font has a variation selector
     * cmap subtable.
     */

    public int getCharVariantIsDefault(long charCode, long variantSelector) {
        return FT_Face_GetCharVariantIsDefault(address, charCode, variantSelector);
    }

    /**
     * Return the glyph index of a given character code as modified by the
     * variation selector.
     *
     * @param charCode        The character code point in Unicode.
     * @param variantSelector The Unicode code point of the variation selector.
     * @return The glyph index.  0~means either 'undefined character code', or
     * 'undefined selector code', or 'no variation selector cmap subtable',
     * or 'current CharMap is not Unicode'.
     * @apiNote *   If you use FreeType to manipulate the contents of font files directly,
     * be aware that the glyph index returned by this function doesn't always
     * correspond to the internal indices used within the file.  This is done
     * to ensure that value~0 always corresponds to the 'missing glyph'.
     * <p>
     * This function is only meaningful if <br>
     * a) the font has a variation selector cmap sub table, and <br>
     * b) the current charmap has a Unicode encoding.
     */

    public int getCharVariantIndex(long charCode, long variantSelector) {
        return FT_Face_GetCharVariantIndex(address, charCode, variantSelector);
    }

    /**
     * Return a zero-terminated list of Unicode character codes found for the
     * specified variation selector.
     *
     * @param variantSelector The variation selector code point in Unicode.
     * @return A list of all the {@link Integer} code points that are specified by this selector
     * (both default and non-default codes are returned) or `NULL` if there
     * is no valid cmap or the variation selector is invalid.
     * @apiNote The last item in the array is~0; the array is owned by the @FT_Face
     * object but can be overwritten or released on the next call to a
     * FreeType function.
     */

    public int[] getCharsOfVariant(long variantSelector) {
        return FT_Face_GetCharsOfVariant(address, variantSelector);
    }

    /**
     * Deprecated, does nothing.
     *
     * @return {@link Boolean} Always returns false.
     */

    @Deprecated
    public boolean checkTrueTypePatents() {
        return FT_Face_CheckTrueTypePatents(address);
    }

    /**
     * The current active charmap for this face.
     *
     * @return {@link FontCharMap}
     */

    public FontCharMap getCharMap() {
        long address = FT_CharMap_Face(this.address);
        if (address == -1)
            return null;
        return new FontCharMap(this, address);
    }

    /**
     * The current active size for this face.
     *
     * @return {@link FontSize}
     */

    public FontSize getFontSize() {
        long address = FT_Size_Face(this.address);
        if (address == -1)
            return null;
        return new FontSize(this, address);
    }

    /**
     * The face's associated glyph slot(s).
     *
     * @return {@link GlyphSlot}
     */

    public GlyphSlot getGlyphSlot() {
        long address = FT_Glyph_Face(this.address);
        if (address == -1)
            return null;
        return new GlyphSlot(this, address);
    }

    /**
     * The thickness, in font units, of the underline for this face.
     * Only relevant for scalable formats.
     *
     * @return {@link Short}
     */

    public short getUnderlineThickness() {
        return FT_Underline_Thickness_Face(address);
    }

    /**
     * The position, in font units, of the underline line for this face.
     * It is the center of the underlining stem. Only relevant for scalable formats.
     *
     * @return {@link Short}
     */

    public short getUnderlinePosition() {
        return FT_Underline_Position_Face(address);
    }

    /**
     * The maximum advance height, in font units, for all glyphs in this face.
     * This is only relevant for vertical layouts,
     * and is set to height for fonts that do not provide vertical metrics.
     * Only relevant for scalable formats.
     *
     * @return {@link Short}
     */

    public short getMaxAdvanceHeight() {
        return FT_Max_Advance_Height_Face(address);
    }

    /**
     * The maximum advance width, in font units, for all glyphs in this face.
     * This can be used to make word wrapping computations faster.
     * Only relevant for scalable formats.
     *
     * @return {@link Short}
     */

    public short getMaxAdvanceWidth() {
        return FT_Max_Advance_Width_Face(address);
    }

    /**
     * This value is the vertical distance between two consecutive baselines,
     * expressed in font units. It is always positive. Only relevant for scalable formats.
     * <p>
     * If you want the global glyph height, use ascender - descender.
     *
     * @return {@link Short}
     */

    public short getHeight() {
        return FT_Height_Face(address);
    }

    /**
     * The typographic descender of the face, expressed in font units.
     * For font formats not having this information, it is set to bbox.yMin.
     * Note that this field is negative for values below the baseline.
     * Only relevant for scalable formats.
     *
     * @return {@link Short}
     */

    public short getDescender() {
        return FT_Descender_Face(address);
    }

    /**
     * The typographic ascender of the face, expressed in font units.
     * For font formats not having this information,
     * it is set to bbox.yMax. Only relevant for scalable formats.
     *
     * @return {@link Short}
     */

    public short getAscender() {
        return FT_Ascender_Face(address);
    }

    /**
     * The number of font units per EM square for this face. This is typically 2048 for TrueType fonts,
     * and 1000 for Type 1 fonts. Only relevant for scalable formats.
     *
     * @return {@link Short}
     */

    public short getUnitsPerEM() {
        return FT_Units_Per_EM_Face(address);
    }

    /**
     * The font bounding box. Coordinates are expressed in font units (see units_per_EM).
     * The box is large enough to contain any glyph from the font. Thus,
     * bbox.yMax can be seen as the ‘maximum ascender’, and bbox.yMin as the ‘minimum descender’.
     * Only relevant for scalable formats.
     * <p>
     * Note that the bounding box might be off by (at least) one pixel for hinted fonts.
     * See FT_Size_Metrics for further discussion.
     * <p>
     * Note that the bounding box does not vary in
     * OpenType variable fonts and should only be used in relation to the default instance.
     *
     * @return {@link FontBoundingBox}
     */

    public FontBoundingBox getFontBoundingBox() {
        return new FontBoundingBox(FT_BBox_Face(address));
    }

    /**
     * An array of the char maps of the face.
     *
     * @return Array of {@link FontCharMap}
     */

    public FontCharMap[] getCharacterMaps() {
        final long[] maps = FT_CharMaps_Face(address);
        if (maps == null || maps.length == 0)
            return new FontCharMap[0];
        FontCharMap[] fontCharMaps = new FontCharMap[maps.length];
        for (int i = 0; i < fontCharMaps.length; i++) {
            fontCharMaps[i] = new FontCharMap(this, maps[i]);
        }
        return fontCharMaps;
    }

    /**
     * The number of char maps in the face.
     *
     * @return {@link Integer}
     */

    public int getNumberOfCharacterMaps() {
        return FT_Num_CharMaps_Face(address);
    }

    /**
     * An array of {@link BitmapSize} for all bitmap strikes in the face.
     * It is set to NULL if there is no bitmap strike.
     * <p>
     * Note that FreeType tries to sanitize the strike data since they are sometimes sloppy or incorrect,
     * but this can easily fail.
     *
     * @return Array of {@link BitmapSize}
     */

    public BitmapSize[] getAvailableSizes() {
        final long[] sizes = FT_Available_Sizes_Face(address);
        if (sizes == null || sizes.length == 0)
            return new BitmapSize[0];
        final BitmapSize[] bitmapSizes = new BitmapSize[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            bitmapSizes[i] = new BitmapSize(sizes[i]);
        }
        return bitmapSizes;
    }

    /**
     * The number of bitmap strikes in the face.
     * Even if the face is scalable, there might still be bitmap strikes,
     * which are called ‘sbits’ in that case.
     *
     * @return {@link Integer}
     */

    public int getBitmapStrikes() {
        return FT_Num_Fixed_Sizes_Face(address);
    }

    /**
     * The face's style name. This is an ASCII string,
     * usually in English, that describes the typeface's style (like ‘Italic’, ‘Bold’, ‘Condensed’, etc).
     * Not all font formats provide a style name, so this field is optional,
     * and can be set to NULL. As for family_name,
     * some formats provide localized and Unicode versions of this string.
     * Applications should use the format-specific interface to access them.
     *
     * @return {@link String}
     */

    public String getStyleName() {
        return FT_Style_Name_Face(address);
    }

    /**
     * The face's family name. This is an ASCII string, usually in English,
     * that describes the typeface's family (like ‘Times New Roman’, ‘Bodoni’, ‘Garamond’, etc).
     * This is the least common denominator used to list fonts.
     * Some formats (TrueType & OpenType) provide localized and Unicode versions of this string.
     * Applications should use the format-specific interface to access them.
     * Can be NULL (e.g., in fonts embedded in a PDF file).
     * <p>
     * In case the font doesn't provide a specific family name entry,
     * FreeType tries to synthesize one, deriving it from other name entries.
     *
     * @return {@link String}
     */

    public String getFamilyName() {
        return FT_Family_Name_Face(address);
    }

    /**
     * The number of glyphs in the face. If the face is scalable and has sbits (see num_fixed_sizes),
     * it is set to the number of outline glyphs.
     * <p>
     * For CID-keyed fonts (not in an SFNT wrapper) this value gives the highest CID used in the font.
     *
     * @return {@link Long}
     */

    public long getNumberOfGlyphs() {
        return FT_Num_Glyphs_Face(address);
    }

    /**
     * The lower 16 bits contain a set of bit flags indicating the style of the face;
     * see FT_STYLE_FLAG_XXX for the details.
     * <p>
     * [Since 2.6.1] Bits 16-30 hold the number of named instances available
     * for the current face if we have a GX or OpenType variation (sub)font.
     * Bit 31 is always zero (this is, style_flags is always a positive value).
     * Note that a variation font has always at least one named instance, namely the default instance.
     *
     * @return {@link Long}
     */

    public long getStyleFlags() {
        return FT_Style_Flags_Face(address);
    }

    /**
     * A set of bit flags that give important information about the face;
     * see FT_FACE_FLAG_XXX for the details.
     *
     * @return {@link Long}
     */

    public long getFaceFlags() {
        return FT_Flags_Face(address);
    }

    /**
     * Returns the number of faces in the font file.
     * Some font formats can have multiple faces in a single font file.
     *
     * @return {@link Long}
     */

    public long getNumberOfFaces() {
        return FT_Num_Faces(address);
    }

    /**
     * Deletes the current font {@link FontFace}
     *
     * @return {@link Boolean}
     */

    public boolean free() {
        if (buffer != null)
            MemoryUtil.deleteBuffer(buffer);
        return FT_Done_Face(address);
    }

    @Override
    public String toString() {
        return "FontFace {\n" +
                "\tnum_faces = " + getNumberOfFaces() + "\n" +
                "\tface_index = " + getFaceIndex() + "\n" +
                "\tface_flags = " + getFaceFlags() + "\n" +
                "\tstyle_flags = " + getStyleFlags() + "\n" +
                "\tnum_glyphs = " + getNumberOfGlyphs() + "\n" +
                "\tfamily_name = " + getFamilyName() + "\n" +
                "\tstyle_name = " + getStyleName() + "\n" +
                "\tnum_fixed_sizes = " + getBitmapStrikes() + "\n" +
                "\tavailable_sizes = " + Arrays.toString(getAvailableSizes()) + "\n" +
                "\tnum_charmaps = " + getNumberOfCharacterMaps() + "\n" +
                "\tcharmaps = " + Arrays.toString(getCharacterMaps()) + "\n" +
                "\tbbox = \n" + getFontBoundingBox() +
                "\tunits_per_EM = " + getUnitsPerEM() + "\n" +
                "\tascender = " + getAscender() + "\n" +
                "\tdescender = " + getDescender() + "\n" +
                "\theight = " + getHeight() + "\n" +
                "\tmax_advance_width = " + getMaxAdvanceWidth() + "\n" +
                "\tmax_advance_height = " + getMaxAdvanceHeight() + "\n" +
                "\tunderline_position = " + getUnderlinePosition() + "\n" +
                "\tunderline_thickness =" + getUnderlineThickness() + "\n" +
                "\tglyph = " + getGlyphSlot() + "\n" +
                "\tsize = " + getFontSize() + "\n" +
                "\tcharmap = " + getCharMap() + "\n" +
                "}\n";
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_Num_Faces(long address);

    static native long FT_Flags_Face(long address);

    static native long FT_Style_Flags_Face(long address);

    static native long FT_Num_Glyphs_Face(long address);

    static native String FT_Family_Name_Face(long address);

    static native String FT_Style_Name_Face(long address);

    static native int FT_Num_Fixed_Sizes_Face(long address);

    static native long[] FT_Available_Sizes_Face(long address);

    static native int FT_Num_CharMaps_Face(long address);

    static native long[] FT_CharMaps_Face(long address);

    static native long FT_BBox_Face(long address);

    static native short FT_Units_Per_EM_Face(long address);

    static native short FT_Ascender_Face(long address);

    static native short FT_Descender_Face(long address);

    static native short FT_Height_Face(long address);

    static native short FT_Max_Advance_Width_Face(long address);

    static native short FT_Max_Advance_Height_Face(long address);

    static native short FT_Underline_Position_Face(long address);

    static native short FT_Underline_Thickness_Face(long address);

    static native long FT_Glyph_Face(long address);

    static native long FT_Size_Face(long address);

    static native long FT_CharMap_Face(long address);

    static native boolean FT_Done_Face(long address);

    static native boolean FT_Face_CheckTrueTypePatents(long address);

    static native int[] FT_Face_GetCharsOfVariant(long address, long variantSelector);

    static native int FT_Face_GetCharVariantIndex(long address, long charCode, long variantSelector);

    static native int FT_Face_GetCharVariantIsDefault(long address, long charCode, long variantSelector);

    static native int[] FT_Face_GetVariantSelectors(long address);

    static native int[] FT_Face_GetVariantsOfChar(long address, long charCode);

}
