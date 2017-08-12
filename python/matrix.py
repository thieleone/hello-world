def transpose(A):
	B=[]
	m=len(A[0])
	while m>0:
		B.append([])
		m=m-1

	print(A)

	for i in A:
		for j in range (0,len(i)):

			B[j].append(i[j])
	print(B)
			


transpose([[1,2,3,4,5],[6,7,8,9,0]])
transpose([[1,2],[3,4]])