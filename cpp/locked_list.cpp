

#include <iostrem>

typedef struct
{
	int age;
	char* name;
	struct Node* next;
} Node;

Node* createNode(void)
{
	Node* newNode = (Node*)malloc(sizeof(Node));
	if (newNode == NULL)
	{ std::cout << "Error in allocate node" << std::endl; exit(1); }

	newNode->age = 0;
	newNode->name = malloc(sizeof(char));
	return newNode;
}


int main()
{


	return 0;
}
