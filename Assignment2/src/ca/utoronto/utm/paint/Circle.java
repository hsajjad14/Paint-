package ca.utoronto.utm.paint;

/**
 * Creates a Circle object, inherits from Shape
 * 
 * @author Group
 *
 */
public class Circle extends Shape{
	
	private int radius;
	private Point location;

	public Circle(Point centre, int radius, String colour, boolean fill, double LineThickness) {
		super(colour, fill, LineThickness);
		this.location = centre;
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void increaseRadius(int radius) {
		this.radius = this.radius + radius;
				
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}


}
