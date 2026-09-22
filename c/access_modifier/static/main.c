



#include <stdio.h>
#include "pass_manager.h"

extern int pass;
extern int get_secure_pass(void);

int main()
{
	printf("pass: %i\n\n", pass);

	printf("secure pass: %i", get_secure_pass());

	puts("");
	return 0;
}
