package u7;

import java.awt.Color;

public class Wasser extends Liquid {

	int temperatur;
	public Wasser(int temperatur){
		super("Wasser",Color.CYAN,true);
		this.temperatur=temperatur;
	}
	public Wasser(){
		super("Wasser", Color.CYAN,true);
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

