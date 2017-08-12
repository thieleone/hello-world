--Mo2707
tails::[a]->[[a]]
tails []=[]
tails [x]=[[x]]
tails (x:xs)=[(x:xs)]++tails xs

prefix::(Eq a)=>[a]->[a]->[a]
prefix _[] = error
prefix []_ = error
prefix (x:xs)(y:ys)
			|x\=y=[]
			|x==y=x:(prefix xs ys)

l_prefix (Eq a)=>[[a]]->(Int,[a])
l_prefix [] = (0;[])
l_prefix [x] = (o,[])
l_prefix (x:y:xs) = (maximum ( map length listOfAllPrefixes), maximum listOfAllPrefixes))
				where
					listOfAllPrefixes [x]=[[x]]
					listOfAllPrefixes (x:y:ys)=prefix x y:listOfAllPrefixes(y:ys)





{-
lph 0 [] x ys
					where
						lph l pr []_ = (l,pr)
						lph l pr _[] = (l,pr)
						lph	l pr
-}


--quicksort
qs [] = []
--qs (x:xs) = qs [y|y<-xs,y<x]++[x]++qs[y|y<-xs,y>=x]


flatten :: [[a]] -> [a]
flatten []  =  []
flatten (l:ls)  =  l ++ flatten ls
flattenr = foldr (++) []
flattenl = foldl (++) []


bin2dec :: [Int] -> Int
bin2dec xs = foldl toDec 0 xs
where
                toDec a b = 2*a + b