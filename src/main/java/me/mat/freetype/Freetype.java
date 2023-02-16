package me.mat.freetype;

import lombok.Getter;
import me.mat.freetype.font.FontFace;
import me.mat.freetype.font.FreetypeFaceException;
import me.mat.freetype.memory.MemoryStack;
import me.mat.freetype.util.NativeImplementation;
import me.mat.freetype.util.OperatingSystem;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Freetype extends NativeImplementation implements FreetypeFlags, AutoCloseable {

    // version of the library itself
    private static final float VERSION = 1.0f;

    private final MemoryStack stack;

    @Getter
    private final FreetypeVersion version;

    public Freetype() throws FreetypeException {
        super(FT_Init_FreeType());

        if (address < 0)
            throw FreetypeException.create("Failed to initialize the Freetype library", address);

        this.stack = new MemoryStack();
        this.version = new FreetypeVersion(0, 0, 0);
        FT_Library_Version(address, this.version);

        System.out.println("|------------------------------|");
        System.out.println("|   FreeType Native Library    |");
        System.out.println("|------------------------------|");
        System.out.println("> Major: " + version.getMajor());
        System.out.println("> Minor: " + version.getMinor());
        System.out.println("> Patch: " + version.getPatch());
        System.out.println("|------------------------------");
    }

    @Override
    public void close() throws FreetypeException {
        // frees all the data that's on the stack
        stack.close();

        long error_code = FT_Done_FreeType(address);
        if (error_code < 0) {
            throw FreetypeException.create("Failed to free the Freetype library", error_code);
        }
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link InputStream}
     *
     * @param inputStream {@link File} file that you want to create the {@link FontFace} from
     * @return {@link FontFace}
     * @throws FreetypeFaceException occurs when something goes wrong with the creation of the {@link FontFace}
     * @throws IOException           occurs when something goes wrong with the creation of the {@link FontFace}
     */

    public FontFace newFontFace(InputStream inputStream) throws FreetypeFaceException, IOException {
        return newFontFace(inputStream, 0);
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link InputStream}
     *
     * @param inputStream {@link File} file that you want to create the {@link FontFace} from
     * @param faceIndex   {@link Integer} index of the face
     * @return {@link FontFace}
     * @throws FreetypeFaceException occurs when something goes wrong with the creation of the {@link FontFace}
     * @throws IOException           occurs when something goes wrong with reading the {@link InputStream}
     */

    public FontFace newFontFace(InputStream inputStream, int faceIndex) throws FreetypeFaceException, IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return newFontFace(buffer.toByteArray(), faceIndex);
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link File}
     *
     * @param file {@link File} file that you want to create the {@link FontFace} from
     * @return {@link FontFace}
     * @throws FreetypeFaceException occurs when something goes wrong with the creation of the {@link FontFace}
     * @throws IOException           occurs when something goes wrong with reading the {@link InputStream}
     */

    public FontFace newFontFace(File file) throws FreetypeFaceException, IOException {
        return newFontFace(file, 0);
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link File}
     *
     * @param file      {@link File} file that you want to create the {@link FontFace} from
     * @param faceIndex {@link Integer} index of the face
     * @return {@link FontFace}
     * @throws FreetypeFaceException occurs when something goes wrong with the creation of the {@link FontFace}
     * @throws IOException           occurs when something goes wrong with reading the {@link InputStream}
     */

    public FontFace newFontFace(File file, int faceIndex) throws FreetypeFaceException, IOException {
        if (!file.exists())
            throw new FreetypeFaceException("'" + file.getAbsolutePath() + "' does not exist");
        return newFontFace(Files.readAllBytes(file.toPath()), faceIndex);
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link Byte} array and
     * the {@link Integer} face index
     *
     * @param bytes     {@link Byte} array that you want to create the {@link FontFace} from
     * @param faceIndex {@link Integer} index of the face
     * @return {@link FontFace}
     * @throws FreetypeFaceException occurs when something goes wrong with the creation of the {@link FontFace}
     */

    private FontFace newFontFace(byte[] bytes, int faceIndex) throws FreetypeFaceException {
        final ByteBuffer buffer = stack.malloc(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        return newFontFace(buffer, faceIndex);
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link ByteBuffer} and
     * the {@link Integer} face index
     *
     * @param buffer    {@link ByteBuffer} that you want to create the {@link FontFace} from
     * @param faceIndex {@link Integer} index of the face
     * @return {@link FontFace}
     * @throws FreetypeFaceException occurs when something goes wrong with the creation of the {@link FontFace}
     */

    private FontFace newFontFace(ByteBuffer buffer, int faceIndex) throws FreetypeFaceException {
        long face = FT_New_Memory_Face(address, buffer, buffer.remaining(), faceIndex);
        if (face <= 0)
            throw FreetypeFaceException.create("Failed to create the FontFace", face);
        return new FontFace(face);
    }

    /**
     * Retrieve the description of a valid FreeType error code.
     * <br>
     * FreeType has to be compiled with `FT_CONFIG_OPTION_ERROR_STRINGS` or
     * `FT_DEBUG_LEVEL_ERROR` to get meaningful descriptions.
     * 'error_string' will be `NULL` otherwise.
     *
     * @param errorCode A valid FreeType error code.
     * @return {@link String}
     */

    public static String getErrorString(int errorCode) {
        return FT_Error_String(errorCode);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_Init_FreeType();

    static native long FT_New_Memory_Face(long address, ByteBuffer buffer, int length, int faceIndex);

    static native String FT_Error_String(int errorCode);

    static native void FT_Library_Version(long address, FreetypeVersion version);

    static native long FT_Done_FreeType(long address);

    static {
        final OperatingSystem operatingSystem = OperatingSystem.getSystem();
        final String libraryName = operatingSystem.getDynamicLibraryName("freetype-java-");
        final File libraryFile;
        try (final InputStream inputStream = Freetype.class.getResourceAsStream(libraryName)) {
            if (inputStream == null) {
                libraryFile = operatingSystem.getDynamicLibrary(
                        new File("target"),
                        "freetype-java-" + VERSION
                );
            } else {
                libraryFile = operatingSystem.getDynamicLibrary(
                        new File(System.getProperty("java.io.tmpdir")),
                        "freetype-java-" + VERSION
                );
                Files.copy(
                        inputStream,
                        libraryFile.toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );
            }
            System.load(libraryFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
