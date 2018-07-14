
cmake_minimum_required(VERSION 3.4.1)

file(GLOB framesequence_source src/main/cpp/*.cpp)

file(GLOB giflib_source src/main/cpp/giflib/*.c)

#引入头文件
include_directories(src/main/cpp/giflib)

add_library(
             framesequence
             SHARED
             ${framesequence_source}
             ${giflib_source})

target_link_libraries(
                       framesequence
                       jnigraphics
                       log )