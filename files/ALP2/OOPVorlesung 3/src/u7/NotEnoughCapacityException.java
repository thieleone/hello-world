package u7;

public class NotEnoughCapacityException extends Exception {
	
	private static final long serialVersionUID = 1L;
	int capacity, ml;
	public NotEnoughCapacityException(int capacity, int ml) {
		// TODO Auto-generated constructor stub
		super("Kapazit�t der Tasse nicht gro� genug, um gew�nschten Inhalt hineinzuf�llen");
		this.capacity=capacity;
		this.ml=ml;
	}
}
