package uebung2;

import java.util.LinkedList;

public class Eltern extends Kita{
	int kinder;
	String name;
	
	public Eltern(String name){
		this.name = name;
		kinder = 1 + rnd.nextInt(2);
		System.out.println(this.name + " betreten die Kita.");
	}
	
	public void run(){
		LinkedList<Erzieher> betreuendeErzieher = nimmKinderAuf(kinder);
		System.out.println(this.name + " hat seine " + kinder + " Kinder abgegeben.");
		Nap.randomNap(5000,10000);
		System.out.println(this.name + " ist zurück.");
		gebeKinderAb(betreuendeErzieher);
		System.out.println(this.name + " hat seine " + kinder + " Kinder abgeholt.");
	}
}
