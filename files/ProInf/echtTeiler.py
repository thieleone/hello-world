def echtTeiler():
	erg=[]
	n=int(input("Bitte geben Sie eine natuerliche Zahl ein! "))
	for i in range (2,n):
		if n % i == 0:
			erg.append(i)
	print(erg)

echtTeiler()