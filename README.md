# Reproduction step:
## Build sentencepiece jar:
- Clone: https://github.com/levyfan/sentencepiece-jni
- maven clean build
- Use sentencepiece-0.0.1-SNAPSHOT.jar
(MacOS)

## Build app
- Add the jar to app/libs
- Add `implementation files('libs/sentencepiece-0.0.1-SNAPSHOT.jar')` to build.gradle
- Can import, crash on run.