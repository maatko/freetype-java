package me.mat.freetype;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FreetypeEncoding {

    FT_ENCODING_NONE(0, 0, 0, 0),
    FT_ENCODING_MS_SYMBOL('s', 'y', 'm', 'b'),
    FT_ENCODING_UNICODE('u', 'n', 'i', 'c'),
    FT_ENCODING_SJIS('s', 'j', 'i', 's'),
    FT_ENCODING_PRC('g', 'b', ' ', ' '),
    FT_ENCODING_BIG5('b', 'i', 'g', '5'),
    FT_ENCODING_WANSUNG('w', 'a', 'n', 's'),
    FT_ENCODING_JOHAB('j', 'o', 'h', 'a'),

    /* for backward compatibility */
    FT_ENCODING_GB2312('g', 'b', ' ', ' '),
    FT_ENCODING_MS_SJIS('s', 'j', 'i', 's'),
    FT_ENCODING_MS_GB2312('g', 'b', ' ', ' '),
    FT_ENCODING_MS_BIG5('b', 'i', 'g', '5'),
    FT_ENCODING_MS_WANSUNG('w', 'a', 'n', 's'),
    FT_ENCODING_MS_JOHAB('j', 'o', 'h', 'a'),

    FT_ENCODING_ADOBE_STANDARD('A', 'D', 'O', 'B'),
    FT_ENCODING_ADOBE_EXPERT('A', 'D', 'B', 'E'),
    FT_ENCODING_ADOBE_CUSTOM('A', 'D', 'B', 'C'),
    FT_ENCODING_ADOBE_LATIN_1('l', 'a', 't', '1'),
    FT_ENCODING_OLD_LATIN_2('l', 'a', 't', '2'),
    FT_ENCODING_APPLE_ROMAN('a', 'r', 'm', 'n');

    private final int a;

    private final int b;

    private final int c;

    private final int d;

    /**
     * Gets the encoding
     *
     * @return {@link Integer}
     */

    public int get() {
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

}
