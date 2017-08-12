package proinf.geo;

public class Shape {
	private Point middle;
	private double area;

	public Shape(Point middle) {
		super();
		this.middle = middle;
	}
	protected void setMiddle(Point middle)
	{
		this.middle = middle;
	}
	public Point getMiddle(){return middle;}
	protected void setArea(double area){this.area=area;}
	public double getArea(){return this.area;}

}
