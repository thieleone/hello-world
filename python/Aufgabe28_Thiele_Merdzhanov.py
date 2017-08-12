from turtle import *
class Weglaeufer(Turtle):
	def __init__(self, z, beg):
		self.wovor = z
		self.begrenzung = beg
		super().__init__()
		# Turtle.__init__(self) # das mÃ¼sste man in python2 schreiben.

	



	def lauf_weg(self, schrittweite=10):
		print(turtle.pos())
		print(self.heading())




		richtung = self.towards(self.wovor.position())
		self.setheading(richtung+180)
		self.lauf()

	def lauf(self,schrittweite=10):
		self.fd(schrittweite)
		if self.check():
			return
		else:
			self.lauf()

	def check(self,schrittweite=10):
		if (self.xcor()<=0):
			self.setheading(self.heading()+180)
			self.fd(schrittweite)

			if self.heading()>180:
				self.setheading(self.heading()-45)

			else:
				self.setheading(self.heading()+45)

			return 0


		elif (self.xcor()>self.begrenzung.oben):
			self.setheading(self.heading()+180)
			self.fd(schrittweite)

			if self.heading()>180:
				self.setheading(self.heading()+45)

			else:
				self.setheading(self.heading()-45)

			return 0


		elif (self.ycor()<=0):
			self.setheading(self.heading()+180)
			self.fd(schrittweite)

			if self.heading()>90:
				self.setheading(self.heading()-45)

			else:
				self.setheading(self.heading()+45)

			return 0



		elif (self.ycor()>self.begrenzung.rechts):
			self.setheading(self.heading()+180)
			self.fd(schrittweite)

			if self.heading()>270:
				self.setheading(self.heading()-45)

			else:
				self.setheading(self.heading()+45)

			return 0

		return 1


class Verfolger(Turtle):
	def __init__(self):
		super().__init__()

    	# Turtle.__init__(self) # das mÃ¼sste man in python2 schreiben.
	def setze_ziel(self,x):
		self.wen = x

	def verfolge(self, schrittweite=5):
		richtung = self.towards(self.wen.position())
		self.setheading(richtung)
		self.fd(schrittweite)


import turtle
class Rechteck(Turtle):
	def __init__(self,l,r,u,o):
		self.links=l
		self.rechts=r
		self.unten=u
		self.oben=o

	def zeichne(self):
		rechteck=turtle.Turtle()
		rechteck.speed=(20)
		rechteck.forward(self.unten)
		rechteck.left(90)
		rechteck.forward(self.rechts)
		rechteck.left(90)
		rechteck.forward(self.oben)
		rechteck.left(90)
		rechteck.forward(self.links)
		#turtle.done()

test=Rechteck(200,200,300,300)
test.zeichne()
verf=Verfolger()  	
wegl=Weglaeufer(verf,test)
verf.setze_ziel(wegl)
wegl.setx(wegl.begrenzung.oben//2)
wegl.sety(wegl.begrenzung.rechts//2)
verf.setx(wegl.begrenzung.oben//2)
for i in range(100):
	wegl.lauf_weg()
	verf.verfolge()






















# a=3
# id(a)=14064548... (Adresse)
# a=5
# id(a)=24334235...