package ca.utoronto.utm.paint;

public class Square extends Shape{

	private int side;
	private Point location;
	private boolean done = false;


	public Square(Point corner, int width, String colour, boolean fill, double LineThickness) {
		super(colour, fill, LineThickness);
		this.location = corner;
		this.side = width;
	}


	public int getWidth() {
		return side;
	}

	public void setWidth(int width) {
		this.side = width;
	}


	public void increaseWidth(int width) {
		this.side = this.side + width;

	}
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}

	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}
	
	public boolean getDone() {
		return this.done;
	}

	
}
