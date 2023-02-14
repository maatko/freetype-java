#include <me_mat_freetype_glyph_GlyphMetrics.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Width_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Width_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->width;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Height_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Height_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->height;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Hori_BearingX_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Hori_1BearingX_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->horiBearingX;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Hori_BearingY_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Hori_1BearingY_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->horiBearingY;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Hori_Advance_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Hori_1Advance_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->horiAdvance;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Vert_BearingX_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Vert_1BearingX_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->vertBearingX;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Vert_BearingY_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Vert_1BearingY_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->vertBearingY;
}

/*
 * Class:     me_mat_freetype_glyph_GlyphMetrics
 * Method:    FT_Vert_Advance_GlyphMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_glyph_GlyphMetrics_FT_1Vert_1Advance_1GlyphMetrics(JNIEnv * env, jclass clazz, jlong address) {
    FT_Glyph_Metrics* metrics = (FT_Glyph_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return metrics->vertAdvance;
}