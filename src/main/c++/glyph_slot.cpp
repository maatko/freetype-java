#include <me_mat_freetype_glyph_GlyphSlot.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Next_GlyphSlot
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Next_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)slot->next;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Glyph_Index_GlyphSlot
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Glyph_1Index_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)slot->glyph_index;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Metrics_GlyphSlot
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Metrics_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)&slot->metrics;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Linear_Hori_Advance_GlyphSlot
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Linear_1Hori_1Advance_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)slot->linearHoriAdvance;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Linear_Vert_Advance_GlyphSlot
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Linear_1Vert_1Advance_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)slot->linearVertAdvance;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Advance_GlyphSlot
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Advance_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)&slot->advance;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Bitmap_GlyphSlot
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Bitmap_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)&slot->bitmap;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Bitmap_Left_GlyphSlot
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Bitmap_1Left_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)slot->bitmap_left;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphSlot
 * Method:    FT_Bitmap_Top_GlyphSlot
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_glyph_GlyphSlot_FT_1Bitmap_1Top_1GlyphSlot(JNIEnv *env, jclass clazz, jlong address) {
    FT_GlyphSlot slot = (FT_GlyphSlot)address;
    if (slot == nullptr)
        return -1;
    return (jlong)slot->bitmap_top;
}