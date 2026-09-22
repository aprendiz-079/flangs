
/*

*/

#define X_X 0

// used for everyone
#include<stdio.h>
#include<signal.h>

// used for ia_example
#include<unistd.h>

// used for book_example
#include<stdlib.h>
#include<time.h>

void signalHandler(int signalValue);
void book_example(void);


void ignore_interrupt(int sig);
void ia_example(void);

int main(void)
{
//	book_exmaple();
	ia_example();

	return (X_X);
}

void ignore_interrupt(int sig)
{/*empty*/}

void ia_example(void)
{
//	signal(SIGINT, &ignore_interrupt);
// or
	signal(SIGINT, SIG_IGN);

	puts("Program runing...");
	puts("Tap Ctrl+c to test.");

	for(int i=1; i<=5; i++)
	{ puts("Im alive"); sleep(3); }
}


void signalHandler(int signalValue)
{
	int response;

	printf("%s%d%s\n%s", "\nSinal de interrupcao (", 
	signalValue, 
	") recebido.", "Deseja continuar ( 1 = sim ou 2 = nao )? ");
	scanf("%d", &response);

	while(response!=1 && response!=2)
	{
		printf("( 1 = yes or 2 = no )? ");
		scanf("%d", &response);
	}

	if(response==1) signal(SIGINT, signalHandler);
	else exit(EXIT_SUCCESS);
}

void book_example(void)
{
	signal(SIGINT, signalHandler);

	srand(time(NULL));

	int x;
	for(int i=0; i<=100; i++)
	{

		x = 1+rand()%50;

		if(x==25) raise(SIGINT);

		printf("%4d", i);

		if(i%10==0) puts("");
	}
}
