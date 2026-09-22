

#include <stdio.h>


#define L 5
#define C 4


void printa_por_bloco(int *m, int l, int c);

void printa_por_linha(int (*m)[C], int l);

void printa_por_ponteiro_duplo(int **m, int l, int c);

void printa_fofo(int m[L][C]);


int main(void)
{
	// Jeito A: Matriz estatica - bloco continuo
	int matriz_estatica[L][C] = \
	{
	{ 0, 1, 2, 3 },
	{ 4, 5, 6, 7 },
	{ 8, 9, 10, 11 },
	{ 12, 13, 14, 15 },
	{ 16, 17, 18, 19 }
	};

	// Jeito B: 1 mlloc - bloco continuo
	int *matriz_bloco = (int*)matriz_estatica;

	// Jeito C: Array de ponteiros
	int *matriz_ponteiro[L];
	for(register int i=0; i<L; i++)
	{ matriz_ponteiro[i] = matriz_estatica[i]; }


	// Testndo acesso direto
	printf("Acesso direto  [1][2]: %d\n", 
	matriz_estatica[1][2]);


	// Jeito 1
	printa_por_bloco(matriz_bloco, L, C);

	// Jeito 2
 	printa_por_linha(matriz_estatica, L);

	// Jeito 3
	printa_por_ponteiro_duplo(matriz_ponteiro, L, C);

	// Jeito 4: Na linha com aritmetica bruta
	puts("\n\n{");
	for(register int i=0; i<L*C; i++)
	{
		if(i>1 && i % 5 == 0) puts("\n");
		printf("%d ", 
		*( (int*)matriz_estatica + i )    );
	}
	puts("}\n");

	printa_fofo(matriz_estatica);

	return 0;
}


void printa_fofo(int m[L][C])
{
	puts("Printa fofo kk:");

	puts("{");
	for(register int i=0; i<L; i++)
	{
		printf("{ ");
		for(register int j=0; j<C-1; j++)
		{ printf("%d, ", m[i][j]); }
		printf((i!=L-1) ? "%d },\n" : "%d }\n", m[i][C-1]);
	}
	printf("}\n");
}


void printa_por_bloco(int *m, int l, int c)
{
	register int i;
	register int j;


	puts("\nJeito 01: Ponteiro para bloco continuo\n");

	puts("{");
	for(i=0; i<l; i++)
	{
		printf("{ ");
		for(j=0; j<c-1; j++)
		{ printf("%d, ", *(m+i * c+j)); }
		printf((i!=l-1) ? "%d },\n" : "%d }\n", *(m+i * c+c-1));
	}
	puts("}\n");
}

void printa_por_linha(int (*m)[C], int l)
{
	register int i;
	register int j;


	puts("\n\nJeito 02: Ponteiro para linha\n");

	puts("{");
	for(i=0; i<l; i++)
	{
		printf("{ ");
		for(j=0; j<C-1; j++)
		{ printf("%d, ", *(*(m+i)+j)); }
		printf( (i!=l-1) ? "%d },\n" : "%d }\n", *(*(m+i)+C-1) );
	}
	puts("}");
}

void printa_por_ponteiro_duplo(int **m, int l, int c)
{
	register int i;
	register int j;

	// array de ponteiros
	puts("\n\nJeito 03: Ponteiro duplo int**\n");

	puts("{");
	for(i=0; i<l; i++)
	{
		printf("{ ");
		for(j=0; j<c-1; j++)
		{ printf("%d, ", *(*(m+i)+j)); }
		printf("%d ", *(*(m+i)+c-1));

		if(i!=l-1) printf("},\n");
		else printf("}\n");
	}
	puts("}");
}
