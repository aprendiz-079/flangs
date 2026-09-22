

#include<stdio.h>
#include<string.h>
#include<pthread.h>

void* imprime(void *arg);

int main(void)
{
	pthread_t tid1, tid2;

	pthread_attr_t attr;

	char msg1[30];

	char msg2[30];

	strcpy(msg1, ".");

	strcpy(msg2, "-");

	pthread_attr_init(&attr);

	pthread_create(&tid1, &attr, &imprime, msg1);

	pthread_create(&tid2, &attr, &imprime, msg2);

	pthread_join(tid1, NULL);

	pthread_join(tid2, NULL);

	return 0;
}

void* imprime(void *arg)
{
	int i;
	for(i=0; i<5; i++) printf((char*)arg);
	pthread_exit(0);
}
