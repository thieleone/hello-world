####################################
# Author: Thiele, Philipp
# Abgabe: 29.04.2016
# Tutor: Zachrau, Alexander
# Tutorium: Dienstag, 12-14 Uhr
####################################
def Hanoi(n, Start, Hilfsstift, Ziel):
	# n und die in init_Hanoi erzeugten Listen werden uebergeben
    if n==0: return
    # Anker
    Hanoi(n-1, Start, Ziel, Hilfsstift)
    setze_um(n, Start, Ziel)
    Hanoi(n-1, Hilfsstift, Start, Ziel)
       
def setze_um(n, x, y):
    print("Setze Scheibe",n,"von Stift",x,"auf Stift",y)
    # Es werden nicht nur die Namen der Stifte ausgegeben,
    # sondern auch die aktuelle Belegung mit Scheiben
    # ohne Belegung: x[0] statt x und y[0] statt y
    if x.pop()==n and ((len(y)>1 and y[-1]>n) or len(y)==1):
    	# ueberprueft, ob die zu entfernende Scheibe ueberhaupt
    	# an oberster Stelle auf Stift x liegt
    	# sollte der (Ziel-)Stift mindestens eine Scheibe aufweisen,
    	# muss ihr Wert mit n verglichen werden,
    	# da in keinem Fall eine Scheibe auf eine kleinere gelegt werden darf
    	y.append(n)
    else:
    	raise RuntimeError

def init_Hanoi(n, x, y, z):
	global m
	m=n
	global stifte
	# Die globale Variable stifte ist eine Liste von Listen. Jede der enthaltenen Listen
	# hat bei Index 0 den Namen des dazugehoerigen Stifts gespeichert.
	# Ab Index 1 werden die Scheiben auf den entsprechenden Stiften gespeichert.
	stifte=[]
	sta=[]
	hil=[]
	zie=[]

	stifte.append(sta)
	stifte.append(hil)
	stifte.append(zie)
	# Die drei Stifte werden in die globale Liste eingefuegt
	sta.append(x)
	hil.append(y)
	zie.append(z)
	# Die Namen der Scheiben werden bei Index 0 gespeichert.

	i=n
	while i>0:
		sta.append(i)
		i=i-1
	# Scheiben von n bis 1 werden auf dem Stift Start abgelegt.
	Hanoi(n,sta,hil,zie)
	# Aufruf des Algorithmus zum Loesen der Aufgabe


def anzeigen():
	print(stifte)


def fertig():
	if len(stifte[0])==1 and len(stifte[1])==1:
		# Die ersten beiden Stifte duerfen keine Scheiben enthalten.
		j=m
		k=1
		# k ist der Index, j der korrekte Wert zum Index
		while j>0:
			if stifte[2][k] != j:
				print('Nicht fertig!')
				return False
			j-=1
			k+=1
		print('Fertig!')
		return True
		# Sollte die Schleife komplett durchlaufen werden,
		# wurde die Aufgabe erfolgreich geloest
	print('Nicht fertig!')
	return False


init_Hanoi(5, 'A', 'B', 'C')
anzeigen()
fertig()

