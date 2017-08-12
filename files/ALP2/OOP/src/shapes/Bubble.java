package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Bubble implements Animation, Shape {
	Point center;
	double radius; 
	ShapesWorld world;
	Color color=Color.GREEN;
	Bubble(){
		this.radius=40;
		center=new Point(0,0);
	}

	public void draw(Graphics g) {
		g.drawOval((int) (center.x - radius), (int) (center.y - radius), (int) (radius*2), (int) (radius*2));
	}

	public boolean contains(double x, double y) {
		if ((x - center.x)*(x - center.x) + (y - center.y)*(y - center.y) < radius*radius)
		    return true;
		else
			return false;
	}

	public double getRadius() {
		//
		return radius;
	}

	public Color getColor() {
		//
		return color;
	}

	public Point getCenter() {
		//
		return center;
	}

	public void setShapesWorld(ShapesWorld theWorld) {
		//
		this.world=theWorld;
	}

	public void userClicked(double at_X, double at_Y) {
		//
		if(contains(at_X, at_Y)){
			MiniBubble Min1 = new MiniBubble(at_X,at_Y,1,0);
			world.addShape(Min1);
			MiniBubble Min2 = new MiniBubble(at_X,at_Y,-1,0);
			world.addShape(Min2);
			MiniBubble Min3 = new MiniBubble(at_X,at_Y,0,1);
			world.addShape(Min3);
			MiniBubble Min4 = new MiniBubble(at_X,at_Y,0,-1);
			world.addShape(Min4);
			MiniBubble Min5 = new MiniBubble(at_X,at_Y,1,1);
			world.addShape(Min5);
			MiniBubble Min6 = new MiniBubble(at_X,at_Y,-1,1);
			world.addShape(Min6);
			MiniBubble Min7 = new MiniBubble(at_X,at_Y,-1,-1);
			world.addShape(Min7);
			MiniBubble Min8 = new MiniBubble(at_X,at_Y,1,-1);
			world.addShape(Min8);
			world.removeShape(this);
		}
	}

	public void userTyped(char key) {
		//

	}

	public void moveTo(double x, double y) {
		//
		center.x=x;
		center.y=y;

	}

	public void play() {
		//

	}

}
