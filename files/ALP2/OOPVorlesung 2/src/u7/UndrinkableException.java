package u7;

public class UndrinkableException extends Exception {

	private static final long serialVersionUID = 1L;
	String name;
	public UndrinkableException(String name) {
		// TODO Auto-generated constructor stub
		super("Die Flüssigkeit ist nicht drinkbar!");
		this.name=name;
	}

}
