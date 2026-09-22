

#include<stdio.h>


int main(void)
{
	printf("%s:%i\n", __FILE__, __LINE__);

	#line 100 "fake.c"
	printf("%s:%i\n", __FILE__, __LINE__);

	return 0;
}
