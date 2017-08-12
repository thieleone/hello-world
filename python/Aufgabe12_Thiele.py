####################################
# Author: Thiele, Philipp
# Abgabe: 29.04.2016
# Tutor: Zachrau, Alexander
# Tutorium: Dienstag, 12-14 Uhr
####################################
def testGGT(a,b,t,r,s):

	ggt=t
	# ggt ist der zu ueberpruefende ggT, t der potentiell korrekte

	if a%t==0 and b%t==0:

		if b>a:
			for i in range(t,b//2):
				# der ggt kann nicht groesser sein, als die
				# Haelfte der groesseren Zahl
				if a%i==0 and b&i==0:
					# sollten beide Zahlen ohne Rest geteilt werden
					# ist t Teiler, potentiell ggT
					ggt=i

		elif a>b:
			for i in range(t,a//2):
				# der ggt kann nicht groesser sein, als die
				# Haelfte der groesseren Zahl
				if a%i==0 and b&i==0:
					# sollten beide Zahlen ohne Rest geteilt werden
					# ist t Teiler, potentiell ggT
					ggt=i

		else:
			# beide Zahlen sind identisch
			ggt=a

		if ggt==t:
			print("t ist ggT!")

		else:
			print("t ist nicht ggT! ",t," ist ggT!")

	else:
		print("t ist nicht ggT!")

	if a*r+b*s==ggt:
		print("r und s sind korrekt!")

	else:
		print("r und s sind nicht korrekt!")


def ggt(a,b):
	# rekursiver euklidischer Algorithmus
	if b==0:
		return (a)

	else:
		return (ggt(b,a%b))


def eea(a,b):
	# rekursiver erweiterter euklidischer Algorithmus
    if b==0:
        return a,1,0
    else:
        t,r,s=eea(b,a%b)
        return t,s,r-(a//b)*s

print ("t,r,s:",eea(16,12)) #WERTE ZUM TESTEN HIER AENDERN
print("ggT:",ggt(200,28)) #WERTE ZUM TESTEN HIER AENDERN
testGGT(16,12,4,1,-1) #WERTE ZUM TESTEN HIER AENDERN