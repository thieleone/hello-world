package u7;

public class NotEnoughLiquidException extends Exception {

	private static final long serialVersionUID = 1L;
	int capacity, content, ml;
	public NotEnoughLiquidException(int capacity, int content, int ml) {
		// TODO Auto-generated constructor stub
		super("Es kann nicht mehr Flüssigkeit aus der Tasse herausgenommen werden als sich darin befindet");
		this.capacity=capacity;
		this.content=content;
		this.ml=ml;
	}
}
