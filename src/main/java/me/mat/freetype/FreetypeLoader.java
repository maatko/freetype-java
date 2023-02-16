package me.mat.freetype;

import me.mat.freetype.util.OperatingSystem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

final class FreetypeLoader {

    /**
     * Gets {@link File} to the library
     *
     * @param operatingSystem {@link OperatingSystem} operating system that user is running
     * @param library         {@link String} name of the library
     * @param version         {@link String} version of the library
     * @return {@link File}
     */

    static File getLibraryFile(OperatingSystem operatingSystem, String library, float version) {
        final String libraryName = operatingSystem.getDynamicLibraryName(library + "-" + version);
        try {
            getLibraryStream(operatingSystem, library, version);
            return new File(System.getProperty("java.io.tmpdir"), libraryName);
        } catch (IOException e) {
            return new File("target/", libraryName);
        }
    }

    /**
     * Gets the {@link InputStream} for a library
     * by the provided library name & version
     *
     * @param operatingSystem {@link OperatingSystem} operating system that user is running
     * @param library         {@link String} name of the library
     * @param version         {@link String} version of the library
     * @return {@link InputStream}
     * @throws IOException occurs when the {@link InputStream} could not be found
     */

    static InputStream getLibraryStream(OperatingSystem operatingSystem, String library, float version) throws IOException {
        final InputStream inputStream = FreetypeLoader.class.getResourceAsStream(
                "/" + operatingSystem.getDynamicLibraryName(library + "-" + version));
        if (inputStream == null)
            throw new IOException("Failed to locate the library");
        return inputStream;
    }

}
