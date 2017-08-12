def Stammfunktion(G):
	F=[]
	i=0
	F+=G[i]
	F+=G[i+1]
	F+=0
	i+=2
	while (i+1)<len(G):
		F+=G[i]
		F+=G[i+1]
		F+=(G[i]*G[i-1]-G[i]*G[i+1])
		i+=2
	F+=G[i]
	return F

def Auswertung(F,x):
	i=0
	while i<len(F):
		if F[i+3]<x:
			return (x*F[i+1]+F[i+2])
		i+=3



"""
Die aus der Vorlesung bekannte Darstellung fuer stueckweise konstante Funktionen folgte dem Schema:
I,W,I,W,I
mit
I = Intervall
W = Wert
Diese Darstellung haben wir an stueckweise lineare Funktionen angepasst.
Sie folgt dem Schema:
I,F,C,I,F,C,I
mit
I = Intervall
F = Faktor (F*x)
C = Konstante
"""