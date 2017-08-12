package uebung2;

public class Erzieher extends Kita{
	//public Semaphore s = new Semaphore(5);
	public boolean willGehen = false;
	public int kinderZugewiesen = 0;
	public String name;
	
	public Erzieher(String name){
		this.name = name;
		try{
			mutex.acquire();
		}
		catch(InterruptedException e){}
		erzieher.add(this);
		verfuegbarePlaetze += 5;
		warteAufPlaetze.release();
		System.out.println(this.name + " ist eingetroffen.");
		printKitaStatus();
		mutex.release();
	}
	
	public void run(){
		Nap.randomNap(20000,30000);
		//Sobald Arbeitszeit vorbei, gebe alle noch betreuten Kinder ab
		try{
			mutex.acquire();
		}
		catch(InterruptedException e){}
		//Erzieher kündigt an, dass er gehen will und nimmt keine neuen Kinder mehr auf.
		System.out.println(this.name + " will gehen.");
		verfuegbarePlaetze -= 5 - kinderZugewiesen ;
		willGehen = true;
		mutex.release();
		//Kinder werden anderen Erzieherinnen in der Kita zugewiesen.
		nimmKinderAuf(kinderZugewiesen);
		try{
			mutex.acquire();
		}
		catch(InterruptedException e){}
		erzieher.remove(this);
		verfuegbarePlaetze -= kinderZugewiesen;
		belegtePlaetze -= kinderZugewiesen;
		System.out.println(this.name + " ist gegangen.");
		printKitaStatus();
		mutex.release();
	}

}
