

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>


int len(const char* txt)
{
	int sz = 0;
	for (register int i = 0; txt[i] != '\0'; i++) ++sz;
	return sz;
}

char* string_copy(char* dest, const char* txt)
{
	char* original = dest;
	while((*dest++ = *txt++) != '\0');
	return original;
}

int string_new_value(char* str, const char* txt)
{
	int sz = len(txt);
	printf("sizeof(%s): %d\n", txt, sz);
	str = realloc(str, (sz + 1) * sizeof(char));
	if (str == NULL)
	{
		fprintf(stderr, "Erro (%d): %s\n", errno, strerror(errno));
		return -1;
	}
	str = string_copy(str, txt);
	return 0;
}

int main()
{
	char* name = malloc(sizeof(char));
	int out = string_new_value(name, "opa");
	if (out != 0)
	{
		fprintf(stderr, "Erro (%d): %s\n", errno, strerror(errno));
		return 1;
	}

	printf("name value: %s\n", name);

	out = string_new_value(name, "bom dia");
	if (out != 0)
	{
		fprintf(stderr, "Erro (%d): %s\n", errno, strerror(errno));
		return 1;
	}
	printf("name value: %s\n", name);


	return 0;
}
