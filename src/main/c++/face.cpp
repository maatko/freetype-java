#include "me_mat_freetype_font_FontFace.h"

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Done_Face
 * Signature: (J)Z
 */
jboolean JNICALL Java_me_mat_freetype_font_FontFace_FT_1Done_1Face(JNIEnv *env, jclass clazz, jlong address) {
    return FT_Done_Face((FT_Face)address) ? false : true;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Num_Faces
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1Num_1Faces(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->num_faces;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Flags_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1Flags_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->face_flags;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Style_Flags_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1Style_1Flags_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->style_flags;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Num_Glyphs_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1Num_1Glyphs_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->num_glyphs;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Family_Name_Face
 * Signature: (J)Ljava/lang/String;
 */
jstring JNICALL Java_me_mat_freetype_font_FontFace_FT_1Family_1Name_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return nullptr;
    return env->NewStringUTF(face->family_name);
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Style_Name_Face
 * Signature: (J)Ljava/lang/String;
 */
jstring JNICALL Java_me_mat_freetype_font_FontFace_FT_1Style_1Name_1Face(JNIEnv *env, jclass clazz, jlong address){
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return nullptr;
    return env->NewStringUTF(face->style_name);
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Num_Fixed_Sizes_Face
 * Signature: (J)I
 */
jint JNICALL Java_me_mat_freetype_font_FontFace_FT_1Num_1Fixed_1Sizes_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return face->num_fixed_sizes;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Available_Sizes_Face
 * Signature: (J)[J
 */
jlongArray JNICALL Java_me_mat_freetype_font_FontFace_FT_1Available_1Sizes_1Face(JNIEnv * env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return nullptr;
    int len = face->num_fixed_sizes;
    jlong* data = (jlong*) calloc(len, sizeof(jlong));
    for(int i = 0; i < len; i++) {
        data[i] = (jlong) &face->available_sizes[i];
    }
    jlongArray array = env->NewLongArray(len);
    env->SetLongArrayRegion(array, 0, len, (const jlong *)data);
    free(data);
    return array;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Num_CharMaps_Face
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_me_mat_freetype_font_FontFace_FT_1Num_1CharMaps_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1; 
    return face->num_charmaps;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_CharMaps_Face
 * Signature: (J)[J
 */
jlongArray JNICALL Java_me_mat_freetype_font_FontFace_FT_1CharMaps_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return nullptr;
    int len = face->num_charmaps;
    jlong* data = (jlong*) calloc(len, sizeof(jlong));
    for(int i = 0; i < len; i++) {
        data[i] = (jlong) &face->charmaps[i];
    }
    jlongArray array = env->NewLongArray(len);
    env->SetLongArrayRegion(array, 0, len, (const jlong *)data);
    free(data);
    return array;   
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_BBox_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1BBox_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1; 
    return (jlong)&face->bbox;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Units_Per_EM_Face
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Units_1Per_1EM_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1; 
    return face->units_per_EM;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Ascender_Face
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Ascender_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1; 
    return face->ascender;    
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Descender_Face
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Descender_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1; 
    return face->descender;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Height_Face
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Height_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1; 
    return face->height;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Max_Advance_Width
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Max_1Advance_1Width_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return face->max_advance_width;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Max_Advance_Height
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Max_1Advance_1Height_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return face->max_advance_height;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Underline_Position_Face
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Underline_1Position_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return face->underline_position;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Underline_Thickness_Face
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontFace_FT_1Underline_1Thickness_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return face->underline_thickness;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Glyph_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1Glyph_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->glyph;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_Size_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1Size_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->size;
}

/*
 * Class:     me_mat_freetype_font_FontFace
 * Method:    FT_CharMap_Face
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontFace_FT_1CharMap_1Face(JNIEnv *env, jclass clazz, jlong address) {
    FT_Face face = (FT_Face)address;
    if (face == nullptr)
        return -1;
    return (jlong)face->charmap;
}