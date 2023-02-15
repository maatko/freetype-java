package me.mat.freetype.font;

import me.mat.freetype.Freetype;
import me.mat.freetype.FreetypeException;

public class FreetypeFaceException extends Exception {

    public FreetypeFaceException(String message) {
        super(message);
    }

    /**
     * Creates the {@link FreetypeFaceException}
     *
     * @param message   {@link String} basic explanation of the issue
     * @param errorCode {@link Integer} valid FT_Error code
     * @return {@link FreetypeFaceException}
     */

    public static FreetypeFaceException create(String message, long errorCode) {
        final String error = Freetype.getErrorString((int) errorCode * -1);
        String info = message;
        if (error != null) {
            info += " [" + error + "]";
        }
        return new FreetypeFaceException(info);
    }

}
