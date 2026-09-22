

#include <stdio.h>


enum Color
{
	RED   = 0,
	GREEN = 1,
	BLUE  = 2,
	YELOW = 3
} color, c;

char *colors[] = { "RED", "GREEN", "BLUE", "YELLOW" };


void print_colors(void);


int main(void)
{
	print_colors();
//  printf(colors);

	return 0;
}


void print_colors(void)
{
	for(register int i=0; i<sizeof(colors); i++)
	{
		printf("%i: %s\n", i, *(colors+i));
	}
}
