--Christopher Schappler
--Philipp Thiele
--Tutor: Can Göktas
--Tutorium: Di (10-12 Uhr)

--Aufgabenblatt 3

--Aufgabe 1a
{-
	Die Funktion sumIncluded3 prüft bei Eingabe von drei ganzzahligen
	Werten, ob eine der Zahlen die Summe der anderen beiden ist. Dazu
	wird jede der drei Möglichkeiten nacheinander geprüft und bei einer
	Übereinstimmung ein True zurückgegeben. Falls keine der Möglichkeiten
	zutrifft, wird False zurückgegeben.
-}
sumIncluded3 :: Int -> Int -> Int -> Bool
sumIncluded3 x y z
	|(x+y)==z = True
	|(x+z)==y = True
	|(z+y)==x = True
	|otherwise = False


--Aufgabe 1b
{-
	Die Funktion sumIncluded4 prüft bei Eingabe von vier ganzzahligen
	Werten, ob einer der Zahlen die Summe zweier anderer Zahlen dieser
	Eingabe ist. Dazu werden alle 3-elementigen Teilmengen der Eingebe
	mit der sumIncluded3 Funktion überprüft. Bei einer Übereinstimmung
	wird True zurückgegeben, ansonsten False.
-}
sumIncluded4 :: Int -> Int -> Int -> Int -> Bool
sumIncluded4 a b c d 
	|sumIncluded3 a b c = True
	|sumIncluded3 a b d = True
	|sumIncluded3 a d c = True
	|sumIncluded3 d b c = True
	|otherwise = False


--Aufgabe 1c
{-
	Die Funktion spanOf3 berechnet bei Eingabe dreier Gleitkommazahlen
	die Differenz zwischen der größten und der kleinsten Zahl. Dazu
	werden die Werte untereinander verglichen und dann die Differenz
	zwischen der größten und der kleinsten Zahl berechnet.
-}
spanOf3 :: Float -> Float -> Float -> Float
spanOf3 x y z
	|(x<=y)&&(z>=y) = z-x
	|(x<=y)&&(x<=z) = y-x
	|(x<=y) = y-z
	|(x<z)  = z-y
	|(y<=z) = x-y
	|(z<y)  = x-z


--Aufgabe 1d
{-
	Die Funktion thirdMan berechnet bei Eingabe von zwei ganzen Zahlen
	die dritte fehlende Zahl. Dafür wird die Summe der beiden eingegebenen
	Zahlen von der Endsumme abgezogen.
-}
thirdMan :: Int -> Int -> Int
thirdMan a b = 6-(a+b)


--Aufgabe 2a
{-
	Die Funktion valueAt bestimmt einen zu einem gegebenen x-Wert gehörenden
	y-Wert zu einer Funktion g die in der Zweipunktform durch xg und yg gegeben ist.
-}
valueAt :: Float -> Float -> Float -> Float
valueAt xg yg x = (-yg/xg)*x+yg


--Aufgabe 2b
{-
	Die Funktion testParallel testet ob zwei Geraden, welche über die Zweipunktform
	bestimmt sind, parallel zueinander sind. Dazu prüft die Funktion die Steigungen
	der beiden Funktionen auf Gleichheit.
-}
testParallel :: Float -> Float -> Float -> Float -> Bool
testParallel xg yg xh yh = (-yg/xg)==(-yh/xh)


--Aufgabe 2c
{-
	Die Funktion parallelThroughX bestimmt einen zu einem gegebenen x-Wert gehörenden
	y-Wert zu einer Funktion h die zu einer in Zweipunktform gegebenen Geraden g,die
	in der Zweipunktform durch xg und yg gegeben ist, parallel ist.
-}
parallelThroughX :: Float -> Float -> Float -> Float
parallelThroughX xg yg x = (yg/xg)*x


--Aufgabe 2d
{-
	Die Funktion crossingAt testet ob zwei Geraden, welche über die Zweipunktform
	bestimmt sind, sich schneiden und falls es diesen Schnittpunkt gibt, die
	x-Koordinate bestimmt. Dazu prüft die Funktion mittels der testParallel Funktion
	die Steigungen der beiden Funktionen auf Gleichheit. Falls Gleichheit gilt, wird
	eine Fehlermeldung zurückgegeben. Ansonsten wird die x-Koordinate mittels der
	umgeformten Zweipunktform berechnet.
-}
crossingAt :: Float -> Float -> Float -> Float -> Float
crossingAt xg yg xh yh = 	if testParallel xg yg xh yh
							then error "Die Geraden sind parallel!"
							else (yg-yh)/((yg/xg)-(yh/xh))

							
--Aufgabe 2e
{-
	Die Funktion computeXg, bzw. computeYg bestimmt den x-Wert, bzw. y-Wert der
	Zweipunktform aus der Koordinatenform. Dazu wird geprüft, ob es sich um Parallen 
	zu der x-Achse oder Y-Achse oder um eine Ursprungsgrade handelt und dann eine
	Fehlermeldung zurück gibt. Ansonsten wird der entsprechende Wert bestimmt.
-}
computeXg :: Float -> Float -> Float -> Float
computeXg a b c = 	if (a==0)||(b==0)||(c==0)
					then error "Input out of scope"
					else c/a
	
computeYg :: Float -> Float -> Float -> Float
computeYg a b c = 	if (a==0)||(b==0)||(c==0)
					then error "Input out of scope"
					else c/b	


--Aufgabe 3
{-
	Die Funktion prim testet, ob eine eingegebene Zahl eine Primzahl ist.
	Da alle Zahlen kleiner gleich 1 keine Primzahlen seien können, wird
	bei dieser Eingabe False zurückgegeben. Da 2 die erste Primzahl ist,
	wird hier True zurückgegeben. Für alle Zahlen größer 2 wird mittels der
	Funktion help geprüft, ob die Zahl durch eine andere Zahl teilbar ist.
	Falls es keine Zahl gibt, zwischen 2 und der abgerundeten Wurzel unserer
	Eingabe,die die Eingabe teilt, so ist die Eingabe eine Primzahl.
-}
prim :: Int -> Bool
prim n
	| n <= 1 = False
	| n == 2 = True
	| otherwise = help n 2
	where
	help :: Int -> Int -> Bool
	help n k
		| (k*k) > n = True
		| mod n k == 0 = False
		| otherwise = help n (k+1)