#include <me_mat_freetype_font_FontSizeMetrics.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_X_PPEM_FontSizeMetrics
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1X_1PPEM_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jint)metrics->x_ppem;
}

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_Y_PPEM_FontSizeMetrics
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1Y_1PPEM_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jint)metrics->y_ppem;
}

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_X_Scale_FontSizeMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1X_1Scale_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jlong)metrics->x_scale;
}

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_Y_Scale_FontSizeMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1Y_1Scale_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jlong)metrics->y_scale;
}

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_Ascender_FontSizeMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1Ascender_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jlong)metrics->ascender;
}

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_Descender_FontSizeMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1Descender_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jlong)metrics->descender;
}

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_Height_FontSizeMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1Height_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jlong)metrics->height;
}

/*
 * Class:     me_mat_freetype_font_FontSizeMetrics
 * Method:    FT_Max_Advance_FontSizeMetrics
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontSizeMetrics_FT_1Max_1Advance_1FontSizeMetrics(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size_Metrics* metrics = (FT_Size_Metrics*) address;
    if (metrics == nullptr)
        return -1;
    return (jlong)metrics->max_advance;
}