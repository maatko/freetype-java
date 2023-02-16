package me.mat.freetype.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class NativeImplementation {

    @Getter
    protected final long address;

}
