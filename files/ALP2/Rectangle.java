public class Rectangle {
// Attribute
	int x;
	int y;
	int width;
	int height;

// Konstruktoren
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
		this (0, 0, 10, 10);
	}

// Methoden
	public int perimeter() {
		return 2 * (width + height);
	}

	public int area() {
		return (width * height);
	}

	public Rectangle clone() {
		return new Rectangle(x, y, width, height);
	}

	public boolean identical(Rectangle r) {
		return r.x == x && r.y == y && r.width == width && r.height == height;
	}

	public int compareTo(Rectangle r) {
		//width*height, r.width*r.height
		if (width * height < r.width * r.height) {
			return -1;
		} else if (width * height == r.width * r.height) {
			return 0;
		} else {
			return 1;
		}
	}

	public boolean contains(Rectangle r) {
		//r.x>=x, r.x+r.width<=x+width...
		if (r != null) {
			return r.x >= x && (r.x + r.width) <= (x + width) && r.x >= y && (r.y + r.height) <= (y + height);
		}
		return false;
	}

	public boolean overlaps(Rectangle r) {
		if (r != null) {
			if (r.x >= x && r.x < (x + width) || (r.x + r.width) > x && (r.x + r.width) <= (x + width)) {
				return r.y >= y && r.y < (y + height) || (r.y + r.height) > y && (r.y + r.height) <= (y + height);
			} else if (x >= r.x && x < (r.x + r.width) || (x + width) > r.x && (x + width) <= (r.x + r.width)) {
				return y >= r.y && y < (r.y + r.height) || (y + height) > r.y && (y + height) <= (r.y + r.height);
			}
		}
		return false;
	}

	public boolean contains(int x, int y) {
		return definedAtX(x) && definedAtY(y);
	}

	private boolean definedAtX(int x) {
		return this.x <= x && x <= this.x + height;
	}

	private boolean definedAtY(int y) {
		return this.y <= y && y <= this.y + height;
	}

	public Rectangle selection(Rectangle r) {
		if(r==null){
			return null;
		} else if (contains(r)) {
			return r.clone();
		} else if (r.contains(this)) {
			return clone();
		} else if (overlaps(r)) {
			Rectangle rec = new Rectangle();
			
			if (definedAtX(r.x)) {
				rec.x = r.x;
			} else {
				rec.x = x;
			}

			if (definedAtY(r.y)) {
				rec.y = r.y;
			} else {
				rec.y = y;
			}

			if (definedAtX(r.x + r.width)) {
				rec.width = r.x + r.width - rec.x;
			} else {
				rec.width = x + width - rec.x;
			}

			if (definedAtY(r.y + r.height)) {
				rec.height = r.y + r.height - rec.y;
			} else {
				rec.height = y + height - rec.y;
			}

			return rec;
		}
		return null;
	}

	public static Rectangle smallestBoundingRectangle(Rectangle[] recs) {
		if (recs != null && recs.length != 0) {
			Rectangle rec = new Rectangle();
			rec.x = recs[0].x;
			rec.y = recs[0].y;
			rec.width = recs[0].width;
			rec.height = recs[0].height;

			for (Rectangle recLoop : recs) {
				if (recLoop.x < rec.x) {
					rec.height += rec.x - recLoop.x;
					rec.x = recLoop.x;
				}
				if (recLoop.x + recLoop.width > rec.x + rec.width) {
					rec.width = recLoop.x + recLoop.width - rec.x;
				}
				if (recLoop.y < rec.y) {
					rec.width += rec.y - recLoop.y;
					rec.y = recLoop.y;
				}
				if (recLoop.y + recLoop.height > rec.y + rec.height) {
					rec.height = recLoop.y + recLoop.height - rec.y;
				}
			}
			return rec;
		} else return null;
	}
}