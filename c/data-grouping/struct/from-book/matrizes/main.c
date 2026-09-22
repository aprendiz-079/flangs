

#include <stdio.h>


struct x
{
	int a[10][10];
} y;


void print_matriz(struct x *m);


int main(void)
{
	print_matriz(&y);

	return 0;
}


void print_matriz(struct x *m)
{
	register int i;
	register int j;

	for(i=0; i<10; i++)
	{
		printf("{ ");

		for(j=0; j<9; j++)
		{
			printf("%i, ", m->a[i][j]);
		}
		printf("%i }\n", m->a[i][10]);
	}
}
