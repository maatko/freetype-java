#include "me_mat_freetype_font_Face.h"

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_Face
 * Method:    FT_Done_Face
 * Signature: (J)Z
 */
jboolean JNICALL Java_me_mat_freetype_font_Face_FT_1Done_1Face(JNIEnv *env, jclass clazz, jlong address) {
    return FT_Done_Face((FT_Face)address) ? false : true;
}

/*
 * Class:     me_mat_freetype_font_Face
 * Method:    FT_Num_Faces
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_Face_FT_1Num_1Faces(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->num_faces;
}

/*
 * Class:     me_mat_freetype_font_Face
 * Method:    FT_Flags_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_Face_FT_1Flags_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->face_flags;
}

/*
 * Class:     me_mat_freetype_font_Face
 * Method:    FT_Style_Flags_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_Face_FT_1Style_1Flags_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->style_flags;
}

/*
 * Class:     me_mat_freetype_font_Face
 * Method:    FT_Num_Glyphs_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_Face_FT_1Num_1Glyphs_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->num_glyphs;
}

/*
 * Class:     me_mat_freetype_font_Face
 * Method:    FT_Family_Name_Face
 * Signature: (J)Ljava/lang/String;
 */
jstring JNICALL Java_me_mat_freetype_font_Face_FT_1Family_1Name_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return nullptr;
    return env->NewStringUTF(face->family_name);
}

/*
 * Class:     me_mat_freetype_font_Face
 * Method:    FT_Style_Name_Face
 * Signature: (J)Ljava/lang/String;
 */
jstring JNICALL Java_me_mat_freetype_font_Face_FT_1Style_1Name_1Face(JNIEnv *env, jclass clazz, jlong address){
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return nullptr;
    return env->NewStringUTF(face->style_name);
}