

#include <jni.h>

#ifndef HAS_MAIN_H
#define HAS_MAIN_H
#ifdef __cplusplus
extern "C" {
#endif

/*
* Class: Main
* Method: method
* Signature: ()V
*/
JNIEXPORT void JNICALL method(JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
