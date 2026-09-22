#define X_X 0


#include<stdio.h>
#include<stdlib.h>



void* create_array(int w, size_t sz);
void a(void);

int soma(int nums[], int sz);
void b(void);


int main(void)
{
//	a();
	b();

	return (X_X);
}


void* create_array(int w, size_t sz)
{ return malloc(w*sz); }

void a(void)
{
	int *a = (int*)create_array(8, sizeof(int));

	for(int i=0; i<=9; i++) *(a+i) = i;

	for(int i=0; i<=9; i++) printf("%d ", *(a+i));
	puts("\n");
}

int sum(int nums[], int sz)
{
	int total = 0;
	for(int i=0; i<sz; i++)
	{ total += nums[i]; }
	return total;
}

void b(void)
{
	printf("%d\n", sum((int[]){3, 4, 2, 2}, 4));
}
