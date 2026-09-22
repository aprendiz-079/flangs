

;
; main.asm
;


section .data
	msg db "Result: ", 0   ; 10 = \n, 0 = end of string
	msg_sz equ $ - msg

	new_line db 10
	new_line_sz equ $ - new_line


section .bss
	buffer resb 12


section .text
	extern soma
	global _start


_start:
	push 20      ; 2o arg - empilha ao contrario
	push 10      ; 1o arg
	call soma
	add esp, 8   ; limpa a pilha: 2 * 4 bytes

	; print Result: 
	mov eax, 4   ; syscall write
	mov ebx, 1   ; stdout
	mov ecx, msg ; buffer
	mov edx, msg_sz ; size
	int 0x80

	call print_int

	; sair
	call exit

exit:
	mov eax, 1
	xor ebx, ebx
	int 0x80


; entrada eax
; destroi: eax, ebx, edx, esi
print_int:
	mov esi, buffer + 11 ; aponta pro final do buffer
	mov byte [esi], 0    ; coloca '\0' so por seguranca
	mov ebx, 10          ; divisor

	test eax, eax        ; numero eh 0 ?
	jnz .convert
	dec esi              ; se for 0, so joja '0'
	mov byte [esi], '0'
	jmp .print


.convert:
	xor edx, edx
	div ebx              ; eax = eax/10, edx = resto
	add dl, '0'          ; resto vira char
	dec esi
	mov [esi], dl
	test eax, eax
	jnz .convert


.print:
	; calcula tamanho: final - esi
	mov edx, buffer + 11
	sub edx, esi          ; edx = string size

	; syscall write
	mov eax, 4
	mov ebx, 1
	mov ecx, esi        ; ponteiro pro comeco da string
	int 0x80
	ret
