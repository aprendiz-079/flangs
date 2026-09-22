

#include <stdio.h>


struct Data
{
	int x;
};

struct
{
	int x;
} data;


struct Data return_data(void);
data return_data(void);


int main(void)
{
//	struct Data d;
//	d = return_data();

	
	printf("%d\n", data.x);

	return (int)'0' % 48;
}


struct Data return_data(void)
{
	struct Data e;
	e.x = 10;
	return e;
}
