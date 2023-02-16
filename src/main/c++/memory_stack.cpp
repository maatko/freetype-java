#include <me_mat_freetype_memory_MemoryStack.h>

#include <cstdlib>

/*
 * Class:     me_mat_freetype_memory_MemoryStack
 * Method:    FT_Allocate_MemoryStack
 * Signature: (J)Ljava/nio/ByteBuffer;
 */
jobject JNICALL Java_me_mat_freetype_memory_MemoryStack_FT_1Allocate_1MemoryStack(JNIEnv *env, jclass clazz, jlong size, jlong capacity) {
    return env->NewDirectByteBuffer(malloc(size), capacity);
}

/*
 * Class:     me_mat_freetype_memory_MemoryStack
 * Method:    FT_Free_MemoryStack
 * Signature: (Ljava/nio/ByteBuffer;)V
 */
void JNICALL Java_me_mat_freetype_memory_MemoryStack_FT_1Free_1MemoryStack(JNIEnv *env, jclass clazz, jobject buffer) {
    void* data = env->GetDirectBufferAddress(buffer);
    if (data == nullptr)
        return;
    free(data);
}