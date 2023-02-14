package me.mat.freetype;

interface FreetypeFlags {

    ////////////////////////////////////////////////////////////////////
    // >>>>>>>>> FACE FLAGS
    ////////////////////////////////////////////////////////////////////

    int FT_FACE_FLAG_SCALABLE = 1;
    int FT_FACE_FLAG_FIXED_SIZES = (1 << 1);
    int FT_FACE_FLAG_FIXED_WIDTH = (1 << 2);
    int FT_FACE_FLAG_SFNT = (1 << 3);
    int FT_FACE_FLAG_HORIZONTAL = (1 << 4);
    int FT_FACE_FLAG_VERTICAL = (1 << 5);
    int FT_FACE_FLAG_KERNING = (1 << 6);
    int FT_FACE_FLAG_FAST_GLYPHS = (1 << 7);
    int FT_FACE_FLAG_MULTIPLE_MASTERS = (1 << 8);
    int FT_FACE_FLAG_GLYPH_NAMES = (1 << 9);
    int FT_FACE_FLAG_EXTERNAL_STREAM = (1 << 10);
    int FT_FACE_FLAG_HINTER = (1 << 11);
    int FT_FACE_FLAG_CID_KEYED = (1 << 12);
    int FT_FACE_FLAG_TRICKY = (1 << 13);
    int FT_FACE_FLAG_COLOR = (1 << 14);
    int FT_FACE_FLAG_VARIATION = (1 << 15);
    int FT_FACE_FLAG_SVG = (1 << 16);
    int FT_FACE_FLAG_SBIX = (1 << 17);
    int FT_FACE_FLAG_SBIX_OVERLAY = (1 << 18);

    ////////////////////////////////////////////////////////////////////
    // >>>>>>>>> STYLE FLAGS
    ////////////////////////////////////////////////////////////////////

    int FT_STYLE_FLAG_ITALIC = 1;
    int FT_STYLE_FLAG_BOLD = (1 << 1);

    ////////////////////////////////////////////////////////////////////
    // >>>>>>>>> OPEN FLAGS
    ////////////////////////////////////////////////////////////////////

    int FT_OPEN_MEMORY = 0x1;
    int FT_OPEN_STREAM = 0x2;
    int FT_OPEN_PATHNAME = 0x4;
    int FT_OPEN_DRIVER = 0x8;
    int FT_OPEN_PARAMS = 0x10;

    ////////////////////////////////////////////////////////////////////
    // >>>>>>>>> LOAD FLAGS
    ////////////////////////////////////////////////////////////////////

    int FT_LOAD_DEFAULT = 0x0;
    int FT_LOAD_NO_SCALE = 1;
    int FT_LOAD_NO_HINTING = (1 << 1);
    int FT_LOAD_RENDER = (1 << 2);
    int FT_LOAD_NO_BITMAP = (1 << 3);
    int FT_LOAD_VERTICAL_LAYOUT = (1 << 4);
    int FT_LOAD_FORCE_AUTOHINT = (1 << 5);
    int FT_LOAD_CROP_BITMAP = (1 << 6);
    int FT_LOAD_PEDANTIC = (1 << 7);
    int FT_LOAD_IGNORE_GLOBAL_ADVANCE_WIDTH = (1 << 9);
    int FT_LOAD_NO_RECURSE = (1 << 10);
    int FT_LOAD_IGNORE_TRANSFORM = (1 << 11);
    int FT_LOAD_MONOCHROME = (1 << 12);
    int FT_LOAD_LINEAR_DESIGN = (1 << 13);
    int FT_LOAD_SBITS_ONLY = (1 << 14);
    int FT_LOAD_NO_AUTOHINT = (1 << 15);

    /* Bits 16-19 are used by `FT_LOAD_TARGET_` */
    int FT_LOAD_COLOR = (1 << 20);
    int FT_LOAD_COMPUTE_METRICS = (1 << 21);
    int FT_LOAD_BITMAP_METRICS_ONLY = (1 << 22);

    /* used internally only by certain font drivers */
    int FT_LOAD_ADVANCE_ONLY = (1 << 8);
    int FT_LOAD_SVG_ONLY = (1 << 23);

    ////////////////////////////////////////////////////////////////////
    // >>>>>>>>> SUB GLYPH FLAGS
    ////////////////////////////////////////////////////////////////////

    int FT_SUBGLYPH_FLAG_ARGS_ARE_WORDS = 1;
    int FT_SUBGLYPH_FLAG_ARGS_ARE_XY_VALUES = 2;
    int FT_SUBGLYPH_FLAG_ROUND_XY_TO_GRID = 4;
    int FT_SUBGLYPH_FLAG_SCALE = 8;
    int FT_SUBGLYPH_FLAG_XY_SCALE = 0x40;
    int FT_SUBGLYPH_FLAG_2X2 = 0x80;
    int FT_SUBGLYPH_FLAG_USE_MY_METRICS = 0x200;

    ////////////////////////////////////////////////////////////////////
    // >>>>>>>>> FS TYPE FLAGS
    ////////////////////////////////////////////////////////////////////

    int FT_FSTYPE_INSTALLABLE_EMBEDDING = 0x0000;
    int FT_FSTYPE_RESTRICTED_LICENSE_EMBEDDING = 0x0002;
    int FT_FSTYPE_PREVIEW_AND_PRINT_EMBEDDING = 0x0004;
    int FT_FSTYPE_EDITABLE_EMBEDDING = 0x0008;
    int FT_FSTYPE_NO_SUBSETTING = 0x0100;
    int FT_FSTYPE_BITMAP_EMBEDDING_ONLY = 0x0200;

}
