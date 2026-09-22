

#include "headers/main.h"
#include <stdio.h>

JNIEXPORT void JNICALL method(JNIEnv *env, jobject obj)
{ printf("Metodo nativo chamado !\n"); }
