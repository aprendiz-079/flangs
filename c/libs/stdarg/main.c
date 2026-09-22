

#include<stdio.h>
#include<stdarg.h>


int soma(int qtd, ...);


int main(void)
{
	printf("soma: %d\n", soma(7, 4, 2, 3, 2, 1, 5, 6));
	printf("soma: %d\n", soma(3, 4, 2, 3));

	return 0;
}


int soma(int qtd, ...)
{
	va_list args;
	int total = 0;

	va_start(args, qtd);

	for(int i=0; i<qtd; i++)
	{
		int num = va_arg(args, int);
		total += num;
	}

	va_end(args);
	return total;
}


/*
va_list args:
declara uma "lista" para guardar os args

va_start(args, ultimo_fixo):
inicia a lista. Comeca a ler DEPOIS do ultimo
argumento fixo

va_arg(args, tipo):
pega o proximo argumento e fala qual
o tipo dele

va_end(args):
finaliza. Obrigatorio, limpa a bagunca.
*/
