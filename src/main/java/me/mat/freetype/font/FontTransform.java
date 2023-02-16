package me.mat.freetype.font;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FontTransform {

    private final FontMatrix matrix;

    private final FontVector delta;

}
