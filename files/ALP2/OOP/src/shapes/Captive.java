package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Captive implements Animation, Shape {
	static final int maxv=5;
	Polygon p;
	Point center;
	double radius; 
	ShapesWorld welt;
	Color color=Color.RED;
	int xrichtung,yrichtung;
	Random rand;
	Captive(){
		rand = new Random();
		xrichtung=rand.nextInt(2*maxv)-maxv;
		yrichtung=rand.nextInt(2*maxv)-maxv;
		radius=30;
		center=new Point(0,0);
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int[] xkoord=new int[7]; //Pfeil erstellen
		int[] ykoord=new int[7];
		
		xkoord[0]=xkoord[6]=-2*(int)radius;
		xkoord[1]=xkoord[5]=xkoord[2]=xkoord[4]=0;
		xkoord[3]=(int)radius;
		
		ykoord[0]=ykoord[1]=(int)(0.25*radius);
		ykoord[2]=(int)(0.8*radius);
		ykoord[3]=0;
		ykoord[4]=-ykoord[2];
		ykoord[5]=ykoord[6]=-ykoord[0];
		
		for(int i=0;i<7;i++){
			xkoord[i]+=center.x;
			ykoord[i]+=center.y;
		}
		
		p=new Polygon(xkoord, ykoord, 7);
		g.fillPolygon(p);
		

	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return p.contains(x,y);
	}

	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
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
		// Lässt den Pfeil innerhalb des Screens und bewegt ihn
		if(center.x>welt.getMax_X())
			xrichtung=-1*rand.nextInt(maxv);
		else if(center.x<welt.getMin_X())
			xrichtung=1*rand.nextInt(maxv);
		if(center.y>welt.getMax_Y())
			yrichtung=-1*rand.nextInt(maxv);
		else if(center.y<welt.getMin_Y())
			yrichtung=1*rand.nextInt(maxv);
		center.x+=xrichtung;
		center.y+=yrichtung;

	}

}
