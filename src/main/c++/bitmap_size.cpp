#include "me_mat_freetype_bitmap_BitmapSize.h"

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_bitmap_BitmapSize
 * Method:    FT_Height_BitmapSize
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_bitmap_BitmapSize_FT_1Height_1BitmapSize(JNIEnv *env, jclass clazz, jlong address) {
    FT_Bitmap_Size* size = (FT_Bitmap_Size*)address;
    if (size == nullptr)
        return -1;
    return size->height;
}

/*
 * Class:     me_mat_freetype_bitmap_BitmapSize
 * Method:    FT_Width_BitmapSize
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_bitmap_BitmapSize_FT_1Width_1BitmapSize(JNIEnv *env, jclass clazz, jlong address) {
    FT_Bitmap_Size* size = (FT_Bitmap_Size*)address;
    if (size == nullptr)
        return -1;
    return size->width;
}

/*
 * Class:     me_mat_freetype_bitmap_BitmapSize
 * Method:    FT_Size_BitmapSize
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_bitmap_BitmapSize_FT_1Size_1BitmapSize(JNIEnv *env, jclass clazz, jlong address) {
    FT_Bitmap_Size* size = (FT_Bitmap_Size*)address;
    if (size == nullptr)
        return -1;
    return size->size;
}

/*
 * Class:     me_mat_freetype_bitmap_BitmapSize
 * Method:    FT_X_PPEM_BitmapSize
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_bitmap_BitmapSize_FT_1X_1PPEM_1BitmapSize(JNIEnv *env, jclass clazz, jlong address) {
    FT_Bitmap_Size* size = (FT_Bitmap_Size*)address;
    if (size == nullptr)
        return -1;
    return size->x_ppem;
}

/*
 * Class:     me_mat_freetype_bitmap_BitmapSize
 * Method:    FT_Y_PPEM_BitmapSize
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_bitmap_BitmapSize_FT_1Y_1PPEM_1BitmapSize(JNIEnv *env, jclass clazz, jlong address) {
    FT_Bitmap_Size* size = (FT_Bitmap_Size*)address;
    if (size == nullptr)
        return -1;
    return size->y_ppem;
}