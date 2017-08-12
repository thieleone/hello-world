package uebung1;
import java.util.Random;

public class Nap{
	public static void nap(int milliSekunden){
		try{
			Thread.sleep(milliSekunden);
		}
		catch(InterruptedException e){}
	}
	
	public static void randomNap(int minMillisekunden, int maxMillisekunden){
		Random rnd = new Random();
		int sekundenFenster = maxMillisekunden - minMillisekunden;
		nap(minMillisekunden + rnd.nextInt(sekundenFenster));
	}
}