# Philipp Thiele, Julian Holzwarth
from random import randint
def euclid_old(a, b):
	if a == 0:
		return b
	while b != 0:
		if a > b:
			a -= b
		else:
			b -= a
	return a

def sindTeilerfremd(zahlen):
	tempPointer = len(zahlen)
	
	while tempPointer > 1:
		tempPointer2 = len(zahlen) - 1

		while tempPointer2 > 0:

			if euclid_old(zahlen[tempPointer - 1],zahlen[tempPointer2 - 1]) != 1:
				return False
			tempPointer2 -= 1
		tempPointer -= 1
	return True

print("Ist die Liste Teilerfremd?", sindTeilerfremd([14,5,3,7]))


def rechteck():
	a= True
	while a: 
		try:
			a = False
			hoch = int(float(input("Bitte geben sie die Höhe des Rechtecks ein: ")))
			breit = int(float(input("Bitte geben sie die Breite des Rechtecks ein: ")))
			flaeche = hoch*breit
			if hoch < 0 or breit < 0:
				raise ValueError
		except:
			print("Falsche Eingabe! Bitte geben Sie nur Natürliche Zahlen ein.")
			a = True
	print("Der Flächeninhalt des Rechtecks beträgt: "+ str(flaeche))
	
	#Grafik
	if breit != 0 or hoch != 0:
		if breit != 0:
			print("+", end = "")
			for x in range(1,breit):
				print("-", end = "")
			print("+")
			for i in range(1,hoch):
				print("|", end = "")
				for k in range(1,breit):
					print(" ", end = "")
				print("|")
		else:
			print("+")
			for i in range(1,hoch):
				print("|")

		if hoch !=0:
			if breit != 0:
				print("+", end = "")
			for x in range(1,breit):
				print("-", end = "")
			print("+")
	else:
		print("+")

	#Rosen
	rosenInnen = 0
	rosenRand = 0
	rosenEck = 0

	for i in range(0,100):
		tempHoch = randint(0,hoch)
		tempBreit = randint(0, breit)
		if (tempHoch == 0 or tempHoch == hoch) and (tempBreit == 0 or tempBreit == breit):
			#ecke
			rosenEck += 1
		elif tempHoch == 0 or tempHoch == hoch or tempBreit == 0 or tempBreit == breit:
			rosenRand += 1
		else:
			rosenInnen += 1

	print("Es sind ",rosenInnen," Rosen im Inneren gelandet.")
	print("Es sind ",rosenRand," Rosen auf dem Rand gelandet.")
	print("Es sind ",rosenEck," Rosen auf den Eckpunkten gelandet.")
			
rechteck()

	#1a)
	# ValueError: invalid literal for int() with base 10: 'jsafidliu'


# 4

def zufallsliste(x):
	L=[]
	for i in range(x):
		L.append(randint(1,20))
	return L

def selectionsort(A):
	global counter1
	global counter11
	counter1 = 0
	counter11 = 0
	for i in range(0,len(A)-1):
		min = i
		for j in range(i+1,len(A)):
			if A[j] < A[min]:
				min = j
			counter11 += 1
		A[i],A[min]=A[min],A[i]
		counter1 += 1
	return A

print("Selectionsort Liste: ", selectionsort(zufallsliste(20)))

print("swap counter: ",counter1)
print("compare counter: ",counter11)

def bubblesort(A):
	global counter2
	global counter22
	counter2 = 0
	counter22 = 0
	swapped = False
	for i in range(len(A),1,-1):
		for j in range(0,i-1):
			if A[j] > A[j+1]:
				A[j],A[j+1] = A[j+1],A[j]
				counter2 +=1
				swapped = True
			counter22 += 1
		if swapped == False:
			return A
		swapped = False
	return A




print("Bubblesort Liste: ", bubblesort(zufallsliste(20)))
print("swap counter: ", counter2)
print("compare counter: ", counter22)

#4a)
# Selectionsort benötigt deutlich weniger Vertauschungen

# 4b)
# Beide Sortieralgorithmen benötigen gleich viele Vergleiche

# 4c)
# Circa n^2/2

# 4d)
# Bei Listengröße 20 haben wir bei 10 Versuchen im Schnitt 15 Vergleiche eingespart

# 4e)
# Aufsteigend sortierte Liste
# Bei Selectionsort hat sich weder die Anzahl der Vergleiche noch die Anzahl der Vertauschungen geändert
# Bei Bubblesort gibt es keine Vertauschungen mehr und die Vergleiche liegen bei n-1
# Absteigend sortierte Liste
# Bei Selectionsort hat sich weder die Anzahl der Vergleiche noch die Anzahl der Vertauschungen geändert
# Bei Bubblesort wird die maximale Anzahl an Vergleichen durchgeführt. Die bei 4d) eingeführte Flag kann nicht zu einen vorzeitigen Ende führen,
# sie ist in diesem Fall irrelevant.
# Nach jedem Vergleich wird auch vertauscht, wodurch die Anzahl der Vertauschungen ebenfalls maximal ist.

