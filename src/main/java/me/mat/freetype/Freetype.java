package me.mat.freetype;

import me.mat.freetype.font.FontFace;
import me.mat.freetype.util.MemoryUtil;
import me.mat.freetype.util.OperatingSystem;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Freetype {

    private static final float VERSION = 1.0f;

    private static long address;
    private static int faceCount;

    /**
     * Initializes the Freetype library
     */

    public static void init() {
        address = FT_Init_FreeType();
        if (address == -1)
            throw new RuntimeException("Failed to initialize the Freetype library");
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link InputStream}
     *
     * @param inputStream {@link File} file that you want to create the {@link FontFace} from
     * @return {@link FontFace}
     */

    public static FontFace newFontFace(InputStream inputStream) {
        try {
            final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return newFontFace(buffer.toByteArray(), faceCount++);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link File}
     *
     * @param file {@link File} file that you want to create the {@link FontFace} from
     * @return {@link FontFace}
     */

    public static FontFace newFontFace(File file) {
        try {
            byte[] fileData = Files.readAllBytes(file.toPath());
            if (fileData.length == 0)
                return null;
            return newFontFace(fileData, faceCount++);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Creates a new {@link FontFace} object from
     * the provided {@link Byte} array and
     * the {@link Integer} face index
     *
     * @param bytes     {@link Byte} array that you want to create the {@link FontFace} from
     * @param faceIndex {@link Integer} index of the face
     * @return {@link FontFace}
     */

    private static FontFace newFontFace(byte[] bytes, int faceIndex) {
        ByteBuffer buffer = MemoryUtil.createBuffer(bytes.length);
        buffer.order(ByteOrder.nativeOrder());
        buffer.limit(buffer.position() + bytes.length);

        MemoryUtil.fillBuffer(bytes, buffer, bytes.length);
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
     */

    private static FontFace newFontFace(ByteBuffer buffer, int faceIndex) {
        long face = FT_New_Memory_Face(address, buffer, buffer.remaining(), faceIndex);
        if (face <= 0) {
            MemoryUtil.deleteBuffer(buffer);
            return null;
        }
        return new FontFace(face, buffer, faceIndex);
    }

    /**
     * Frees the Freetype library
     */

    public static void free() {
        if (!FT_Done_FreeType(address))
            throw new RuntimeException("Failed to free the FreeType library");
    }

    //////////////////////////////////////////////////////////////////////////////////////

    static native long FT_Init_FreeType();

    static native long FT_New_Memory_Face(long address, ByteBuffer buffer, int length, int faceIndex);

    static native boolean FT_Done_FreeType(long address);

    static {
        final OperatingSystem operatingSystem = OperatingSystem.getSystem();
        final String libraryName = "freetype-java-" + VERSION + operatingSystem.getSuffix();
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
