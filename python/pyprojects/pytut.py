a=[1,5,2,6,3,7]
for x in a[:]:
    if x>4:a.insert(1,x*3)

print(a)