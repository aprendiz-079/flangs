

#include <stdio.h>
#include <stdlib.h>

#define VERIFY_ALLOC_ERR(x) \
if (x == NULL) \
{ puts("Error in allocate memory"); exit(1); }

typedef struct
{
	int age;
	char* name;
	struct Node* next;
} Node;

Node* createNode(void)
{
	Node* newNode = (Node*)malloc(sizeof(Node));
	VERIFY_ALLOC_ERR(newNode)

	newNode->age = 0;
	newNode->name = malloc(sizeof(char));
	newNode->next = NULL;
	return newNode;
}

void insetAtFront(Node** head)
{
	Node* newNode = createNode();
	newNode->next = *head;
	head = newNode;
}

void insertAtEnd(Node** head)
{
	Node* newNode = createNode();
	VERIFY_ALLOC_ERR(newNode)

	Node* last = *head;
	while(last->next != NULL) last = last->next;
	last->next = newNode;
}



/*
//case 01:
createNode(int age, const char name[]){}
char _name[] = "dau"; // array de chars, ex: char _name[4] = {'d', 'a', 'u', '\0'};
createNode(20, _name);

//case 02:
createNode(int age, const char* name){}
char* _name = "opa";//ponteiro que aponta para um char, para o indice 0 de 'opa'
createNode(20, _name);
*/


int main()
{

	return 0;
}
