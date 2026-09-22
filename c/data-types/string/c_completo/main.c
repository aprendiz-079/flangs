

#include <stdio.h>

void desloc(void);
void string_work(void);

int main()
{
//	desloc();
	string_work();
	return 0;
}

void desloc(void)
{
	char x = 'b';
	printf("x value: %c\nacii value: %i\nx new value: %i\n", x, (int)x, (int)x>>3);
}


#include <string.h>
void string_work(void)
{
/*
catalog:
	\n next line
	\t tab
	\0 end of string chars
	\\ print the \ char
	\' print the ' char
	\" print the " char
*/
/*
functions:

from stdio.h:
int printf(const char* __restrict __format, ...);
return the amont chars int the __format

int puts(const char* __s);
return the amount chars in the __s


from string.h:
char* strcat(s1, s2);
*/

	#define _str "abacate" // sz = 8
	char str1[sizeof(_str)] = _str;
	printf("str1 arry size: %i\n", (int)sizeof(str1));
	#undef _str

	#define _str "abobora\0" // sz = 9
	char str2[sizeof(_str)] = _str;
	printf("str2 arry size: %i\n", (int)sizeof(str2));
	#undef _str

	puts("\n");

	int out = printf("str1 value: %s\n", str1);
	printf("out value : %i\n", out);

	out = printf("str2   value: %s\n", str2);
	printf("out value : %i\n", out);

	
}
