def hel(li):
	max=0;
	maxel=0;
	for i in li:
		if li.count(i)>max:
			max=li.count(i)
			maxel=i;
	print("Haeufigstes Element:",maxel);
	print("Anzahl der Vorkommen:",max);

hel([1,1,1,2,4,6,6,5,2,6,6])