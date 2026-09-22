


#include "String.h"
#include <stdio.h>


int main(void)
{
	String *s = newstring("opa.");
	
	printf("%s\n", s->buf);
	
	s = append(s, " Bom dia !");

	printf("%s\n", s->buf);
	
	s = delete_range(s, 0, 1);
	
	printf("%s\n", s->buf);

	return 0;
}
