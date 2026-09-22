



#include <stdio.h>
#include <stdlib.h>

int main(void)
{

	FILE *f;
	if(!(f = fopen("specifications.code", "r")))
	{
		fprintf(stderr, "The file cannot be open.");
		return 1;
	}

	fseek(f,0,SEEK_END);

	long int f_len = ftell(f);

	char *bytes = malloc(f_len * sizeof(char));

	fread(bytes,f_len,1,f);
	
	for(int i = 0; i < 10; i++)
	{
		printf("%2X\n", *(bytes + i));
	}
	puts("");
	
	free(bytes);

	return 0;
}











