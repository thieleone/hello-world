package uebung05;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wasser {

	private static int wcounter = 0;
	private static int scounter = 0;

    private static class Wasserstoff implements Runnable{
    	private static CyclicBarrier barrier;

        public Wasserstoff(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wartet an der Barriere.");
                while(wcounter>1){
                	Thread.sleep(100);
                }
                wcounter+=1;
                barrier.await();
                wcounter-=1;
            } catch (InterruptedException ex) {
                Logger.getLogger(Wasser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Wasser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private static class Sauerstoff implements Runnable{
    	private static CyclicBarrier barrier;

        public Sauerstoff(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wartet an der Barriere.");
                while(scounter>0){
                	Thread.sleep(100);
                }
                scounter+=1;
                barrier.await();
                scounter-=1;
            } catch (InterruptedException ex) {
                Logger.getLogger(Wasser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Wasser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable(){
            public void run(){
                // wcounter-=2;
                // scounter-=1;
                System.out.println("Es konnte ein Wassermolekuel gebildet werden.");
            }
        });
        Thread t1 = new Thread(new Wasserstoff(cb), "Wasserstoff 1");
        Thread t2 = new Thread(new Sauerstoff(cb), "Sauerstoff 1");
        Thread t3 = new Thread(new Sauerstoff(cb), "Sauerstoff 2");
        Thread t4 = new Thread(new Wasserstoff(cb), "Wasserstoff 2");
        Thread t5 = new Thread(new Wasserstoff(cb), "Wasserstoff 3");
        Thread t6 = new Thread(new Wasserstoff(cb), "Wasserstoff 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
      
    }
}