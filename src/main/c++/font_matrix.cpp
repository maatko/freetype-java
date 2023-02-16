#include <me_mat_freetype_font_FontMatrix.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_FontMatrix
 * Method:    FT_XX_FontMatrix
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontMatrix_FT_1XX_1FontMatrix(JNIEnv *env, jclass clazz, jlong address) {
    FT_Matrix* matrix = (FT_Matrix*)address;
    if (matrix == nullptr)
        return -1;
    return matrix->xx;
}

/*
 * Class:     me_mat_freetype_font_FontMatrix
 * Method:    FT_XY_FontMatrix
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontMatrix_FT_1XY_1FontMatrix(JNIEnv *env, jclass clazz, jlong address) {
    FT_Matrix* matrix = (FT_Matrix*)address;
    if (matrix == nullptr)
        return -1;
    return matrix->xy;
}

/*
 * Class:     me_mat_freetype_font_FontMatrix
 * Method:    FT_YX_FontMatrix
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontMatrix_FT_1YX_1FontMatrix(JNIEnv *env, jclass clazz, jlong address) {
    FT_Matrix* matrix = (FT_Matrix*)address;
    if (matrix == nullptr)
        return -1;
    return matrix->yx;
}

/*
 * Class:     me_mat_freetype_font_FontMatrix
 * Method:    FT_YY_FontMatrix
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontMatrix_FT_1YY_1FontMatrix(JNIEnv *env, jclass clazz, jlong address) {
    FT_Matrix* matrix = (FT_Matrix*)address;
    if (matrix == nullptr)
        return -1;
    return matrix->yy;
}