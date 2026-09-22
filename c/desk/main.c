

#include<stdio.h>
#include<stdlib.h>


int main(void)
{
	char *name = "opa";

	printf("%s\n", name);

	name = NULL;
	name = ".pa";
	int x  = '\0';

	printf("%s\n", name);

	printf("x: %i\n", x);

	return 0;
}
