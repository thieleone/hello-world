public class Mobile<E> /*extends BTNode<E>*/ {
	private boolean ball, baton;
	private float weight, length, leftLength, rightLenght;
	private Mobile<E> left, right, parent;


// Konstruktor fuer batons.
	public Mobile(){
		setBaton(true);
		setBall(false);
	}

// Konstruktor fuer balls.
	public Mobile(float w){
		setBaton(false);
		setBall(true);
		setWeight(w);

	}
    
   	public Mobile<E> leftChild() { return left; }
    
   	public void setLeft(Mobile<E> v) { left=v; }
    
	public Mobile<E> rightChild() { return right; }

	public void setRight(Mobile<E> v) { right=v; }

	public Mobile<E> parent() { return parent; }

	public void setParent(Mobile<E> v) { parent=v; }

// ---------------------------------------------------------------------
	
// Basismethoden zum Setzen der Werte
	public void setWeight(float f){weight=f;}

	public void setLength(float f){length=f;}

	public void setLeftLength(float f){leftLength=f;}

	public void setRightLength(float f){rightLenght=f;}

	public void setBaton(boolean b){baton=b;}

	public void setBall(boolean b){ball=b;}



// Methode zum Herstellen der Balance und Bestimmung des Gewichtes der batons
	public void balance(){
		if(ball){
			// return;
		}
		else{
			left.balance();
			right.balance();

// Das Gewicht des batons ergibt sich aus der Summe der Gewichte der Kinder
			setWeight(left.weight+right.weight);

// Um im Gleichgewicht zu sein muss
// leftLength*left.weight==rightLength*right.weight gelten
// Das laesst sich wie folgt leicht garantieren:
			setLeftLength(right.weight);
			setRightLength(left.weight);
			setLength(left.weight+right.weight);
// Solange sich das Mobile nicht bewegt(Rotation) koennen sich die Kugeln
// bei dieser Methode nur beruehren, aber nicht aufeinander einwirken
// was laut Aufgabenstellung gefordert war
		}
	}	

// Ausgabe des Mobiles:
// fuer balls wird das Gewicht ausgegeben
// fuer batons Gewicht, Laenge, linke und rechte Laenge
// und die Methode wird fuer die Submobiles aufgerufen 
	public void rep(){
		if (ball){
			System.out.println("Gewicht: "+weight);
		}
		else{
			System.out.println(this+" Gewicht: "+weight+" Laenge: "+length+
				" linke Laenge: "+leftLength+" rechte Laenge: "+rightLenght);
			left.rep();
			right.rep();
		}
	}
}