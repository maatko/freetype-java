# freetype-java
Freetype ported to Java

# example

Simple example on how to get started with the library

```java
final File ttf = new File("<font_name>.ttf");
try (final Freetype freetype = new Freetype()) {
    try (FontFace fontFace = freetype.newFontFace(ttf)) {
        // TODO :: ...
    } catch (FreetypeFaceException e) {
        throw new RuntimeException(e);
    }
} catch (Exception e) {
    throw new RuntimeException(e);
}
```

# building
1) ```mvn jni:generate-cmake```
2) ```mvn clean package```