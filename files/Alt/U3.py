

#Aufgabe 3 b

def is_sorted(lst):

    if lst[0]<lst[(len(lst)-1)]:    #Vergleich zwischen erstem und letztem Element
        for i in range(0,len(lst)-1):   
            if not i<=(i+1):
                return 0
        return 1
    elif lst[0]>lst[(len(lst)-1)]:
        for j in range(0,len(lst)-1):
            if not i>=(i+1):
                return 0
        return -1
    else
        return 0    
    #else entweder enthaelt die liste nur ein element - ansteigend oder absteigend sortiert?
    #oder alle elemente der liste haben den selben wert - ansteigend oder absteigend sortiert?
    #aufgrund der Unklarheit ->return 0
    #oder das erste element und das letzte sind gleich, die elemente dazwischen verschieden, somit unsortiert -> return 0



#Aufgabe 3 b

import random

def generate_random_list(a,b,n):
    lst = []
    for n in lst:
        lst[n]=random.randint(a,b)
    return lst



#Aufgabe 3 c

def bubblesort(original_list):

    copied_list = [ x for x in original_list]
    #eine Kopie der unsortierten Liste wird zum spaeteren Vergleich erzeugt
    
    #Bubblesort mit swaps zum zaehlen der Bewegungen
    swaps = 0
    for x in range(0, len(original_list) -1):
        for y in range(0, len(original_list)-x-1):
            if original_list[y] > original_list[y+1]:
                tmp = original_list[y+1]
                original_list[y+1] = original_list[y]
                original_list[y] = tmp
                swaps += 1
    swaps *= 2
    #mit jedem swap werden zwei Bewegungen ausgefuehrt
    



    needed_moves = 0
    #Berechnung der im Optimalfall benoetigten Bewegungen
    #die sortierte Liste wird durchlaufen
    for x in range(0, len(original_list)):
        #nun wird das entsprechende Element in der unsortierten Liste gesucht, um die "Entfernung" zu bestimmen
        for y in range(0, len(copied_list)):  
            if original_list[x] == copied_list[y]:
                copied_list[y] = None   #dadruch ist es kein Problem, wenn Werte mehrfach auftreten
                needed_moves += abs(x - y)
                break   #wichtig, wenn ein Wert mehrfach vorkommt, außerdem effizienter
            
    #Rueckgabe: sortierte Liste, Bewegungen in die falsche Richtung, Bewegungen in die richtige Richtung
    return original_list, (swaps - needed_moves)/2, needed_moves + (swaps - needed_moves)/2
    #es wird durch zwei geteilt, da die eine Haelfte der Differenz Bewegungen in die falsche und die andere Haelfte Bewegungen in die richtige Richtung sind


print(bubblesort([9, 8, 7, 6, 5, 4, 3, 2, 1]))



#Aufgabe 5a

import random

def partition( A, low, high ):
    pivot = (A[random.randint(low,high)] + A[random.randint(low,high)] + A[random.randint(low,high)]) /3
    i = low
    for j in range(low+1,high+1):
        if ( A[j] < pivot ):
            i=i+1
            A[i], A[j] = A[j], A[i]
    A[i], A[low] = A[low], A[i]
    return i


def quicksort (A, low, high ):
    if low<high:
        m = partition(A, low, high )
        quicksort ( A, low, m-1 )
        quicksort ( A, m+1, high )



#Aufgabe 5e

def insertsort(seq):
    for j in range(1,len(seq)):
        key = seq[j]
        k = j-1
        while k>=0 and seq[k]>key:
            seq[k+1] = seq[k]
            k = k-1
        seq[k+1] = key


def partition( A, low, high ):
    pivot = A[low]
    i = low
    for j in range(low+1,high+1):
        if ( A[j] < pivot ):
            i=i+1
            A[i], A[j] = A[j], A[i]
    A[i], A[low] = A[low], A[i]
    return i



def Quick_Insert (A, low, high, k):
    if len(A)<k:
        insertsort(A)
    elif low<high:
        m = partition(A, low, high )
        Quick_Insert ( A, low, m-1 )
        Quick_Insert ( A, m+1, high )




