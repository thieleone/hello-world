eval3 :: Float -> Float -> Float -> Float -> Float -> Float
eval3 r a b c d = (r^3)*a + (r^2)*b + r*c+d


nullstellenTest2 :: Float -> Float -> Float -> Bool
nullstellenTest2 kms




cyclicShift :: Int -> Int -> Int -> Int -> Int
cyclicShift k n m s
	|(m >= (k+n)) = m
	|(m+(s 'mod' n)) < (k + n) = m+(s 'mod' n)
	|otherwsie = m+(s 'mod' n)-n


caesarForCapitals :: Char -> Int -> Char
caesarForCapitals ch k
	|ch<zahl1 && ch>zahl2 = ch
	|(ch+k) < zahl2 = ch+(k 'mod' (zahl2 - zahl1))
	|otherwise = ch+(k 'mod' (zahl2 - zahl1))-(zahl2-zahl1)

zahl1 -> minGB
zahl2 -> maxGB

mirrorForCapitals :: Char -> Char -> Char
mirrorForCapitals ch1 ch2
	|ch1<zahl1&&ch1>zahl2 = ch1
	|ch2<zahl1&&ch2>zahl2 = ch1
	|ch1>ch2 && (ch2-(ch1-ch2)>=zahl1 = ch2-(-ch1-ch2)
	|ch1>ch2 = ch2 - (ch1-ch2) + (zahl2-zahl1)
	|ch1<ch2 && (ch2 + (ch2-ch1))<=zahl2 = ch2 + (ch2-ch1)
	|otherwise = ch2 + (ch2-ch1) - (zahl2-zahl1)