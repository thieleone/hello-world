data SBTree = L I N SBTree SBTree

blattEin L = N L L
blattEin (N | r)
		|height l <= height r = N (blattEin | ) r
		|otherwise			  = N | (blattEin r)

blaetterEin::SBTree -> Integer -> SBTree
blaetterEin
blaetterEin




blattLoeschen::SBTree -> SBTree
blattLoeschen (N L L) = L
blattLoeschen L = error "bla"
blattLoeschen (N x y)
				|height x > height y = (N (blattLoeschen x) y)
				|otherwise			 = (N x (blattLoeschen y))

-----
blaetterLoeschen::SBTree -> Integer -> SBTree
blaetterLoeschen tree 0 = tree
blaetterLoeschen tree n = blaetterLoeschen (blattLoeschen tree) (n-1)



{-
1) Wir zaehlen die Anzahl der Funktionsaufrufe von mult in Abhaengigkeit von m.
Annahme: (+) e O(1)

2) worst case = best case = average case

Man muss m-mal die Funktion  mult aufrufen. In jedem Aufruf wird einmal (+) aufgerufen.
f(m) - 1 * m e O(m)



Primitive Datentypen -> Typ-Synonyme -> Polymorphe Datentypen -> Algebraische Datentypen -> Abstrakte Datentypen
Int Integer				type String = [Char]		a 				data Baum = ...			module
Float Double										b
Bool Char											c


-}

--					-> exportlist <- import Queue.hs (wenn im selben Ordner)
module Queue (Q a, enqueue, dequeue, peek, empty, isEmpty) where

--Das ist eine Warteschlange

	data Q a = L | K a (Q a) --Liste

	enqueue::(Q a, a) -> Q a
	dequeue::Q a -> (Q a, a)
	isEmpty::Q a -> Bool
	empty:: Q a -> a

enqueue (L, x) = (K x L)
enqueue (K e rest, x) = (K e (enqueue (rest, x)))

empty = L

isEmpty L = True
isEmpty _ = False


-----
module ProInf where
	import Aufgabenzettel01 as A1
	import Aufgabenzettel02 as A2
	...
	import Aufgabenzettel10 as A10
--so sehen Importanweisungen aus


-- ++ Operator fuer Klausur

-- Aufgabe 5
permu :: [a] -> [[a]]
permu [] = []
permu xs = [(x:ys) | x<-xs, ys <- permu (delete x xs)] --alternativ filter (/=x) xs

ispalapsi :: (Eq a) => [a] -> Bool
ispalapsi [] = True
ispalapsi [x] = True
--ispalapsi xs = (erstesElem xs == letztesElem xs) && ispalapsi (ohneAnfangUndEnde xs)
ispalapsi xs =




	where
		erstesElem [] = error "bla"
		erstesElem (x:xs) = x)

		letztesElem [] = error "bla"
		letztesElem [x] = x
		letztesElem (x:xs) = letztesElem xs

		ohneAnfangUndEnde [] = error "bla"
		ohneAnfangUndEnde (x:xs) = take ((length xs)-1) xs


















