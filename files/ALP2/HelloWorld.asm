message:
		db '\"Hello, World\"',10
msglen: equ $-message
		
		global _start
		section.text

_start:
		mov rax,1
		mov rdi,1
		mov rsi,message
		mov rdx,msglen
		syscall
		mov eax,60
		xor rdi,rdi
		syscall