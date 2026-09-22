;
; soma.asm
; header

section .text
	global soma


soma:
	; convencao 32bits: argumentos na pilha
	; [ebp + 8] = 1o arg
	; [ebp + 12] = 2o arg

	push ebp
	mov ebp, esp

	mov eax, [ebp + 8]  ; eax = a
	add eax, [ebp + 12] ; eax = a + b

	pop ebp
	ret
