package uebung2;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Gambler extends Thread {
	public static Object lock = new Object();
	
	public static List<Gambler> gamblers = new ArrayList<Gambler>();
	public static int counter = 0;
	public static int result;
	public static int casinoMoney = 20;
	
	public int money = 5; //Initially available money
	public int bet;
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
		while(money > 0 && money < 10 && casinoMoney > 0){
			Nap.randomNap(500,1000);
			bet = rnd.nextInt(4);
			System.out.println(name+"("+money+"$): Places bet on "+bet+"");
			synchronized(lock){
				counter++;
				casinoMoney++;
				money--;
				while(counter < gamblers.size()){
						try{
							lock.wait();
						}
						catch(InterruptedException e){}
				}
				counter = 0;
				Gambler.result = rnd.nextInt(4);
				System.out.println("Casino("+casinoMoney+"$): Result is " + result + ".");
				for(int i=0; i<gamblers.size(); i++){
					if(gamblers.get(i).bet == result && casinoMoney > 1){
						casinoMoney -= 2;
						gamblers.get(i).money += 2;
					}
					else if(gamblers.get(i).bet == result && casinoMoney <= 1){
						gamblers.get(i).money += casinoMoney;
						casinoMoney = 0;
						System.out.println("Casino("+casinoMoney+"$): Cannot pay " + name + "!");
						break;
					}
				}
				lock.notifyAll();
				if(money == 0){
					gamblers.remove(this);
					System.out.println(name+"("+money+"$): Leaves the game");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int gamblerNum = 3;
		for(int i=0; i<gamblerNum; i++){
			gamblers.add(new Gambler("Gambler"+i,i));
		}
		System.out.println("Casino("+casinoMoney+"$): The game is on!");
		for(int i=0; i<gamblerNum; i++){
			gamblers.get(i).start();
		}
	}
}
