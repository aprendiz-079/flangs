

#include <stdio.h>
#include <string.h>


int main()
{
	const char* text = "opa";
	int text_sz = strlen(text);

	asm volatile (
	"mov $1, %%rax"
	);

	return 0;
}
