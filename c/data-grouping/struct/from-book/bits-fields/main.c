/*
Um campo de bits deve ser declarado como int, unsigned oi signed.
Campos de bits de comprimento 1 devem ser declarados como unsigned, 
porque um unico bit nao pode ter um sinal.

BIT significado quando ligado

0   alteracao na lina clear-to-send

1   alteracao em data-set-ready

2   borda de subida da portadora detectada

3   alteracao na linha de recepcao

4   clear-to-send

5   data-set-ready

6   chamada do telefone

7   sinal recebido


campo de bits sem nome, padding field
: n   pular n bits e joga eles fora
: 0   pula ate o fim do tipo atual. forca alinhamento
*/


#include <stdio.h>


struct status_type
{
	unsigned delta_cts:      1;    //1
	unsigned delta_dsr:      1;    //2
	unsigned tr_edge:        1;    //3
	unsigned delta_rec:      1;    //4
	unsigned cts:            1;    //5
	unsigned dsr:            1;    //6
	unsigned ring:           1;    //7
	unsigned rec_line        1;    //8
} status;


int main(void)
{


	return 0;
}
