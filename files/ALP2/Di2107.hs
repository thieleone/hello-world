--Dienstag, 21.07

--1. Aufgabe
f0 x y = (a+1)*(b+2)
	where
	a = (x+y)/2
	b = (x+y)/3
	
f x y = (a+1)*(b+2)
	where
	a = x+y
	b = x-y
	
f2 xy=(a 3)+(b 5)
	where
	a x = x*x
	b y = y*2

gxy=a
	where
	a = x*y

g2 x y = a x y
	where
	a x y = x*y

u= let a=0
	b=a+(letc=3 in c+a)
in b * b

u2 n= let a=2*n
	b=a+(let a=3
			b=c
		in a+b)
	c = a^2
	in b*b

	f0 1 2 = 15/2
	f 1 1 = 6
	f2 1 2 = 19
	g 2 1 = 2
	g2 2 1 = 2
	u = 9
	u2 0 = 9



--2.Aufgabe
teil:: Int->Int->Bool
teil a b = mod a b == 0



--3.Aufgabe
ungerade :: Integer -> Bool
ungerade n = rem n 2 == 1 || rem n 2 == -1



--3.Aufgabe
pyt :: (Int, Int, Int)->Bool
pyt (a, b, c)		|a<=0||b<=0||c<=0 = False

				|help (a, b, c) || help (a, c, b) || help (b, c, a) = True
					where
						help (a, b, c) = (a^2 + b^2) == c^2

--4.Aufgabe
mehrfach :: Int->Int->Int->Bool
mehrfach a b c = mod a b == 0 && mod a c == 0 || mod b a == 0 && mod b c == 0 || mod c a == 0 && mod c b == 0


mehrfach a b c
				|a/=b&&a/=c = mod a b == 0 && mod a c == 0
				|b/=a&&b/=c = mod b a == 0 && mod b c == 0
				|c/=a&&c/=b = mod c a == 0 && mod c b == 0
				|otherwise = False



--5.Aufgabe
toLower:: Char -> Char
toLower cha 	|fromEnum cha > 64 && fromEnum cha < 91 = toEnum((fromEnum cha) + 32)
				|otherwise cha



--8.Aufgabe
area::Double->Double->Double
area = n*s*a/2
		where a=s/(2*tan (pi/n))



--9.Aufgabe
{-  -}
type Point = (Double,Double)
type Rectangle = (Point,Point)
area :: Rectangle -> Double
area ((x1,y1) (x2,y2)) = (x2-x1)*(y1-y2)
{-  -}
overlaps :: Rectangle -> Rectangle -> Bool
overlaps ((x1,y1),(x2,y2)) ((a1,b1),(a2,b2)) = not(a2 <= x1 || x2 <= a1 || y1 <= b2 || b1 <= y2)
{- Alle Punkte eines Rechteckes muessen innerhalb der Grenzen des anderen liegen. -}
{-contains :: Rectangle -> Rectangle -> Bool
contains ((x1,y1),(x2,y2)) ((a1,b1),(a2,b2)) = (a1 >= x1 && b1 <= y1 && a2 >= x2 && b2 <= y2) || (x1 >= a1 && y1 <= b1 && x2 >= a2 && y2 <= b2)
-}
contains::Rectangle->Rectangle->Bool
contains ((x1,y1),(x2,y2)) ((a1,b1),(a2,b2))=x1<=a1&&x2>=a2&&y1>=b1&&y2<=b2||a1<=x1&&a2>=x2&&b1>=y1&&b2<=y2





