/*ex2.c*/

#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>

#define CAP 10

typedef struct BufferLim
{
	int buf[CAP];
	int fim;
	int ini;
	int n;
	pthread_mutex_t mut;
	pthread_cond_t vazio, cheio;
} BufferLimitado;

void* produtor
