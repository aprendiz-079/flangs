

#include<stdio.h>

#define PI 3.141592
#define TOSTR(x) #x

//#define CONCAT(x, y) #x#y
#define CONCAT(x,y) x##y


int main(void)
{
	printf("\
PI: %lf\n\
s: %s\n\
s1: %s\n", PI, TOSTR(opaksks), CONCAT(opa, sksksk));

	return 0;
}
