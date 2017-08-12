package proinf.geo;

public class Circle extends Shape {
	double radius;

	public Circle(Point middle, double radius) {
		super(middle);
		this.radius = radius;
		this.setArea(Math.PI * Math.pow(radius, 2));
	}
}
