#include <me_mat_freetype_font_FontVector.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_FontVector
 * Method:    FT_X_FontVector
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontVector_FT_1X_1FontVector(JNIEnv * env, jclass clazz, jlong address) {
    FT_Vector* vector = (FT_Vector*)address;
    if (vector == nullptr)
        return -1;
    return vector->x;
}

/*
 * Class:     me_mat_freetype_font_FontVector
 * Method:    FT_Y_FontVector
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontVector_FT_1Y_1FontVector(JNIEnv * env, jclass clazz, jlong address) {
    FT_Vector* vector = (FT_Vector*)address;
    if (vector == nullptr)
        return -1;
    return vector->y;
}