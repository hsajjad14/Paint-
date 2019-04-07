package ca.utoronto.utm.paint;

public class Shape {
	
	private String colour; // colour of the circle
	private boolean fill = false; // fill option
	private double LineThickness;
	
	public Shape(String colour, boolean fill, double LineThickness) {
		this.colour = colour;
		this.fill = fill;
		this.LineThickness = LineThickness;

	}

	public String getColour() {
		return colour;
	}


	public boolean isFill() {
		return fill;
	}

	public double getLineThickness() {
		return LineThickness;
	}



	
}
