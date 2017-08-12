def verschiebe(F,b):
    i=0
    H=F
    while i<len(F):
        H[i]=F[i]-b
        i+=2
    return H

def fallunterscheidung(b,F,G):
    i=0
    H = []
    while F[i]<b&&i<len(F)-1:
        H+=(F[i],F[i+1])
        i+=2

    if F[i]>=b:
        H+=b

    j=0
    while G[j]<=b:
            j+=2

    while j<len(G)-1:
            H+=(G[j-1],G[j])
            j+=2

    return H