#define X_X


#include <stdio.h>
#include <string.h>


typedef struct
{
	size_t len;
	size_t cap;
	char *buf;
} String;

typedef struct
{
	char *name;
	int age;

	void (*print_name)(String*)
} Class;



int main(void)
{
	Class person;

	return (X_X);
}
