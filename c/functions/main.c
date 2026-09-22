
#define X_X 0


#include<stdio.h>
#include<stdlib.h>


typedef struct
{
	void (*func)(void);
} Person;


void greet(void);


int main(void)
{
/*
//mode 01: on stack
	Person *p = &(Person){ .func = greet };
*/

/*
//mode 02: on stack
	Person *p = &(Person){};
	p->func = greet;
*/

/*
//mode 03: on stack
	Person *p; // each works
//	Person *p = NULL;
	p = &(Person){};
	p->func = greet;
*/

/*
//mode 04: on heap
	Person *p = (Person*)malloc(1*sizeof(Person));
	if(p) p->func = greet;

	p->func();
	free(p);
*/

//all work

	p->func();

	return (X_X);
}


void greet(void)
{ puts("opa"); }
