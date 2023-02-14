#include <me_mat_freetype_font_FontSize.h>

#include <ft2build.h>
#include FT_FREETYPE_H

/*
 * Class:     me_mat_freetype_font_FontSize
 * Method:    FT_Metrics_FontSize
 * Signature: (J)J
 */
jlong JNICALL Java_me_mat_freetype_font_FontSize_FT_1Metrics_1FontSize(JNIEnv *env, jclass clazz, jlong address) {
    FT_Size size = (FT_Size) address;
    if (size == nullptr)
        return -1;
    return (jlong)&size->metrics;
}
