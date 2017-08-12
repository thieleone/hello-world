
#i = input ("Bitte eine ganze Zahl: ")

def summe(l):
	assert type(l) == type([])
	res = 0
	for elem in l:
		assert type(elem) == 'int' or type(elem) == 'bool' or type(elem) == 'float'
		res += elem
	return res

assert summe([]) == 0
assert summe(list(range(10))) == 10 * 11 / 2

