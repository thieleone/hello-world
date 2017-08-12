package shapes;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class KidnapperBubble extends Bubble{
	ArrayList<Shape> Liste;
	KidnapperBubble(){
		ShapesList Liste=new ShapesList();
	}
	public void play() {
		if (world.getClosestShape(this)!=null){
			if(Liste.contains(world.getClosestShape(this))){
			}
			else{
			Liste.add(world.getClosestShape(this));
			}
		}
			
		for(Shape captured:Liste){
			if(contains(captured.getCenter().x,captured.getCenter().y)){
				
			}
			else{
				captured.moveTo(center.x, center.y);
			}
		}
	}
}