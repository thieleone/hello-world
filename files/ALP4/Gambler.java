package uebung1;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Gambler extends Thread {
	public static Object lock = new Object();
	public static int result;
	public static List<Integer> bets;
	public static List<Boolean> active;
	
	public int money = 5; //Initially available money
	public Thread gambler;
	public String name;
	public int number;
	
	public Gambler(String name, int number){
		gambler = new Thread();
		this.name = name; 
		this.number = number;
	}
	
	public void run(){
		Random rnd = new Random();
		while(money > 0 && money < 10){
			Nap.randomNap(80,100);
			int bet = rnd.nextInt(4);
			System.out.println(name+"("+money+"$) places bet on "+bet+".");
			synchronized(lock){
				//Falls alle anderen Threads schon ihre Bets abgegeben haben, release den Lock.
				int sum = 0;
				synchronized(Gambler.bets){
					Gambler.bets.set(this.number,1);
					for(int i = 0; i < Gambler.bets.size(); i++)
						sum += Gambler.bets.get(i);
				}
				if(sum == Gambler.bets.size()){
					result = rnd.nextInt(4);
					System.out.println("The result is "+result);
					for(int i=0; i<2; i++){
						if(Gambler.active.get(i)) Gambler.bets.set(i,0);
					}
					lock.notifyAll();
				}
				else{
					try{
						lock.wait();
					}
					catch(InterruptedException e){}
				}
			}
			if(bet == result){
				money++;
			}
			else{
				money--;
			}
		}
		Gambler.active.set(this.number,false);
		Gambler.bets.set(this.number,1);
	}
	
	public static void main(String[] args) {
		int gamblerNum = 3;
		List<Gambler> gamblers = new ArrayList<Gambler>();
		Gambler.bets = new ArrayList<Integer>();
		Gambler.active = new ArrayList<Boolean>();
		for(int i=0; i<gamblerNum; i++){
			gamblers.add(new Gambler("Gambler"+i,i));
			Gambler.bets.add(0); 
			Gambler.active.add(true);
		}
		for(int i=0; i<gamblerNum; i++){
			gamblers.get(i).start();
		}
	}
}
