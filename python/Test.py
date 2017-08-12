# def na(**a):
	
# 	mydictionary={a:10,b:20}
# 	print(mydictionary[a])


# na(li,sa)

# def litest(Start, Hilfsstift, Ziel):
	# i=1
	# x=[]
	# x.append(i)
	# x.append('a')
	# print(x)
	# a = (input("Bitte geben Sie a an: "))
	# b = (input("Bitte geben Sie b an: "))
	# c = (input("Bitte geben Sie c an: "))
	# stifte = [3]
	# stifte[0].append(a)
	# stifte[1].append(b)
	# stifte[2].append(c)
	# print(stifte)
# 	namen=[]
# 	namen.append(Start)
# 	namen.append(Hilfsstift)
# 	namen.append(Ziel)
# 	print(namen)
# 	bena=[]
# 	sta=[]
# 	hil=[]
# 	zie=[]
# 	bena.append(sta)
# 	bena.append(hil)
# 	bena.append(zie)
# 	sta.append(Start)
# 	print(sta)
# 	print(bena[0])
# 	nena=[]
# litest('Ha','l','lo')

def init_Hanoi(n, x, y, z):
	global stifte
	stifte=[]
	sta=[]
	hil=[]
	zie=[]
	stifte.append(sta)
	stifte.append(hil)
	stifte.append(zie)
	sta.append(x)
	hil.append(y)
	zie.append(z)
	i=n
	while i>0:
		sta.append(i)
		i=i-1

	print(sta)
	# Hanoi(n,sta,hil,zie)




init_Hanoi(5, 'A', 'B', 'C')




