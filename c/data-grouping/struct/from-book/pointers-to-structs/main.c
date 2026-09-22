

#include <stdio.h>


struct bal
{
	double balance;
	char name[80];
};


int main(void)
{
	struct bal *p;

	struct bal person;

	p = &person;

	printf("balance: %f\n", p->balance);

	return '0' % 48;
}
