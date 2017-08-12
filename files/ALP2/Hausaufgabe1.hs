Hausaufgabe1


--A1
quadSolutions :: (Double,Double,Double)->[Double]
quadSolutions (a,b,c) 
                |a==0 = error 'a darf laut Definition nicht 0 sein'
                |b**2-4*a*c<0=[]
                otherwise = [(-b+sqrt(b**2-4*a*c))/(2*a),(-b-sqrt(b**2-4*a*c))/(2*a)]

--A3
approxpi :: Int -> Float
approxpi 0 = 4
approxpi n = 4*(-1)^n/(2*n+1) + approxpi (n-1)
            

--A4
echtTeiler :: Int->[Int]
a=n
echtTeiler 0 = []
echtTeiler n
            |a==n = echtTeiler (n-1)
            |mod a n == 0 = n:echtTeiler (n-1)
            otherwise = echtTeiler (n-1)

--A5
maxNeighborsDistance::[Int]->Int
maxNeighborsDistance x:y:xs = maxNeighborsDistanceRek
a = 0
maxNeighborsDistanceRek [] = 0
--maxNeighborsDistanceRek x:xs = 0
maxNeighborsDistanceRek x:y:xs
                    |betrag (x-y) > a
                            where
                                betrag :: Integer-> Integer
                                betrag x
                                    |x>=0=x
                                    |otherwise = -x