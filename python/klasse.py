class C:
	pass




exemplar1 = C()
exemplar2 = C()

C.a = 4

exemplar1.a = 2

C.a = 4

exemplar3 = C()
print(exemplar1.a)
print(exemplar2.a)
print(exemplar3.a)


