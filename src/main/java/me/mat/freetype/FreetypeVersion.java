package me.mat.freetype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FreetypeVersion {

    private final int minor;

    private final int major;

    private final int patch;

}
