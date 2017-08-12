data Tree = Nil | T Tree Tree Integer Integer

summe :: Tree -> Integer -> Integer -> Integer
summe (T l r xs xw) a b = sucheIntervallGrenzeB (T l r xs xw) a b

sucheIntervallGrenzeB :: Tree -> Integer -> Integer -> Integer
sucheIntervallGrenzeB Nil _ _= 0
sucheIntervallGrenzeB (T l r xs xw) a b
	|xs>b = sucheIntervallGrenzeB l a b 
	|otherwise = sucheIntervallGrenzeA (T l r xs xw) a b

sucheIntervallGrenzeA :: Tree -> Integer -> Integer -> Integer
sucheIntervallGrenzeA Nil _ _ = 0
sucheIntervallGrenzeA (T l r xs xw) a b
	|a>=xs = sucheIntervallGrenzeA r a b
	|otherwise = summeAB (T l r xs xw) a b

summeAB :: Tree -> Integer -> Integer -> Integer
summeAB Nil _ _ =0
summeAB(T l r xs xw) a b = xw+ summeA l a + summeB r b

summeA :: Tree -> Integer -> Integer
summeA Nil _ = 0
summeA (T l r xs xw) a 
	|xs>a = xw + normaleSumme r+ summeA l a
	|otherwise = summeA r a

summeB :: Tree -> Integer -> Integer
summeB Nil _ = 0
summeB (T l r xs xw) b 
	|xs<=b = xw + normaleSumme l+ summeB r b
	|otherwise = summeB l b

normaleSumme :: Tree -> Integer
normaleSumme Nil = 0
normaleSumme (T l r xs xw) = xw + normaleSumme l + normaleSumme r	