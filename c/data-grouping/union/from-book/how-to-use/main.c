

#include <stdio.h>
#include <stdlib.h>


union pw
{
	int i;
	char ch[2];
};


void putw(union pw word, FILE *fp);


int main(void)
{
	

	return 0;
}


void putw(union pw *word, FILE *fp)
{
	register int i;
	for(i=0; i<sizeof(word->ch); i++)
	{ putc(word->ch[i], fp); }
}
