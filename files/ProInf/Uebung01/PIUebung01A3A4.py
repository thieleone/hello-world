from random import randint

def viersortieren():
	zahlen=[]
	zahlen.append(input("Geben Sie die erste Zahl ein: "))
	zahlen.append(input("Geben Sie die zweite Zahl ein: "))
	zahlen.append(input("Geben Sie die dritte Zahl ein: "))
	zahlen.append(input("Geben Sie die vierte Zahl ein: "))
	print(min(zahlen))
	zahlen.remove(min(zahlen))
	print(min(zahlen))
	zahlen.remove(min(zahlen))
	print(min(zahlen))
	zahlen.remove(min(zahlen))
	print(min(zahlen))
	zahlen.remove(min(zahlen))

def booleschesexamen():
	aussagen=("Giraffen sind blau ","Python ist eine OOP ","C++ ist eine funktionale Programmiersprache ","Julian ist witzig ","Heute ist Montag ")
	aussagenwf=("falsch","wahr","falsch","wahr","falsch")
	ergebnisse=[]

	ran1=randint(0,4)
	aussage1=aussagen[ran1]
	ergebnisse.append(aussagenwf[ran1])
	while True:
		ran1=randint(0,4)
		aussage2=aussagen[ran1]
		if(aussage2 != aussage1):
			ergebnisse.append(aussagenwf[ran1])
			break

	while True:
		antwort1=raw_input("Ist folgende Aussage wahr? : " + aussage1 + ". Antworten sie mit wahr oder falsch. ")
		if antwort1=="wahr" or antwort1=="falsch":
			break

	while True:
		antwort2=(raw_input("Ist folgende Aussage wahr?: " + aussage2 + ". Antworten sie mit wahr oder falsch. "))
		if antwort2=="wahr" or antwort2=="falsch":
			break

	operator=randint(1,4)
	if operator==1:
		ergebnisse.append(ergebnisse[0] and ergebnisse[1])
		while True:
			antwort3=(raw_input("Ist folgende Aussage wahr?: " + aussage1 + " und " + aussage2 + "Antworten sie mit wahr oder falsch. "))
			if antwort3=="wahr" or antwort3=="falsch":
				break



	elif operator==2:
		ergebnisse.append(ergebnisse[0] or ergebnisse[1])
		while True:
			antwort3=(raw_input("Ist folgende Aussage wahr?: " + aussage1 + " oder " + aussage2 + "Antworten sie mit wahr oder falsch. "))
			if antwort3=="wahr" or antwort3=="falsch":
				break


	elif operator==3:
		ergebnisse.append(not ergebnisse[0] or ergebnisse[1])
		while True:
			antwort3=(raw_input("Ist folgende Aussage wahr?: " + aussage1 + ", daraus folgt: " + aussage2 + "Antworten sie mit wahr oder falsch. "))
			if antwort3=="wahr" or antwort3=="falsch":
				break


	else:
		ergebnisse.append(ergebnisse[0] == ergebnisse[1])
		while True:
			antwort3=(raw_input("Ist folgende Aussage wahr?: " + aussage1 + " genau dann, wenn " + aussage2 + "Antworten sie mit wahr oder falsch. "))
			if antwort3=="wahr" or antwort3=="falsch":
				break

	printif(antwort1==ergebnisse[0],"Die erste Antwort war richtig. ", "Die erste Antwort war falsch. ")
	printif(antwort2==ergebnisse[1],"Die zweite Antwort war richtig. ", "Die zweite Antwort war falsch. ")
	printif(antwort3==ergebnisse[2],"Die dritte Antwort war richtig. ", "Die dritte Antwort war falsch. ")


def printif(cond,v1,v2):
	if cond:
		print(v1)
	else:
		print(v2)
	

viersortieren()
booleschesexamen()

