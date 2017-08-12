package u7;

import java.awt.Color;

public class Orangensaft extends Liquid {
	int temperatur;
	public Orangensaft(int temperatur){
		super("Orangensaft", Color.YELLOW,true);
		this.temperatur=temperatur;
	}
	public Orangensaft(){
		super("Orangensaft", Color.YELLOW,true);
		this.temperatur=super.temperature;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.name;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return super.color;
	}

	@Override
	public boolean isDrinkable() {
		// TODO Auto-generated method stub
		return super.drinkable;
	}

	@Override
	public void hitUp(int temperature) {
		// TODO Auto-generated method stub
		this.temperatur=temperature;
	}

	@Override
	public int getTemperature() {
		// TODO Auto-generated method stub
		return temperatur;
	}

}
