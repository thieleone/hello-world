A=[1,2,3,4,5]
n=3
m=6
def finde_for(A,n):
	for l in range (0,len(A)):
		if A[l]==n:
			return l
	return None

def finde_while(A,n):
	j=0
	while j<len(A):
		if A[j]==n:
			return j
		j=j+1
	return None

i=finde_for(A,n)
print(i)

i=finde_while(A,n)
print(i)

i=finde_for(A,m)
print(i)

i=finde_while(A,m)
print(i)