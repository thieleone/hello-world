'div'	+ 	-Infix
div		(+)	-Prefix
div 5 2 = 5 'div' 2

5 'div' (-2) = -3 (mod)
5 'quot' (-2) = -2 (rem)

x 'div' y -> ganzzahlig abgerundet
/ fließkomma division
2**3 = 8.0
2^3 = 8
a/=b = a!=b
True < False = Fals 
False < True = True

(0.1 == 0.3/3)
Darstellung fuer 0.3 ungenau (0.29...)

:load file
:l file
:reload
:r
:quit
:type

even x
	|x 'mod' 2 == 0 = True
	|otherwise = False
otherwise True

entspricht: even (x) =	-> wahr falls x mod 2 = 0
						-> falsch sonst

Referenzielle Transparenz
- Zustandsfreiheit von Funktionen
- keine Seiteneffekte
- bei gleicher Eingabe gleiches Ergebnis





mod x pos y neg
x mod -y + y

bmi:: Int -> Float -> Float
bmi gewicht groesse = gewicht / (groesse ** 2)

wct :: Float -> Float -> Float
wct T v  = 13.12 + 0.6215 ⋅ T − 11.37 ⋅ v ** (0.16) + 0.3965 ⋅ T ⋅v ** (0.16)