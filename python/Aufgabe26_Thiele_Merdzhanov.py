def fak_rek(n):
	if n<0:
		raise ValueError("negatives Argument",n)
	if n==0:
   		return 1
	return n*fak(n-1)

print(fak_rek(50))



# def fak_goto(n):
# 	m=1
# 	START:
# 	if n>0:
# 		goto LOOP
# 	else if n==0:
# 		return m
# 	else:
# 		raise ValueError("negatives Argument",n)

# 	LOOP:
# 	m*=n
# 	n--
# 	goto START

def fak_it(n):
	if n<0:
		raise ValueError("negatives Argument",n)
	m=1
	while n>0:
		m*=n
		n=n-1
	return m


print(fak_it(50))