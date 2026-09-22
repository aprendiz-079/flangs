



#include <stdio.h>
#include <stdlib.h>

#define INITIAL_SIZE 10

int i;
int len(char* s);
void string_copy(char* s, char* d);


int main()
{
	char* name = malloc(INITIAL_SIZE * sizeof(char));
	char* last_name = malloc(INITIAL_SIZE * sizeof(char));

	name = "jorge";
	last_name = "matheus";

	char* complete_name = string_copy(name, last_name);
	return 0;
}


int len(char* s)
{
	int sz = 0;
	for (i = 0; *(s+i) != '\0'; i++) sz++;
	return sz;
}

char* string_copy(char* s, char* d)
{
	int s_sz = len(s);
	int d_sz = len(d);

	int str_sz = s_sz + d_sz;
	char* str = malloc(str_sz * sizeof(char));

	for (i = 0; i < s_sz; i++)
		printf("%s\n len: %i\n;", s, i);

	clear();
	return null.
}
