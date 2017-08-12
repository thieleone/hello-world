;Kilian Kraatz, Philipp Thiele
GLOBAL main
GLOBAL fib
SECTION .data
SECTION .text
fib:
;das n wird in RAX uebergeben
        CALL rek

rek:
        CMP RAX, 1;ueberprueft ob n gleich 1 ist
        JE one

        CMP RAX,2;ueberprueft ob n gleich 2 ist
        JE two

        PUSH RAX;n wird fuer die ermittlung von n-2 abgelegt
        DEC RAX;n-1
        CALL rek;bestimmung der fibonaccizahl von n-1
        POP RAX;wird fuer n-2 benoetigt
        PUSH RAX;n wird wieder gesichert
        PUSH RBX;RBX enthaelt die fibonaccizahl von n-1
        DEC RAX;n-1
        DEC RAX;n-2
        CALL rek;bestimmung der fibonaccizahl von n-2
        POP RCX;der wert der fibonaccizahl von n-1 wird vom stack geholt
        POP RAX;n
        ADD RBX,RCX;in RBX wurde die fibonaccizahl von n-2 zurueckgegeben, RCX fibzahl von n-1
        RET;fibzahl von n wird in RBX zurueckgegeben
        
        one:
        MOV RBX,1;RET 1, denn die erste fibonacci zahl ist 1
        RET

        two:
        MOV RBX,1;RET 1, denn die zweite fibonacci zahl ist 1
        RET



30*24=720+230=950+30=980-580=400-120=280
