package me.mat.freetype;

public class FreetypeException extends Exception {

    protected FreetypeException(String message) {
        super(message);
    }

    /**
     * Creates the {@link FreetypeException}
     *
     * @param message   {@link String} basic explanation of the issue
     * @param errorCode {@link Integer} valid FT_Error code
     * @return {@link FreetypeException}
     */

    public static FreetypeException create(String message, long errorCode) {
        final String error = Freetype.getErrorString((int) errorCode * -1);
        String info = message;
        if (error != null) {
            info += " [" + error + "]";
        }
        return new FreetypeException(info);
    }

}
