package me.mat.freetype.font;

import lombok.Getter;
import me.mat.freetype.MemoryUtil;
import me.mat.freetype.NativeImplementation;

import java.nio.ByteBuffer;

public class Face extends NativeImplementation {

    private final ByteBuffer buffer;

    @Getter
    private final int faceIndex;

    public Face(long address, ByteBuffer buffer, int faceIndex) {
        super(address);

        this.buffer = buffer;
        this.faceIndex = faceIndex;
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
     * Deletes the current font {@link Face}
     *
     * @return {@link Boolean}
     */

    public boolean free() {
        if (buffer != null)
            MemoryUtil.deleteBuffer(buffer);
        return FT_Done_Face(address);
    }

    //////////////////////////////////////////////////////

    static native long FT_Num_Faces(long address);

    static native long FT_Flags_Face(long address);

    static native long FT_Style_Flags_Face(long address);

    static native long FT_Num_Glyphs_Face(long address);

    static native String FT_Family_Name_Face(long address);

    static native String FT_Style_Name_Face(long address);

    static native boolean FT_Done_Face(long address);

}
