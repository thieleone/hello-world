package uebung5;

import uebung4.Nap;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Wasser {
	//private static Object lock = new Object();
	private static ReentrantLock hLock = new ReentrantLock(true);
	private static Condition hCond = hLock.newCondition();
	private static ReentrantLock oLock = new ReentrantLock(true);
	private static Condition oCond = oLock.newCondition();
	private static ReentrantLock h2oLock = new ReentrantLock(true);
	private static Condition h2oCond = h2oLock.newCondition();
	private static int hCounter = 0;
	private static int oCounter = 0;
	private static int h20Count = 0;

    private static class Wasserstoff extends Thread{
        public Wasserstoff() {}
        
        public void run() {
        	Nap.randomNap(500,1000);
        	hLock.lock();
        	oLock.lock();
        	hCounter++;
            System.out.println("H-Atom erreicht Membran. Status: H:" + hCounter + ", O:" + oCounter);
        	if(hCounter < 2 || oCounter <1){
        		try{
        			oLock.unlock();
        			hCond.await();
        		}
        		catch(InterruptedException e){}
        	}
        	else{
    			oCounter--;
    			hCounter-=2; 
    			System.out.println("H2O-Molekuel gebildet.");
        		hCond.signal();
        		oCond.signal();
        		oLock.unlock();
        	}
        	//This part is only to check that the atoms leave the membrane in a synchronized fashion.
        	System.out.println("H-Atom verlaesst Membran.");
        	hLock.unlock();
        }
        
    }
    private static class Sauerstoff extends Thread{
        public Sauerstoff() {}
        
        public void run() {
        	Nap.randomNap(500,1000);
        	hLock.lock();
            oLock.lock();
            oCounter++;
            System.out.println("O-Atom erreicht Membran. Status: H:" + hCounter + ", O:" + oCounter);
        	if(hCounter < 2 || oCounter <1){
        		try{
        			hLock.unlock();
        			oCond.await();
        		}
        		catch(InterruptedException e){}
        	}
        	else{
    			oCounter--;
    			hCounter-=2;
    			System.out.println("H2O-Molekuel gebildet.");
        		hCond.signal();
        		hCond.signal();
        		hLock.unlock();
        	}
        	//This part is only to check that the atoms leave the membrane in a synchronized fashion.
            System.out.println("O-Atom verlaesst Membran.");
        	oLock.unlock();
        }
    }

    public static void main(String args[]) {
    	Random rnd = new Random();
    	while(true){
    		Nap.randomNap(500,1000);
    		int nextAtom = rnd.nextInt(3);
    		if(nextAtom == 0){
    			Sauerstoff o = new Sauerstoff();
    			o.start();
    		}
    		else{
    			Wasserstoff h = new Wasserstoff();
    			h.start();
    		}
    	}
    }
}