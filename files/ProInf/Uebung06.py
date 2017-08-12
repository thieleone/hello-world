def BinaryInsertionSort (a):
    n=len(a)

    for i in range(1,n):
        ins = binaersuche_rekursiv(a, a[i], 0, i)
        if (ins < i):
            tmp = a[i]
            for j in range(i - 1,ins, -1):
                a[j + 1] = a[j]
            a[ins] = tmp
    return a

def binaersuche_rekursiv(werte, gesucht, start, ende):
    if ende < start:
        return -start
    mitte = (start + ende)//2
    if werte[mitte] == gesucht:
        return mitte
    elif werte[mitte] < gesucht:
        return binaersuche_rekursiv(werte, gesucht, mitte+1, ende)
    else:
        return binaersuche_rekursiv(werte, gesucht, start, mitte-1)

print(BinaryInsertionSort([5,4,6,3,7]))