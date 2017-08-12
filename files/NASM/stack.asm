GLOBAL main
;SECTION .bss
;array_int word 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
;cnt word 0
;zp word 0



GLOBAL sort
SECTION .data

vpt1 db 0;erster Index
vpt2 db 1;zweiter Index
vdc db 10;soll nach jedem Durchlauf um eins verringert werden
;da nach dem ersten Durchlauf das letzte Element, nach dem zweiten
;die letzten beiden usw. sortiert sind
arr db 9,8,7,6,5,4,3,2,1,0


SECTION .text
sort:
	;MOV EAX,[vdc]
	;MOV EBX,[arr+1*vpt2]
	;CMP EAX,EBX
	CMP [vdc],[vpt2]
	JE loop2

	CMP [arr+1*vpt1],[arr+1*vpt2]
	JL loop1	;JG JL funktionieren auch mit negativen Zahlen

	xchg [arr+1*vpt1],[arr+1*vpt2]
	
loop1:
	INC [vpt1]
	INC [vpt2]
	JMP sort

loop2:
	MOV [vpt1],0
	MOV [vpt2],1
	DEC [vdc]
	CMP [vdc],0
	JG sort	


eax ebx ecx edx esi edi ESP EBP





push:
	MOV array_int[0],RDI

pop:
	MOV RAX,array_int[]
	RCX
	RET

top:
	POP RAX
	PUSH RAX
	RET

isEmpty:
	
	RET


SECTION .bss
array_int qword 0, 0, 0, 0, 0, 0, 0, 0, 0, 0


;isEmpty 1, wenn leer
;rueckgabe in rax
;wert wird in rdi uebergeben