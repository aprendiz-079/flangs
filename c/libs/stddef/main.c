
#define X_X 0


#include<stddef.h>
#include<stdio.h>


void a(void);
void b(void);


int main(void)
{
	a();

	return X_X;
}


void a(void)
{
	typedef struct
	{
		char a;
		int b;
		char c;
	} Person;

	printf("%u\n", offsetof(Person, b));
	printf("%u\n", offsetof(Person, c));
}
