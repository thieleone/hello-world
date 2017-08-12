package proinf.geo;

public class Point extends Shape {

	private double x;
	private double y;

	public Point(double x, double y) {
		super(null);
		this.x = x;
		this.y = y;
		setMiddle(this);
		this.setArea(0.0);
	}
	public double calculateDistance(Point punkt)
	{
		
		return Math.sqrt(Math.pow(Math.abs(this.x-punkt.getX()),2) + Math.pow(Math.abs(this.y-punkt.getY()),2));
	}
	public double getX(){return this.x;}
	public double getY(){return this.y;}

}
