def ggT(a,b):
	if b==0:
		return (a)

	else:
		return (ggT(b,a%b))
def calcE(u,v,max):
	counter=0
	for i in range(1,max):
		for j in range(i+1,max+1):
			if ggT(i,j)==1:
				counter+=1
				if i==u and j==v:
					return counter

print(calcE(5,6,6))