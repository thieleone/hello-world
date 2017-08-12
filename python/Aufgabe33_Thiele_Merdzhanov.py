# Philipp Thiele, Yavor Merdzhanov
# Tutor: Alexander Zachrau
# Tutroium: Dienstag, 12-14 Uhr
def bubblesort_ww (A):
	Ende = len(A)-1
	while Ende>0:
		assert issorted(A,Ende,len(A)-1)
		letzteAenderung = 0
		i=0
		while i<Ende:
			if A[i]>A[i+1]:
				A[i], A[i+1] = A[i+1], A[i]
				letzteAenderung = i
			i=i+1
		Ende = letzteAenderung

# Man muss nur bis Ende, weil alle Elemente nach Ende auf jeden Fall sortiert sind.
# Das ist offensichtlich, da Ende den Index von letzteAenderung zugewiesen bekommt.


def issorted(A,b,c):
	if b==len(A)-1:
		return True
	for i in range(b,c):
		if A[i]>A[i+1]:
			return False
	return True


A=[5,4,4,3,1,6,4,5,6,7,8,9]
print(A)
print(issorted(A,0,len(A)-1))
bubblesort_ww(A)
print(A)
print(issorted(A,0,len(A)-1))