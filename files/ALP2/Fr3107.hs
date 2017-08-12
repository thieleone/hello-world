--3107
min []=x
min (x:xs) = minH x:xs x
				where 
					minH [] x = x
					minH x:xs y

						|x<=y=minH xs x
						|otherwise= xs y




fibo Zero = Zero
fibo (S Zero) = (S Zero)
fibo (S(s(n)) = add (fibo n) fibo (S n))

cutSub a b
cutSub a b  = foldn npred a b


height::SBTree -> Int
height L=0
height (N l r) = 1 + (max (height l) (height r))

balanced::SBTree -> Bool
balanced l = True
balanced (N rt lt) = (balanced rt && balanced lt) && height rt == height lt


Lmabda-Kalkül
S -> E
V -> a | b | c | ... | z
E -> jV.E | EE | V
j=Lambda
jV.E --Abstraktion rechtsassoziativ
EE --Applikation linksassoziativ


S -> ... -> ja.b
S -> E -> jV.E -> ja.E -> ja.V -> ja.b

Es ist genau dann ein Ausdruck, wenn ich ihn mit endlich vielen Schritten aus S herleiten kann.



(ja.     ab)
Kopf	Rumpf


(ja.(jb.(jc.(jd.((((a)b)c)d)
(ja.(jb.(((a)b)c))


((((ja.b))(jb.a))b)

(jac.ab)
=
ja.jc.ab

(jac.ab)
gebundene Varaiblen: a, c weil sie im Kopf auftauchen sind sie im entsprechenden Rumpf gebunden
freie Variablen: b

jb.(jac.ab)
gebundene Varaiblen:a, b, c
freie Variablen:

(jab.a(jc.d)cda(jb.a))

Eine Variable ist immer dann im Rumpf eines lambda-ausdrucks gebunden, wenn sie im kopf vorkommt.


alpha-Konversion => umbenennen
man darf nur gebundene Variablen alpha-konversieren
(jabc.abcd) =alpha> (jxyz.xyzd)

beta-Reduktion => Konsumieren






