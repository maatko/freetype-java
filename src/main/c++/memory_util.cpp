#include "me_mat_freetype_util_MemoryUtil.h"

#include <cstdlib>
#include <string.h>

/*
 * Class:     me_mat_freetype_util_MemoryUtil
 * Method:    createBuffer
 * Signature: (I)Ljava/nio/ByteBuffer;
 */
jobject JNICALL Java_me_mat_freetype_util_MemoryUtil_createBuffer(JNIEnv *env, jclass clazz, jint size) {
    return env->NewDirectByteBuffer((char*)malloc(size), size);
}

/*
 * Class:     me_mat_freetype_util_MemoryUtil
 * Method:    fillBuffer
 * Signature: ([BLjava/nio/ByteBuffer;I)V
 */
void JNICALL Java_me_mat_freetype_util_MemoryUtil_fillBuffer(JNIEnv *env, jclass clazz, jbyteArray bytes, jobject buffer, jint length) {
    unsigned char* dst = (unsigned char*)(buffer ? env->GetDirectBufferAddress(buffer) : 0);
    unsigned char* src = (unsigned char*)env->GetPrimitiveArrayCritical(bytes, 0);
    memcpy(dst, src, length);
    env->ReleasePrimitiveArrayCritical(bytes, src, 0);
}

/*
 * Class:     me_mat_freetype_util_MemoryUtil
 * Method:    deleteBuffer
 * Signature: (Ljava/nio/ByteBuffer;)V
 */
void JNICALL Java_me_mat_freetype_util_MemoryUtil_deleteBuffer(JNIEnv *env, jclass clazz, jobject buffer) {
    char* buff = (char*)(buffer ? env->GetDirectBufferAddress(buffer) : NULL);
    if (buff == NULL)
        return;
    free(buff);
}