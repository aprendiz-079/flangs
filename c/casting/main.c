

#include<stdio.h>


void a(void);
void b(void);


int main(void)
{
//	a();
	b(); // 17

	return 0;
}


void a(void)
{
	int x = 10;
	void *p = &x;

	printf("x value: %i\n", x);
	printf("p value: %zu\n", *(int*)p); // unsigned size_t
}


int sum(int nums[], int sz)
{
	int total = 0;
	for(int i=0; i<sz; i++) total += *(nums+i);
	return total;
}

void b(void)
{ printf("%d\n", sum((int[]){3, 2, 5, 4, 3}, 5)); }
