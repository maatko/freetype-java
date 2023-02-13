# set the minimum cmake version that must be used for this project
cmake_minimum_required(VERSION 3.24)

# set the project name and the language that this project uses
project(freetype-java C CXX)

# set the language version
set(CMAKE_CXX_STANDARD 14)

# set project information
set(PROJECT_NAME freetype-java)
set(PROJECT_VERSION 1.0)

# find the JNI package required for developing java native applications
find_package(JNI REQUIRED)
find_package(Freetype REQUIRED)

# set the link directories
link_directories(
    ${FREETYPE_LIBRARY}
)

# set all the include directories
include_directories(
    ${JNI_INCLUDE_DIRS}
    ${FREETYPE_INCLUDE_DIRS}
    ${CMAKE_HOME_DIRECTORY}/src/generated
)

# collect all the source files into a list
file(GLOB_RECURSE SOURCE_LIST "${CMAKE_HOME_DIRECTORY}/src/main/c++/**.cpp")

# create the shared library
add_library(${PROJECT_NAME} SHARED ${SOURCE_LIST})

# link the freetype library with the project
target_link_libraries(${PROJECT_NAME} freetype)

# change the name of the output library to include the version number
set_target_properties(${PROJECT_NAME} PROPERTIES OUTPUT_NAME ${PROJECT_NAME}-${PROJECT_VERSION})

# copy the library into the build directory
add_custom_command(
    TARGET ${PROJECT_NAME} POST_BUILD COMMAND
    ${CMAKE_COMMAND} -E copy_directory $<TARGET_FILE_DIR:${PROJECT_NAME}>
    ${CMAKE_HOME_DIRECTORY}/target
)