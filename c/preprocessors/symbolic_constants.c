

#include<stdio.h>


int main(void)
{
	printf(\
"line: %i\nfile: %s\ndate: %s\ntime: %s\nstdc: %i\n", 
__LINE__, __FILE__, __DATE__, __TIME__, __STDC__);

	return 0;
}
