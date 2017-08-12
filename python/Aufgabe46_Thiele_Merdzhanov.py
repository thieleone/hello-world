# Philipp Thiele, Yavor Merdzhanov
# Alexander Zachrau
# Di 12-14 Uhr

def tausche(lis,i,j):
	mem=lis[i]
	lis[i]=lis[j]
	lis[j]=mem
	


def zuklein(a,i):
	if a[i]>a[(i-1)/2]:
		tausche(a,i,(i-1)/2)
		zuklein(a,(i-1)//2)


def zugross(a,i):
	if a[2*i+1]<a[2*i+2]:
		if a[i]>a[2*i+1]:
			tausche(a,i,2*i+1)
			zugross(a,2*i+1)
	else:
		if a[i]>a[2*i+2]:
			tausche(a,i,2*i+2)
			zugross(a,2*i+2)
			
def heapsort(a):  
    def zuklein(a, i):  
        root = a  
  
        while root * 2 + 1 < i:  
            kid = root * 2 + 1  
            if child < i - 1 and a[kid] < a[kid + 1]:  
                kid += 1  
            if a[root] < a[kid]:  
                a[root], a[kid] = a[kid], a[root]  
                root = kid  
            else:  
                return  
  
    i = len(a)  
    a = i / 2 - 1  
    end = i - 1  
  
    while a >= 0:  
        zuklein(a, i)  
        a -= 1  
  
    while end > 0:  
        a[end], a[0] = a[0], a[end]  
        zuklein(0, end)  
        end -= 1  
