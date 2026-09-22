#define X_X 0


#include <stdio.h>

#define PI 3.14159
#define AREA_CIRCLE(x) (PI*x*x)


static inline double area_circle(double x);


int main()
{
	printf("\
using define: %lf\n\
using inline: %lf\n", AREA_CIRCLE(4), area_circle(4));

	return (X_X);
}


static inline double area_circle(double x)
{ return (PI*x*x); }
