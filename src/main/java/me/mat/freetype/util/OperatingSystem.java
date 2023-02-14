package me.mat.freetype.util;

import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum OperatingSystem {

    WINDOWS(".dll", "win"),
    LINUX(".so", "nix", "nux", "aix"),
    MAC(".dylib", "mac"),
    SOLARIS(".so", "sunos");

    private final String suffix;

    private final List<String> names;

    OperatingSystem(String suffix, String... names) {
        this.suffix = suffix;
        this.names = new ArrayList<>();
        this.names.addAll(Arrays.asList(names));
    }

    /**
     * Gets the dynamic library path for the
     * provided directory and file name
     *
     * @param directory {@link File} directory that the file is in
     * @param name      {@link String} name of the file
     * @return {@link File} for the current {@link OperatingSystem}
     */

    public File getDynamicLibrary(File directory, String name) {
        return new File(directory, name + suffix);
    }

    /**
     * Gets the current {@link OperatingSystem} that the
     * machine that is building this project is running
     *
     * @return {@link OperatingSystem}
     */

    public static OperatingSystem getSystem() {
        final String name = System.getProperty("os.name").toLowerCase();
        for (OperatingSystem operatingSystem : values()) {
            for (String tag : operatingSystem.names) {
                if (name.contains(tag)) {
                    return operatingSystem;
                }
            }
        }
        return WINDOWS;
    }

}