# Matrix operations library made in Java

## Requirements
- [gradle 5.1](https://gradle.org/releases/)
- [oracle/open jdk => v1.8_u191](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
(Works with v1.6 too)

## Instructions
After cloning use these commands to compile and install lib_
- `./gradlew build`
- `./gradlew install` -> install the lib in local maven repository

Make use of the installed library by adding it to your **build.gradle** file:
- `implementation es.ull.hpcg:matrix-lib:<version>` in **dependencies** block
  
and importing it in you java files like:
- `import matrix.lib.*;`


## Current version: 0.5
