package ca.utoronto.utm.paint;
import java.lang.Math;

public class Point extends Shape{
	int x, y;
	
	private String colour; // colour of the point
	
	Point(int x, int y, String colour, double LineThickness) {
		super(colour, false, LineThickness);
		this.x = x;
		this.y = y;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double distance(Point other) {
		int x1 = this.x - other.getX();
		int x2 = this.y - other.getY();
		double d = Math.sqrt(x1*x1 + x2*x2);
		return d;
	}



}
