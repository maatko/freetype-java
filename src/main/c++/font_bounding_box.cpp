#include <me_mat_freetype_font_FontBoundingBox.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_FontBoundingBox
 * Method:    FT_X_MIN_BBox
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontBoundingBox_FT_1X_1MIN_1BBox(JNIEnv *env, jclass clazz, jlong address) {
    FT_BBox* box = (FT_BBox*)address;
    if (box == nullptr)
        return -1;
    return box->xMin;
}

/*
 * Class:     me_mat_freetype_font_FontBoundingBox
 * Method:    FT_Y_MIN_BBox
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontBoundingBox_FT_1Y_1MIN_1BBox(JNIEnv *env, jclass clazz, jlong address) {
    FT_BBox* box = (FT_BBox*)address;
    if (box == nullptr)
        return -1;
    return box->yMin;
}

/*
 * Class:     me_mat_freetype_font_FontBoundingBox
 * Method:    FT_X_MAX_BBox
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontBoundingBox_FT_1X_1MAX_1BBox(JNIEnv *env, jclass clazz, jlong address) {
    FT_BBox* box = (FT_BBox*)address;
    if (box == nullptr)
        return -1;
    return box->xMax;
}

/*
 * Class:     me_mat_freetype_font_FontBoundingBox
 * Method:    FT_Y_MAX_BBox
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontBoundingBox_FT_1Y_1MAX_1BBox(JNIEnv *env, jclass clazz, jlong address) {
    FT_BBox* box = (FT_BBox*)address;
    if (box == nullptr)
        return -1;
    return box->yMax;
}