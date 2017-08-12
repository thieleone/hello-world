import sys
import tkinter
import queue

def distanzBerechner(map,startList,finishList):
	warteliste=queue.Queue()
	distanzenBuch = {}
	for element in finishList:
		distanzenBuch[element] = 0
		warteliste.put(element)
	while warteliste.empty() == False:
		(x,y) = warteliste.get()
		for i in range(-1,2):
			for j in range(-1,2):
				if (len(map) > (y+j)) and (y+j >= 0) and (len(map[y]) > (x+i)) and (x+i >= 0):
					if not((map[y+j])[x+i] == "o"):
						if (x+i, y+j) not in distanzenBuch:
							distanzenBuch[(x+i, y+j)] = distanzenBuch[(x, y)] + 1
							warteliste.put((x+i, y+j))
	for element in startList:
		print(distanzenBuch[element])







filename = "map.txt"
mapfile = None
try:
	mapfile = open(filename,"r")
	buf = mapfile.read()
	data = buf.split("\n")
except:
	print("du kannst diese file nicht öffnen")
	sys.exit(0)

#für die Distanzberechnung
startList=[]
finishList=[]

# Male hier die Map
feldlang=20
tk_root = tkinter.Tk()
canvas = tkinter.Canvas(tk_root, width = int(feldlang*len(data[0])), height = int(feldlang*len(data)), bg="blue")


for i in range(len(data)):
	for j in range(len(data[i])):
		if (data[i])[j]=="o":
			color="black"
		elif (data[i])[j]=="s":
			color="green"
			startList.append((j,i))
		elif (data[i])[j]=="f":
			color="red"
			finishList.append((j,i))
		else:
			color="white"
		test = canvas.create_rectangle((j*feldlang),(i*feldlang),(j*feldlang+feldlang,(i*feldlang+feldlang)),fill=color)
		
distanzBerechner(data,startList,finishList)

canvas.pack()
tk_root.mainloop()

#1b) Ergänzung Liste aller Palindromzahlen
# [n for n in range(999) if (n//100>0 and n//100==n % 10) or (n//100==0 and (n//10==n%10 or n//10==0))]

#4b)
#Vorteil: Es ist einfacher zu testen ob ein Objekt bereits im dictionary ist
#Nachteil: Längere Laufzeit, da der Hashwert durch die Hashfunktion bei jedem Aufruf berechnet werden muss

