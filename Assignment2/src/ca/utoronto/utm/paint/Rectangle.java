package ca.utoronto.utm.paint;

public class Rectangle extends Shape{

	private int length;
	private int width;
	private Point location;
	private boolean done = false;


	public Rectangle(Point corner, int length, int width, String colour, boolean fill, double LineThickness) {
		super(colour, fill, LineThickness);
		this.location = corner;
		this.length = length;
		this.width = width;
	}


	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void increaseWidth(int width) {
		this.width = this.width + width;

	}

	public void increaseLength(int length) {
		this.length = this.length + length;

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
