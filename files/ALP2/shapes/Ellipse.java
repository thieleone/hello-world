package shapes;

import java.awt.Color;
import java.awt.Graphics;

/* Vorlesungsbeispiel */

public class Ellipse implements Shape, Animation{

	double radius;
	Point center;
	Color color = Color.MAGENTA;
	ShapesWorld world;
	
	public Ellipse(){
		this.radius = 20;
		center = new Point(0,10);
	}
	
	public void draw(Graphics g) {
		g.drawOval((int) center.x, (int) center.y, (int) radius/2, (int) (radius) );
	}

	public boolean contains(double x, double y) {
		return false;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

	public Point getCenter() {
		return center;
	}

	public void setShapesWorld(ShapesWorld theWorld) {
         this.world=theWorld;
	}

	public void userClicked(double at_X, double at_Y) {        
	}

	public void userTyped(char key) {
	}

	public void moveTo(double x, double y) {
	}

	public void play() {
         radius = radius + 1.0;
         center.x = center.x +1;
         if ((1.4*radius)>world.getMax_X())
        	 world.removeShape(this);
	}
}


