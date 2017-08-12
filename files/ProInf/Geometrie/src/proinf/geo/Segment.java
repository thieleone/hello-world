package proinf.geo;

public class Segment extends Shape {
	Point start;
	Point end;
	double length;
	public Segment(Point start, Point end) {
		super(null);
		this.start = start;
		this.end = end;
		length = Math.sqrt(Math.pow(Math.abs(start.getX()-end.getX()),2) + Math.pow(Math.abs(start.getY()-end.getY()),2));
		setMiddle(new Point(start.getX()/2+end.getX()/2,start.getY()/2+end.getY()/2));
		this.setArea(0.0);
	}
}
