def pruefe(a,n):
	for i in range(n):
		if a[i]>a[i+1]:
			a[i],a[i+1]=a[i+1],a[i]

def pruefe_alle(a,n):
	for i in range(n):
		pruefe(a,i)

def bubblesort(a):
	n=len(a)
	for i in range(n,1,-1):
		pruefe_alle(a,i)

a=[9,8,7,6,5,4,3,2,1,0]
print(a)
bubblesort(a)
print(a)