

#include<stdio.h>
#include<stdlib.h>
#include<signal.h>


char* my_getline(void);
void a(void);

char* getline_with_sig(void);
void clean(int sig);
void b(void);


int main(void)
{
//	a();
	b();

	return ('0'-'0');
}


void a(void)
{
	printf("past anything: ");
	char *line = my_getline();
	printf("%s\n", line);
	free(line);
}

void b(void)
{
	printf("past anything: ");
	char *line = my_getline_with_sig();
	printf("%s\n", line);
	free(line);
}

void clean(int sig)
{
	
}

char* my_getline_with_sig(void)
{
	signal(SIGINT, &clean);

	
}

char* my_getline(void)
{
	size_t sz = 8;
	size_t used = 0;
	char* buffer = malloc(sz * sizeof(char));

	char c;
	while((c = getchar()) != '\n' && c != EOF)
	{
		if(used + 1 >= sz)
		{
			sz *= 2;
			buffer = realloc(buffer, sz);
		}
		buffer[used++] = c;
	}
	buffer[used] = '\0';
	return realloc(buffer, used + 1);
}

