package u7;

public class NotEnoughCapacityException extends Exception {
	
	private static final long serialVersionUID = 1L;
	int capacity, ml;
	public NotEnoughCapacityException(int capacity, int ml) {
		// TODO Auto-generated constructor stub
		super("Kapazität der Tasse nicht groß genug, um gewünschten Inhalt hineinzufüllen");
		this.capacity=capacity;
		this.ml=ml;
	}
}
