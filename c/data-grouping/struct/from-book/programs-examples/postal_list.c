

#include <stdio.h>
#include <stdlib.h>

#define MAX 100


/*
struct addr
	{
	char *name;
	char *street;
	char *city;
	char *state;
	unsigned long int zip;
} addr_info[MAX];
*/
struct addr
{
	char name[30];
	char street[40];
	char city[20];
	char state[3];
	unsigned long int zip;
} addr_info[MAX];


void init_list(void), enter(void);
void delete(void), list(void);
int menu_select(void), find_free(void);


int main(void)
{
	char choice;

	init_list();

	choice = menu_select();
	switch (choice)
	{
		case 1: enter(); break;
		case 2: delete(); break;
		case 3: list(); break;
		case 4: exit(0);
	}

	return 0;
}


void init_list(void)
{
	register int t;

	for(t=0; t<MAX; ++t) addr_info[t].name[0] = '\0';
}

int menu_select(void)
{
	char s[80];
	int c;

	printf("1. Insert a name;\n");
	printf("2. Exclude a name;\n");
	printf("3. List a file;\n");
	printf("4. Exit;\n");

	do
	{
		printf("Enter ur choice: ");
		fgets(s, 1, stdin);
		c = atoi(s);
	}while(c<0 || c>4);

	return c;
}

void enter(void)
{
	int slot;
	char s[80];

	slot = find_free();
	if(slot==-1)
	{
		puts("List is full");
		return;
	}

	printf("Paste the name: ");
	fgets(addr_info[slot].name, 30, stdin);

	printf("Paste the street: ");
	fgets(addr_info[slot].street, 40, stdin);

	printf("Paste the city: ");
	fgets(addr_info[slot].city, 20, stdin);

	printf("Paste the state: ");
	fgets(addr_info[slot].state, 3, stdin);

	printf("Paste the zip: ");
	fgets(s, 20, stdin);

	addr_info[slot].zip = strtoul(s, '\0', 10);
}

int find_free(void)
{
	register int t;
	for(t=0; addr_info[t].name[0] && t<MAX; t++);

	if(t==MAX) return -1;

	return t;
}

void delete(void)
{
	register int slot;
	char s[80];

	printf("Enter the registre #: ");
	fgets(s, MAX, stdin);
	slot = atoi(s);
	if(slot>=0 && slot<MAX)
	{ addr_info[slot].name[0] = '\0'; }
}

void list(void)
{
	register int t;

	for(t=0; t<MAX; t++)
	{
		if(addr_info[t].name[0])
		{
			printf("%s\n%s\n%s\n%s\n%lu\n", 
			addr_info[t].name, 
			addr_info[t].street, 
			addr_info[t].city, 
			addr_info[t].state, 
			addr_info[t].zip);
		}
	}
	puts("\n");
}
