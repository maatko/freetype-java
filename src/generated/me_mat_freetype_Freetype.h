/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class me_mat_freetype_Freetype */

#ifndef _Included_me_mat_freetype_Freetype
#define _Included_me_mat_freetype_Freetype
#ifdef __cplusplus
extern "C" {
#endif
#undef me_mat_freetype_Freetype_VERSION
#define me_mat_freetype_Freetype_VERSION 1.0f
/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Init_FreeType
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_me_mat_freetype_Freetype_FT_1Init_1FreeType
  (JNIEnv *, jclass);

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_New_Memory_Face
 * Signature: (JLjava/nio/ByteBuffer;II)J
 */
JNIEXPORT jlong JNICALL Java_me_mat_freetype_Freetype_FT_1New_1Memory_1Face
  (JNIEnv *, jclass, jlong, jobject, jint, jint);

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Done_FreeType
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_me_mat_freetype_Freetype_FT_1Done_1FreeType
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif