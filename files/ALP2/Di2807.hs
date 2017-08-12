--Di2807
Primitive Datentypen -> Typ-Synonyme -> Polymorphe Datentypen -> Algebraische Datentypen

data Hamburger = Brot | Fleisch | Kaese | Tomaten | Guerkchen | Ketchup|
				 Anker  Anker     Anker   Anker     Anker       Anker



Brot Hamburger | Fleisch Hamburger | Kaese Hamburger | Tomaten Hamburger | Guerkchen Hamburger | Ketchup
Schritt			 Schritt			 Schritt		   Schritt			   Schritt				 Anker

checkCheeseburger :: Hamburger -> Bool
checkCheeseburger (Brot(Fleisch(Kaese(Tomaten Ketchup)))) = True
checkCheeseburger _ = False


istVegan Ketchup = True -- Anker
istVegan (Brot x) = istVegan x
istVegan (Fleisch x) = False
istVegan (Kaese x) = False
istVegan (Tomaten x) = istVegan x


data Buhl = Ja | Nein | Vielleicht --3 Konstruktoren

unt:: Buhl -> Buhl -> Buhl
unt  Ja Ja = Ja
unt Ja Nein = Vielleicht
unt Vielleicht Vielleicht = Ja
unt	Nein Nein = Nein
unt Vielleicht Nein = Nein
unt Ja Vielleicht = Nein

nichts::Buhl -> Buhl
nichts Vielleicht = Nein
nichts Ja = Nein
nichts Nein = Vielleicht


data Zahl = Pinkes Zahl | Seepferdchen deriving Show
addi::Zahl -> Zahl -> Zahl
addi Seepferdchen y = y
addi (Pinkes x) y = Pinkes (addi x y)

addi ( Pinkes (Pinkes Seepferdchen)) (Pinkes Seepferdchen)
=> Pinkes (addi (Pinkes Seepferdchen) (Pinkes Seepferdchen))
=> Pinkes (Pinkes (addi Seepferdchen (Pinkes Seepferdchen)))
=> Pinkes (Pinkes (Pinkes Seepferdchen))

multi::Zahl -> Zahl -> Zahl
multi Seepferdchen y = Seepferdchen
multi (Pinkes x) y = addi (multi x y) y
--     (x+1) 	*y =          (x*y) + y

multi (Pinkes (Pinkes Seepferdchen)) (Pinkes Seepferdchen)
=> addi (multi (Pinkes Seepferdchen) (Pinkes Seepferdchen)) (Pinkes Seepferdchen)
=> addi (addi (multi Seepferdchen ( Pinkes Seepferdchen)) (Pinkes Seepferdchen)) (Pinkes Seepferdchen)
jui kjsfi