#include <me_mat_freetype_Freetype.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Init_FreeType
 * Signature: ()J
 */
jlong JNICALL Java_me_mat_freetype_Freetype_FT_1Init_1FreeType(JNIEnv *env, jclass clazz) {
    FT_Library library = NULL;
    FT_Error error_code = FT_Init_FreeType(&library);
    return (jlong)(error_code == 0 ? (jlong)library : error_code * -1);
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
    FT_Error error_code = FT_New_Memory_Face((FT_Library)address, data, (FT_Long)len, (FT_Long)face_index, &face);
    return (jlong) (error_code == 0 ? (jlong)face : error_code * -1);
}

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Done_FreeType
 * Signature: (J)Z
 */
jlong JNICALL Java_me_mat_freetype_Freetype_FT_1Done_1FreeType(JNIEnv *env, jclass clazz, jlong address) {
    FT_Error error_code = FT_Done_FreeType((FT_Library)address);
    return error_code == 0 ? error_code : error_code * -1;
}

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Library_Version
 * Signature: (JLme/mat/freetype/FreetypeVersion;)V
 */
void JNICALL Java_me_mat_freetype_Freetype_FT_1Library_1Version(JNIEnv *env, jclass clazz, jlong address, jobject version_obj) {
    int minor, major, patch;
    FT_Library_Version((FT_Library)address, &major, &minor, &patch);
    jclass version_clazz = env->GetObjectClass(version_obj);

    jfieldID id = env->GetFieldID(version_clazz, "minor", "I");
    env->SetIntField(version_obj, id, minor);

    id = env->GetFieldID(version_clazz, "major", "I");
    env->SetIntField(version_obj, id, major);

    id = env->GetFieldID(version_clazz, "patch", "I");
    env->SetIntField(version_obj, id, patch);
}

/*
 * Class:     me_mat_freetype_Freetype
 * Method:    FT_Error_String
 * Signature: (I)Ljava/lang/String;
 */
jstring JNICALL Java_me_mat_freetype_Freetype_FT_1Error_1String(JNIEnv *env, jclass clazz, jint error_code) {
    return env->NewStringUTF(FT_Error_String(error_code));
}