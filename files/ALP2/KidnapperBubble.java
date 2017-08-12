package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class KidnapperBubble extends Bubble{
	public void play(){
		if(welt.getClosestShape(this)!=null){
			int xcon=welt.getClosestShape(this).getCenter().x;
			int ycon=welt.getClosestShape(this).getCenter().y;
			if(contains(xcon,ycon)){
				

			}
	}
}