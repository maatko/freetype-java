#include <me_mat_freetype_bitmap_Bitmap.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_bitmap_Bitmap
 * Method:    FT_Rows_Bitmap
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_bitmap_Bitmap_FT_1Rows_1Bitmap(JNIEnv * env, jclass clazz, jlong address) {
    FT_Bitmap* bitmap = (FT_Bitmap*) address;
    if (bitmap == nullptr)
        return -1;
    return (jlong)bitmap->rows;
}

/*
 * Class:     me_mat_freetype_bitmap_Bitmap
 * Method:    FT_Width_Bitmap
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_bitmap_Bitmap_FT_1Width_1Bitmap(JNIEnv * env, jclass clazz, jlong address) {
    FT_Bitmap* bitmap = (FT_Bitmap*) address;
    if (bitmap == nullptr)
        return -1;
    return (jlong)bitmap->width;
}

/*
 * Class:     me_mat_freetype_bitmap_Bitmap
 * Method:    FT_Pitch_Bitmap
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_bitmap_Bitmap_FT_1Pitch_1Bitmap(JNIEnv * env, jclass clazz, jlong address) {
    FT_Bitmap* bitmap = (FT_Bitmap*) address;
    if (bitmap == nullptr)
        return -1;
    return (jint)bitmap->pitch;
}

/*
 * Class:     me_mat_freetype_bitmap_Bitmap
 * Method:    FT_Buffer_Bitmap
 * Signature: (J)Ljava/nio/ByteBuffer;
 */
jobject JNICALL Java_me_mat_freetype_bitmap_Bitmap_FT_1Buffer_1Bitmap(JNIEnv * env, jclass clazz, jlong address) {
    FT_Bitmap* bitmap = (FT_Bitmap*) address;
    if (bitmap == nullptr)
        return nullptr;
    return env->NewDirectByteBuffer((void*)bitmap->buffer, bitmap->rows * bitmap->width * abs(bitmap->pitch));
}

/*
 * Class:     me_mat_freetype_bitmap_Bitmap
 * Method:    FT_Num_Grays_Bitmap
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_bitmap_Bitmap_FT_1Num_1Grays_1Bitmap(JNIEnv * env, jclass clazz, jlong address) {
    FT_Bitmap* bitmap = (FT_Bitmap*) address;
    if (bitmap == nullptr)
        return -1;
    return (jint)bitmap->num_grays;
}

/*
 * Class:     me_mat_freetype_bitmap_Bitmap
 * Method:    FT_Pixel_Mode_Bitmap
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_bitmap_Bitmap_FT_1Pixel_1Mode_1Bitmap(JNIEnv * env, jclass clazz, jlong address) {
    FT_Bitmap* bitmap = (FT_Bitmap*) address;
    if (bitmap == nullptr)
        return -1;
    return (jint)bitmap->pixel_mode;
}