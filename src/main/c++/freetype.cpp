#include "me_mat_freetype_Freetype.h"

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Init_FreeType
 * Signature: ()J
 */
jlong JNICALL Java_me_mat_freetype_Freetype_FT_1Init_1FreeType(JNIEnv *env, jclass clazz) {
    FT_Library library = NULL;
    return (jlong)(FT_Init_FreeType(&library) ? 0 : library);
}

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_New_Memory_Face
 * Signature: (JLjava/nio/ByteBuffer;II)J
 */
jlong JNICALL Java_me_mat_freetype_Freetype_FT_1New_1Memory_1Face(JNIEnv *env, jclass clazz, jlong address, jobject buffer, jint len, jint face_index) {
    const FT_Byte* data = (const FT_Byte*)(buffer ? env->GetDirectBufferAddress(buffer) : NULL);
    if (data == NULL)
        return -1;
    FT_Face face = NULL;
    if (FT_New_Memory_Face((FT_Library)address, data, (FT_Long)len, (FT_Long)face_index, &face))
	    return -1;
    return (jlong) face;
}

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Done_FreeType
 * Signature: (J)Z
 */
jboolean JNICALL Java_me_mat_freetype_Freetype_FT_1Done_1FreeType(JNIEnv *env, jclass clazz, jlong address) {
    return (jboolean)(FT_Done_FreeType((FT_Library)address) ? false : true);
}