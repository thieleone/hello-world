package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Scared implements Animation, Shape {
	static final int maxv=5;
	Polygon p;
	Point center;
	double radius; 
	ShapesWorld welt;
	Color color=Color.PINK;
	int xrichtung,yrichtung;
	Random rand;
	Scared(){
		rand = new Random();
		xrichtung=rand.nextInt(2*maxv)-maxv;
		yrichtung=rand.nextInt(2*maxv)-maxv;
		radius=50;
		center=new Point(0,0);
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillOval((int)center.x, (int)center.y, (int)radius, (int)radius);
	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		int xprime=(int)Math.abs(center.x-x);
		int yprime=(int)Math.abs(center.y-y);
		if(Math.sqrt(xprime*xprime+yprime*yprime)<radius)
			return true;
		else
			return false;
	}

	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public Point getCenter() {
		// TODO Auto-generated method stub
		return center;
	}

	@Override
	public void setShapesWorld(ShapesWorld theWorld) {
		// TODO Auto-generated method stub
		welt=theWorld;
	}

	@Override
	public void userClicked(double at_X, double at_Y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userTyped(char key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveTo(double x, double y) {
		// TODO Auto-generated method stub
		center.x=x;
		center.y=y;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		if(center.x>welt.getMax_X())
			xrichtung=-1*rand.nextInt(maxv);
		else if(center.x<welt.getMin_X())
			xrichtung=1*rand.nextInt(maxv);
		if(center.y>welt.getMax_Y())
			yrichtung=-1*rand.nextInt(maxv);
		else if(center.y<welt.getMin_Y())
			yrichtung=1*rand.nextInt(maxv);
		if(welt.getClosestShape(this)!=null){
			double xprime=Math.abs(welt.getClosestShape(this).getCenter().x-center.x);
			double yprime=Math.abs(welt.getClosestShape(this).getCenter().y-center.y);
			double abstand=Math.sqrt(xprime*xprime+yprime*yprime);
			if(abstand<4*radius){ //Wenn ein Element in der NÄhe ist
				if(abstand-welt.getClosestShape(this).getRadius()-radius<0){
					center.x=rand.nextInt((int)(welt.getMax_X()-welt.getMin_X())-(int)(0.5*(welt.getMax_X()-welt.getMin_X())));
					center.y=rand.nextInt((int)(welt.getMax_Y()-welt.getMin_Y())-(int)(0.5*(welt.getMax_Y()-welt.getMin_Y())));
					
					xprime=Math.abs(welt.getClosestShape(this).getCenter().x-center.x);
					yprime=Math.abs(welt.getClosestShape(this).getCenter().y-center.y);
					abstand=Math.sqrt(xprime*xprime+yprime*yprime);
					
					if(abstand-welt.getClosestShape(this).getRadius()-radius<0){ //Wenn nach Teleport immer noch Element im Weg ist
						Stern Star=new Stern(20,this.center);
						welt.addShape(Star);
						welt.removeShape(this);
					}
				}
				center.x+=rand.nextInt(maxv)-(int)maxv/2;
				center.y+=rand.nextInt(maxv)-(int)maxv/2;
			}
		}
		center.x+=xrichtung;
		center.y+=yrichtung;

	}

}
