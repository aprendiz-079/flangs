
#define X_X 0


#include<stdio.h>


void print_array_string(char **as, int l);
/*
pq nao pode ser const char **as ?


const char *s[] = { "opa", "bom", "dia" };

s[0] = "thau"; // PODE. pq s
*/


int main(void)
{
	//             3       5       3         8    =  19
	//            111    11111    111    11111111
	char *s[] = { "opa", ". bom", " dia", " ksksksk" }; // notacao correta
	int sz = sizeof(s)/sizeof(s[0]);
/*
[ 'o', 'p', 'a']
[  '.' ,' ', 'b', 'o', 'm' ]
[ 'd', 'i', 'a' ]
[ ' ', 'k', 's', 'k', 's', 'k', 's', 'k' ]
*(*(s+0)+0) = 'o'
*(*(s+0)+1) = '.'
*(*(s+0)+2) = ' '
...


*(*(s+0)+0) = 'o'
*(*(s+0)+1) = 'p'
*(*(s+0)+2) = 'a'
...

*/

	print_array_string(s, sz);
	puts("");

	return (X_X);
}


void print_array_string(char **as, int l)
{
	for(register int i=0; i<l; i++)
	{
//		printf("%i: ", i);
		for(register int j=0; *(*(as+i)+j)!='\0'; j++)
		{ printf("%c", *(*(as+i)+j)); }
//		puts("");
	}
}

