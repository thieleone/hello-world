def mergeIter(lst, hlst, low, mid, high):
	if mid >= len(lst):
		return
	if high > len(lst):	#Anpassung an die laenge der liste
		high = len(lst)

	help1 = low
	help2 = mid

	for x in range(low, high):



		#verhindert, dass nicht mit einem Index gearbeitet wird, der nicht in der Liste ist
		if help1 == mid :
			hlst[x] = lst[help2]
			help2 += 1
		elif help2 == high:
			hlst[x] = lst[help1]
			help1 += 1




		elif lst[help2] < lst[help1]:	#wenn der Wert kleiner ist, wird er in der Hilfsliste
										#an der Stelle x gespeichert
			hlst[x] = lst[help2]
			help2 += 1
		else :
			hlst[x] = lst[help1]
			help1 += 1

	for x in range(low, high):	#die Liste bekommt die Wert der Hilfsliste zugewiesen
		lst[x] = hlst[x]



def mergesortIter(lst):
	hlst = [0 for i in lst]	#"helplist" mit Laenge der uebergebenen Liste, alle Elemente 0
	actualsize = 1
	while actualsize < len(lst):
		start = 0
		while start < len(lst):
			mergeIter(lst, hlst, start, start+actualsize, start+2*actualsize)
			start+= 2*actualsize
		actualsize *= 2
	return lst