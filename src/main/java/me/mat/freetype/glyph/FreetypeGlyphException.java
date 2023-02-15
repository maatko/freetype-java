package me.mat.freetype.glyph;

import me.mat.freetype.Freetype;
import me.mat.freetype.FreetypeException;

public class FreetypeGlyphException extends Exception {

    public FreetypeGlyphException(String message) {
        super(message);
    }


    /**
     * Creates the {@link FreetypeGlyphException}
     *
     * @param message   {@link String} basic explanation of the issue
     * @param errorCode {@link Integer} valid FT_Error code
     * @return {@link FreetypeGlyphException}
     */

    public static FreetypeGlyphException create(String message, long errorCode) {
        final String error = Freetype.getErrorString((int) errorCode * -1);
        String info = message;
        if (error != null) {
            info += " [" + error + "]";
        }
        return new FreetypeGlyphException(info);
    }

}
