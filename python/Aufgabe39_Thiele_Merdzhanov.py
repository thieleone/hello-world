# Philipp Thiele, Yavor Merdzhanov
# Tutor: Alexander Zachrau
# Tutorium: Dienstag, 12-14 Uhr

def umtab(wae,kurs):
	a=(1,2,5,10,20,50,100)


	stellen=0
	i=0
	if kurs<1:
		while stellen==0:
			if (kurs//(10**i)>=1):
				stellen=10**i
			i=i-1

	else:
		while stellen==0:
			if (kurs//(10**i)<10):
				stellen=10**i
			i=i+1

	if (kurs/stellen)<=2:
		b=(2,5,10,20,50,100,200)

	elif (kurs/stellen)<=5:
		b=(5,10,20,50,100,200,500)

	elif (kurs/stellen)<=10:
		b=(10,20,50,100,200,500,1000)

	for x in range(len(a)):
		print(str(round(a[x]*kurs,2))+' '+wae+' = '+str(a[x])+' EUR')
		for y in range(len(b)-1):
			if (b[y]/kurs*stellen)>a[x] and (b[y]/kurs*stellen)<a[x+1]:
				print(str(b[y]*stellen)+' '+wae+' = '+str(round(b[y]/kurs*stellen,2))+' EUR')

umtab('HUF',313.812)
umtab('Test',2.1)

# Die Tabelle enthaelt mindestens 7 Werte.
# Es sind die 8 vorgegebenen Werte in EUR.
# Das tritt ein, wenn der Kurs ein Vielfaches von 10 oder 0.1 ist.
# 
# Da 1 und 100 EUR die untereund obere Grenze bilden
# koennen maximal 6 Werte der anderen Waehrung dazwischen liegen
# somit ergibt sich, dass die Tabelle maximal 13 Werte enthalten kann




# ueberpruefen ob kurs >=1 oder <1
# Anzahl der Stellen herausfinden
# dann div bzw mult fuer die form a,bcdefg...
# ueberpruefen ob zwischen 1,2 oder 2,5 oder 5,10
# dann kann abhaengig von diesem Wert eine Liste erstellt werden
# mit Puffer, sodass in jedem Fall ein Wert groesser 100 euro enthalten ist
# dann werden die Werte aus beiden Listen verglichen und bis zu 100 euro ausgegeben
