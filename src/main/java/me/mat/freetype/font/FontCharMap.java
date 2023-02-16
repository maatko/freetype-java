package me.mat.freetype.font;

import lombok.Getter;
import me.mat.freetype.FreetypeImplementation;

public class FontCharMap extends FreetypeImplementation {

    @Getter
    private final FontFace fontFace;

    public FontCharMap(FontFace fontFace, long address) {
        super(address);
        this.fontFace = fontFace;
    }

    /**
     * A platform-specific encoding number.
     * This also comes from the TrueType specification and gets emulated similarly.
     *
     * @return {@link Short}
     */

    public short getEncodingID() {
        return FT_Encoding_ID_CharMap(address);
    }

    /**
     * An ID number describing the platform for the following encoding ID.
     * This comes directly from the TrueType specification and gets emulated for other formats.
     *
     * @return {@link Short}
     */

    public short getPlatformID() {
        return FT_Platform_ID_CharMap(address);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native short FT_Platform_ID_CharMap(long address);

    static native short FT_Encoding_ID_CharMap(long address);

}
