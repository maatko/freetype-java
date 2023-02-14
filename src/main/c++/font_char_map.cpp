#include <me_mat_freetype_font_FontCharMap.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_FontCharMap
 * Method:    FT_Platform_ID_CharMap
 * Signature: (J)S
 */
 jshort JNICALL Java_me_mat_freetype_font_FontCharMap_FT_1Platform_1ID_1CharMap(JNIEnv * env, jclass clazz, jlong address) {
    FT_CharMap map = (FT_CharMap)address;
    if (map == nullptr)
        return -1;
    return map->platform_id;
 }

/*
 * Class:     me_mat_freetype_font_FontCharMap
 * Method:    FT_Encoding_ID_CharMap
 * Signature: (J)S
 */
jshort JNICALL Java_me_mat_freetype_font_FontCharMap_FT_1Encoding_1ID_1CharMap(JNIEnv * env, jclass clazz, jlong address) {
    FT_CharMap map = (FT_CharMap)address;
    if (map == nullptr)
        return -1;
    return map->encoding_id;
}