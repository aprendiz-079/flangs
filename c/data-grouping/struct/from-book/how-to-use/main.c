
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void a(void);
void b(void);
void c(void);
void d(void);


int main(void)
{
//	a();
//	b();
//	c();
	d();

	return '0' - '0';
}


void a(void)
{
	struct addr
	{
		char* name;
		char* street;
		char* city;
		char* state;
		unsigned long int zip;
	};

	struct addr addr;

	addr.zip = 123456;


	addr.name = NULL;
	size_t sz = 0;

	puts("Enter a word: ");
	getline(&addr.name, &sz, stdin);

	printf("\nYou enter: %s\n", addr.name);
}

void b(void)
{
	struct
	{
		int a;
		int b;
	} c, d;

	c.a = 10;

	d = c;

	printf("%d\n", d.a);
}

void c(void)
{
	typedef struct
	{
		int x;
		int y;
	} Point;

	Point p[4];

	p[0].x = 10;
	p[0].y = 20;
	//...
}

void d(void)
{
	typedef struct
	{ int x; } P;

	P* p = &(P){ .x = 10 };

	printf("x: %i\n", p->x);
}
