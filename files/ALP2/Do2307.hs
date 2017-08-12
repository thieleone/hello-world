{-Do2307

[] = []







-}
makeSet::(Eq a)=>[a]->[a] --Objekte von a muessen vergleichbar sein, wichtig fuer x 'elem' xs
makeSet [] = []
makeSet (x:xs)
	|x 'elem' xs = makeSet xs
	|otherwise = x:makeSet xs



-----
okt2hex::String->String
okt2hex s=dec2hex(okt2dec s)
		where
			okt2dec::String->Integer
				okt2dec [] = 0
				okt2dec (x:xs)=(read x)*8^(length xs) + (okt2dec xs) --read macht aus einem Char ein Int

				dec2hex::Integer->[Char]
				dec2hex n
						|n<17=int2char n
						|otherwise = dec2hex(div n 16)++[int2char(mod n 16)]
								where 
									int2char x
											|x<10=head(show x)
											|x==10='A'
											|x==11='B'
											|x==12='C'
											|x==13='D'
											|x==14='E'
											|x==15='F'


-----

otherwise = error "Bla"

-----

elem::(Eq a)=>a->[a]->Bool
elem x [] = False
elem x (y:ys) = (x==y)||(x 'elem' ys)

encrypt :: String -> String
encrypt 





h e l l o o
h -> elloo = h + makeSet(elloo)
				e->lloo = e + makeSet(lloo)
							l -> loo = makeSet(loo)
										l -> oo = l + makeSet(oo)
														o -> o = makeSet(o)
																	o -> [] = o + makeSet([])
																					[]
helo


8	2
0	000
1	001
2	010
3	011
4	100
5	101
6	110
7	111

8^0
0^2 + 0^1 + 0^0
8^1
8^2