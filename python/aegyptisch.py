def mul(a0,b0):
    "a0,b0>=0, ganzzahlig"
    a,b = a0,b0
    s = 0
    while a:
        assert True # Hier passende Invariante einfuegen
        if a%2: s+=b
        a//=2
        b+=b
    return s

print( mul(5,-25), mul(5,3), mul(7,7), mul(10,10) )
print("Test")
print('Test')