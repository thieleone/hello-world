;Kilian Kraatz, Philipp Thiele
GLOBAL main
GLOBAL sort
SECTION .data

arr db 9,8,7,6,5,4,3,2,1,0
;array mit zehn ints, laenge muss manuell in EAX gespeichert werden

SECTION .text

sort:
	MOV EAX,10	;soll nach jedem Durchlauf um eins verringert werden
				;da nach dem ersten Durchlauf das letzte Element, nach dem zweiten
				;die letzten beiden usw. sortiert sind

	MOV EBX,0	;erster Index
	MOV ECX,1	;zweiter Index
	CMP EAX,ECX	;ueberprueft, ob das array vollstaendig durchlaufen wurde
	JE loop2

	CMP [arr+1*EBX],[arr+1*ECX]	;ueberprueft ob getauscht werden muss
	JL loop1	

	xchg [arr+1*EBX],[arr+1*ECX]
	
loop1:	;sorgt dafuer, dass die naechsten beiden werte verglichen werden koennen
	INC EBX
	INC ECX
	JMP sort

loop2:	;sorgt dafuer, dass das array erneut durchlaufen werden kann
		;dazu werden die indizes zurueckgesetzt und die laenge um eins verringejd
		;die laenge wird verringert, da an der stelle mit dem hoechsten index des
		;letzten durchlaufs auf jeden fall der sortierte wert liegt und nicht mehr
		;beruecksichtigt werden muss
	MOV EBX,0
	MOV ECX,1
	DEC EAX
	CMP EAX,0	;sobald der zweite index 0 erreicht, ist das sortieren abgeschlossen
	JG sort