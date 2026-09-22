

#include <stdio.h>


enum coin
{
	penny, nickel, dime=100, quarter, half_dollar, dollar
};


int main(void)
{
	enum coin money;

	money = quarter;
	printf("quarter value: %i\n", money);

	money = dime;
	printf("dime value: %i\n", money);

	money = nickel;
	printf("nickel value: %i\n", money);

	return 0;
}
