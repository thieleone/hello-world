package uebung1;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Gambler extends Thread {
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
			Nap.randomNap(500,1000);
			int bet = rnd.nextInt(4);
			int result = rnd.nextInt(4);
			if(bet == result){
				System.out.println(name+"("+money+"$) places bet on "+bet+" and wins! Result is " + result + ".");
				money++;
			}
			else{
				System.out.println(name+"("+money+"$) places bet on "+bet+" and loses! Result is " + result + ".");
				money--;
			}
		}
	}
	
	public static void main(String[] args) {
		int gamblerNum = 3;
		List<Gambler> gamblers = new ArrayList<Gambler>();
		for(int i=0; i<gamblerNum; i++){
			gamblers.add(new Gambler("Gambler"+i,i));
		}
		for(int i=0; i<gamblerNum; i++){
			gamblers.get(i).start();
		}
	}
}
