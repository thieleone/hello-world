package proinf.geo;

public class Squere extends Rectangle {
	double seite;
	Circle innerCircle;

	public Squere(Point p1, double seite) {
		super(p1, new Point(p1.getX()+seite, p1.getY()+seite));
		this.seite = seite;
		innerCircle = new Circle(getMiddle(), getMiddle().calculateDistance(new Point(getMiddle().getX()+seite/2, getMiddle().getY())) );
	}
}
