package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class MiniBubble extends Bubble{
	int xmove;
	int ymove;
	MiniBubble(double x, double y, int xmo, int ymo){
		this.radius=10;
		center=new Point(x,y);
		xmove=xmo;
		ymove=ymo;
	}
	public void play() {
		//
		if(center.x>world.getMax_X())
			world.removeShape(this);
		else if(center.x<world.getMin_X())
			world.removeShape(this);
		if(center.y>world.getMax_Y())
			world.removeShape(this);
		else if(center.y<world.getMin_Y())
			world.removeShape(this);
		else
		center.x+=xmove;
		center.y+=ymove;
	}
}