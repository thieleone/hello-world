class Integral:

	def SageHallo(self):
        print("Hallo")

        #x.SageHallo()
	def SageHallo(self):
        print("Hallo, mein Name ist " + self.name)

    def SetzeNamen(self, name):
        self.name = name

    def SetzeBaujahr(self, baujahr):
        self.baujahr = baujahr

    def __init__(self, name, baujahr):
        self.name = name
        self.baujahr = baujahr

    def SageHallo(self):
        print("Hallo, mein Name ist " + self.name)

    def NeuerName(self, name):
        self.name = name

    def NeuesBaujahr(self, baujahr):
        self.baujahr = baujahr
     
 class Stammfunktion:
	def __init__(self, name, baujahr):
        self.name = name
        self.baujahr = baujahr

    def SageHallo(self):
        print("Hallo, mein Name ist " + self.name)

    def NeuerName(self, name):
        self.name = name

    def NeuesBaujahr(self, baujahr):
        self.baujahr = NeuesBaujahr




  

    x = Roboter()
    x.SetzeNamen("Marvin")
    x.SetzeBaujahr(1979)
    y = Roboter()
    y.SetzeNamen("Caliban")
    y.SetzeBaujahr(1993)
    x.SageHallo()
    y.SageHallo()


if __name__ == "__main__":
    x = Roboter("Marvin", 1979)
    y = Roboter("Caliban", 1993)
    x.SageHallo()
    y.SageHallo()



    1,2,3,4,5

1
2x
3
4x
5

Anfang
Liste mit ((Faktor,Konstante,Ende))

Zugriff durch list[x][y] mit x uebergeordnet, y element



