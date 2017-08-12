package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Stern implements Shape,Animation{
	Polygon p;
	boolean neu;
	Point center;
	double radius; 
	ShapesWorld welt;
	Color color=Color.YELLOW;
	Random rand=new Random();
	Stern(int radius, Point Startpunkt){
		neu=false;
		this.radius=radius;
		center=Startpunkt;
	}
	Stern(int radius){
		this(radius,new Point(0,0));
		neu=true;
	}
	Stern(){
		this(50,new Point(0,0));
		neu=true;
	}
	
	public void draw(Graphics g) {
		if (neu){ //Center setzen
			double x=rand.nextDouble()-0.5;
			double y=rand.nextDouble()-0.5;
			center.x=x*(welt.getMax_X()-welt.getMin_X()-radius);
			center.y=y*(welt.getMax_Y()-welt.getMin_Y()-radius);
			neu=false;
		}
		int[] xkoord=new int[12]; //Stern erstellen
		int[] ykoord=new int[12];
		xkoord[0]=(int)Math.round(-radius/Math.sqrt(3));
		xkoord[1]=xkoord[11]=(int)Math.round((-radius*Math.cos(Math.PI/6)));
		xkoord[2]=xkoord[10]=(int)Math.round(radius/Math.sqrt(3)*Math.cos(Math.PI/3));
		xkoord[3]=xkoord[9]=0;
		xkoord[4]=xkoord[8]=-xkoord[10];
		xkoord[5]=xkoord[7]=-xkoord[11];
		xkoord[6]=-xkoord[0];
		
		ykoord[0]=ykoord[6]=0;
		ykoord[1]=ykoord[5]=-(int)Math.round((radius*Math.sin(Math.PI/6)));
		ykoord[2]=ykoord[4]=-(int)Math.round(radius/Math.sqrt(3)*Math.sin(Math.PI/3));
		ykoord[3]=-(int)radius;
		ykoord[10]=-ykoord[2];
		ykoord[11]=-ykoord[1];
		ykoord[7]=ykoord[11];
		ykoord[8]=ykoord[10];
		ykoord[9]=-ykoord[3];
		for(int i=0;i<12;i++){
			xkoord[i]=xkoord[i]+(int)Math.round(center.x);
			ykoord[i]=ykoord[i]+(int)Math.round(center.y);
		}
		//p=new Polygon(xkoord+center.x*(welt.getMax_X()-welt.getMin_X()-radius)/2,ykoord,12);
		p=new Polygon(xkoord,ykoord,12);
		g.fillPolygon(xkoord, ykoord, xkoord.length);
		//g.drawOval((int) 0, (int) 0, (int) radius/2, (int) (radius) );
	}
	public void moveTo(double x, double y) {
		// TODO Auto-generated method stub
	}
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return p.contains(x, y);
	}
	public void setShapesWorld(ShapesWorld theWorld) {
		// TODO Auto-generated method stub
		welt=theWorld;
	}
	public Point getCenter() {
		// TODO Auto-generated method stub
		return center;
	}
	public Color getColor() {
		return color;
	}
	
	public void play() {
		// TODO Auto-generated method stub
		if(radius<4 || center.y>(welt.getMax_Y())){
			welt.removeShape(this);
		}
		else{
			radius=radius-0.3;
			center.y=center.y+2;
			//center.translate(0, -1);
		}
		
	}
	public double getRadius() {
		return radius;
	}
	public void userClicked(double at_X, double at_Y) {
		// TODO Auto-generated method stub
		System.out.println("x:"+at_X+", y:"+ at_Y);
		
	}
	public void userTyped(char key) {
		// TODO Auto-generated method stub
		
	}
}
