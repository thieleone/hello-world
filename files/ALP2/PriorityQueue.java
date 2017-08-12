package u5;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class PriorityQueue {
	public PriorityQueue(int numberOfElements){
		queue=new ArrayList<Aufgabe>();
		queuelength=0;
		Aufgabe dummyAufgabe=new Aufgabe(0,0,"dummy");
		queue.add(dummyAufgabe);
		generate_messages(numberOfElements);
		
	}
	private List<Aufgabe> queue;
	private int queuelength;
	private int eingangsCounter;
	
	public int parent(int i){
		/** Gibt den Index des Elternelements des i-ten Elements zurück**/
		return i/2;
	}
	public int right(int i){
		/** Gibt den Index des rechten Kindelements im Baum zurück **/
		return i*2+1;
	}
	public int left(int i){
		/** Gibt den Index des linken Kindelements im Baum zurück **/
		return i*2;
	}
	
	private int findMoreImportant(int i, int j, List<Aufgabe> heapArray){
		/** Gibt von zwei Konten i und j den Index des Knotens zurück der weiter oben im Heap angeordnet werden sollte**/
		if (heapArray.get(i).priority>heapArray.get(j).priority)
			return i;
		else if(heapArray.get(i).priority<heapArray.get(j).priority)
			return j;
		else{//Priorität ist gleich
			if(heapArray.get(i).eingangsNr>heapArray.get(j).eingangsNr)
				return j;
			else
				return i;
		}
	}//End findMoreImportant
	private boolean testKnot(int i, List<Aufgabe> heapArray){
		/** Testet ob ein einzelner Knoten ein Knoten im Heap sein könnte**/
		if(queuelength>=right(i)){ //Es existiert ein rechtes und linkes Kind
			if(findMoreImportant(i, left(i), heapArray)==i && findMoreImportant(i, right(i), heapArray)==i)
				return true;
			else
				return false;
		}//if rechteslinkes Kind
		else if(queuelength>=left(i)){//Es existiert nur ein linkes Kind
			if(findMoreImportant(i, left(i), heapArray)==i)
				return true;
			else
				return false;
		}//if linkes Kind
		else//Knoten hat keine Kinder
			return true;
	}//End testknot
	private void sortKnot(int i, List<Aufgabe> heapArray){
		/**Stellt die Heap-Eigenschaft für den Knoten her**/
		Aufgabe temp;
		if (queuelength>=right(i)){  //Es existiert rechtes und linkes Kind
			if (findMoreImportant(i, left(i), heapArray)==left(i)){
				temp=heapArray.get(i);
				heapArray.set(i, heapArray.get(left(i)));
				heapArray.set(left(i),temp);
			}
			if(findMoreImportant(i, right(i), heapArray)==right(i)){
				temp=heapArray.get(i);
				heapArray.set(i,heapArray.get(right(i)));
				heapArray.set(right(i),temp);
			}
				
		}//if rechtslinks kind
		else if(queuelength>=left(i)){//Es existiert ein linkes Kind
			if (findMoreImportant(i, left(i), heapArray)==left(i)){
				temp=heapArray.get(i);
				heapArray.set(i,heapArray.get(left(i)));
				heapArray.set(left(i),temp);
			}
		}
		else
			return;
	}//End sortKnot
	private boolean is_max_heap(List<Aufgabe> heapArray){
		/**
		 * Diese Funktion überprüft ob ein Engabearray heapArray einer Heap-Struktur entpsricht
		 * ========================================================================================
		 * Eingabe: Array von Aufgaben (priorität, eingangsnr., Message)
		 * 			Das erste Element des Arrays also heapArray[0] ist leer
		 * -----------------------------------------------------------------------------------------
		 * Ausgabe: True oder False, je nach dem ob es sich um einen Heap handelt oder nicht
		 * -----------------------------------------------------------------------------------------
		 * Angenommen man hat eine Heap Struktur wie folgt:
    	 *...............1
    	 *............2.....3
    	 *.........4....5.6....7
         *
    	 *dann ist der Heap wie folgt in einem Array abgelegt:
         *[leer,1,2,3,4,5,6,7]
		 **/
		if (queuelength!=heapArray.size()-1 || eingangsCounter!=findCounter(heapArray))
			return false;
		if (empty(heapArray)==true)
			return true;
		
		for(int i=0;i<(queuelength/2+1);i++){
			if(testKnot(i+1, heapArray)==false)
				return false;
		}//endfor
		return true;
	}//end is_max_heap
	
	public void insert(Aufgabe NewAufgabe){ //Vertraut darauf dass der Eingangscounter richtig gesetzt ist, a
		/**Fügt die neue Aufgabe NewAufgabe in die Warteschlange ein**/
		queue.add(NewAufgabe);
		queuelength++;
		eingangsCounter++;
		int i=queuelength;
		while(i>=2){
			sortKnot(parent(i),queue);
			i=parent(i);
		}//endwhile
	}//end insert
	
	public boolean empty(List<Aufgabe> heapArray){
		if (heapArray.size()<=1)
			return true;
		else
			return false;
	}
	
	public void remove_message(){
		/**
		 * Die Nachricht mit der höchsten Priorität (und innerhalb der gleichen Priorität, die
		 * Nachricht, die zeitlich zuerst produziert worden ist), wird aus der Prioritätswarteschalnge
		 * entfernt.
		 */
		if (empty(queue))
			return;
		show_element(1);
		queue.remove(1);
		queuelength--;
		for(int i=0;i<queuelength/2+1;i++){
			if(testKnot(i+1, queue)==false)
				sortKnot(i+1, queue);
		assert is_max_heap(queue);
		}//endfor
	}//end remove_message
	
	private int findCounter(List<Aufgabe> heapArray){
		/**Find the last TimeCounter**/
		int max=0;
		for(int i=0;i<heapArray.size();i++){
			if(heapArray.get(i).eingangsNr>max)
				max=heapArray.get(i).eingangsNr;
		}
		return max;
	}//end findCounter
	
	public void generate_messages(int number){
	    /**Inserts number random Messages with random priorities **/
		Random randint=new Random();
		int messagelength=10;
		int maxprio=10;
		final String Alphabet="0123456789abcdefghijklmnopqrstuvwxyz";
		
		for(int j=0;j<number;j++){
			StringBuilder message=new StringBuilder(messagelength);
			for(int i=0;i<messagelength;i++){
				message.append(Alphabet.charAt(randint.nextInt(35)));
			}
			insert(new Aufgabe(randint.nextInt(maxprio),eingangsCounter,message.toString()));
		}//end for (über number of Nachrichten)
	}//end generate messages
	
	public void show_queue(){
		for(int i=1;i<queue.size();i++){
			show_element(i);
		}
	}
	public void show_element(int i){
		/**Zeigt das i-te Element des Heaps an, wobei das erste Element bei i=1 ist**/
		if(i<queue.size() && i>0){
			System.out.print(queue.get(i).priority+" ");
			System.out.print(queue.get(i).eingangsNr+" ");
			System.out.print(queue.get(i).description);
			System.out.println();
		}
	}
	
}//End Class PriorityQueue
