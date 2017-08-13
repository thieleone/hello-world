package uebung2;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Kita extends Thread{
	public static LinkedList<Thread> queue = new LinkedList<Thread>();
	public static LinkedList<Erzieher> erzieher = new LinkedList<Erzieher>();
	
	Semaphore plaetzeAnfrage = new Semaphore(1);
	Semaphore warteAufPlaetze = new Semaphore(1);
	Semaphore mutex = new Semaphore(1);
	
	public static int belegtePlaetze = 0;
	public static int verfuegbarePlaetze = 0;
	public static Random rnd = new Random();
	
	//Gibt eine Liste der Erzieher zurück, die die Kinder betreuen
	public LinkedList<Erzieher> nimmKinderAuf(int kinderAnzahl){
		LinkedList<Erzieher> betreuendeErzieher = new LinkedList<Erzieher>();
		queue.add(Thread.currentThread());
		System.out.println("Belegt:" + belegtePlaetze + "Verfuegbar:"+ verfuegbarePlaetze);
		while(belegtePlaetze + kinderAnzahl > verfuegbarePlaetze || Thread.currentThread() != queue.getFirst() ){
			try{
				warteAufPlaetze.acquire();
			}
			catch(InterruptedException e){};
		}			
		//Gehe alle Erzieherinnen durch und versuche, Kinder aufzunehmen
		try{
			mutex.acquire();
		}
		catch(InterruptedException e){}
		int i = 0;
		while(i<erzieher.size() && kinderAnzahl>0)
		{
			while(!erzieher.get(i).willGehen && erzieher.get(i).kinderZugewiesen < 5 && kinderAnzahl > 0){
				kinderAnzahl--;
				belegtePlaetze++;
				verfuegbarePlaetze--;
				erzieher.get(i).kinderZugewiesen++;
				betreuendeErzieher.add(erzieher.get(i));
			}
		}
		queue.removeFirst();
		printKitaStatus();
		mutex.release();
		//Nächste Anfrage nach Plätzen darf durchgeführt werden
		//plaetzeAnfrage.release();
		return(betreuendeErzieher);
	}
	
	//Finde die Kinder bei den Erziehern und gebe diese frei
	public void gebeKinderAb(LinkedList<Erzieher> betreuendeErzieher){
		//Plaetze müssen synchronisiert freigegeben werden, benutze daher Semaphore gebePlaetzeFrei als lock
		try{
			mutex.acquire();
		}
		catch(InterruptedException e){}
		for(int i = 0; i < betreuendeErzieher.size(); i++){
				betreuendeErzieher.get(i).kinderZugewiesen--;
				belegtePlaetze--;
				verfuegbarePlaetze++;
		}
		printKitaStatus();
		warteAufPlaetze.release();
		mutex.release();
	}
	
	public void printKitaStatus(){
		String status = "Current Status: ";
		for(int i=0; i<erzieher.size(); i++){
			status = status + erzieher.get(i).name + ": " + (erzieher.get(i).kinderZugewiesen + ",");
		}
		System.out.println(status);
	}
	
	public static void main(String[] args){
		int erzCount = 1;
		int eltCount = 0;
		Erzieher e0 = new Erzieher("Erzieher" + erzCount);
		e0.start();
		while(true){
			int nextInstance = rnd.nextInt(5);
			if(nextInstance == 0){
				erzCount++;
				Erzieher e = new Erzieher("Erzieher" + erzCount);
				e.start();
			}
			else{
				eltCount++;
				Eltern e = new Eltern("Elternpaar" + eltCount);
				e.start();
			}
			Nap.randomNap(10000,20000);
		}
	}	
}
