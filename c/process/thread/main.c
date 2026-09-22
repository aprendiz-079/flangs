
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>


void imprime(char *arg)
{
	int i;
	for(i=0; i<5; i++) printf(arg);
	exit(0);
}

int main(void)
{
	int pid;
	int estado_filho;

	pid = fork();

	if(pid<0)
	{ perror("Erro de criacao do primeiro filho."); }
	else
	{
		if(pid==0) imprime("-");
	}

	pid = fork();

	if(pid<0)
	{ perror("Erro de criacao do segundo filho filho."); }
	else
	{
		if(pid==0) imprime(".");
	}

	wait(&estado_filho);
	wait(&estado_filho);

	return 0;
}
