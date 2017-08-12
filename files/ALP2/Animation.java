package shapes;

/**
 * @author M. Esponda-Argüero
 * @version 1.0
 */

public interface Animation {
	
	public static int sleep_time = 30;
	
	/** The play-Method will be called every 30 milliseconds */
    public void play();
}
