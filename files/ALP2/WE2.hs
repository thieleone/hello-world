poSeSo::[Integer]->Integer->Integer->[Integer]
poSeSo lst 1 m = poSeSo lst a (m-1)
poSeSo lst n 1 = lst
poSeSo lst n m = poSeSo (ins lst (n^m)) (n-1) m

		where a=n
			ins::[Integer]->Integer->[Integer]
			ins [] b = [b]
			ins x:xs b
					|b<x=b:x:xs
					|b==x=x:xs
					|otherwise x:(ins xs b)
poSeSo n aufrufe * m aufrufe = O(n^2)

ins max n*m aufrufe = O(n^2)

O(n^4)




poSeSo::[Integer]->Integer->Integer->[Integer]
poSeSo lst 0 m = poSeSo lst a m-1
poSeSo lst n 0 = lst
poSeSo [] n m = [(n^m)]
poSeSo x:xs n m 
			|(n^m)<=x=(n^m):x:xs




poSeSo::Integer->Integer->[Integer]
poSeSo n m = mRek (nRek [] n m) n (m-1) 

		where
			nRek lst 1 m = lst
			nRek lst n m = nRek (ins (n^m)) (n-1) m
			
			ins [] b = [b]
			ins x:xs b
					|b<x=b:x:xs
					|b==x=x:xs
					|otherwise x:(ins xs b)

			mRek lst n m = mRek (nRek lst n (m)) n (m-1)
			mRek lst n 1 = lst

poSeSo wird einmal aufgerufen und ruft einmal mRek auf, dass sich m-1 mal selbst aufruft.
Somit wird mRek m mal aufgerufen.

mRek ruft m mal nRek auf, dass sich n-1 mal selbst aufruft und somit m*n mal aufgerufen wird.
Im schlimmsten Fall(die erzeugte Liste ist absteigend sortiert) wird die Funktion ins n*m mal aufgerufen.
Somit ergibt sich eine Komplexitaet von m*n*m*n = O(n^4)