package u5;

public class Aufgabe{
/**
 * Datentyp f�r Priority Queue
 */
	public int eingangsNr;
	public int priority;
	public String description;
	
	
	Aufgabe(int priority, int eingangsNr, String description){
		this.eingangsNr=eingangsNr;
		this.priority=priority;
		this.description=description;
	}
	public Aufgabe copy(){
		/**Gibt eine Kopie von sich zur�ck**/
		return new Aufgabe(priority,eingangsNr,description);
	}
	
}
