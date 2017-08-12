package proinf.geo;

public class Rectangle extends Shape {
	// Variables
	private Point pBottomLeft;
	private Point pBottomRight;
	private Point pTopLeft;
	private Point pTopRight;

	// Constructor
	public Rectangle(Point p1, Point p2) {
		super(null);

		if(p1.getY() < p2.getY()){
			if(p1.getX() < p2.getX()){
				pBottomLeft = p1;
				pTopRight = p2;
			}else{
				pBottomRight = p1;
				pTopLeft = p2;
			}
		}else{
			if(p1.getX() < p2.getX()){
				pBottomRight = p2;
				pTopLeft = p1;
			}else{
				pBottomLeft = p2;
				pTopRight = p1;
			}
		}
		double temp = pBottomLeft.calculateDistance(pBottomRight)*pBottomLeft.calculateDistance(pTopLeft);
		if (temp<0){
			temp = temp*(-1);
		}
		setArea(temp);
	}


}
