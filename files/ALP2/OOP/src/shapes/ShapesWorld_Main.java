package shapes;

/**
 * @author M. Esponda
 * @version 1.01
 */

public class ShapesWorld_Main {
	/**
	 * @param args 
	 * has the name of the shape classes, we want to use in the ShapesWorld-object.
	 */
	public static void main(String[] args) 
	{
		if (args.length==0) {
			System.err.println("Bitte Shape-Klassennamen als Argumente eingeben");
		}
		new ShapeFrame(args);
	}
} // end of class ShapesWorld_Main
