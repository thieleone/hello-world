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