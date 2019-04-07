package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SquiggleCommand  implements DrawingCommand{

	private Squiggle squiggle;
	private Shape s;

	public SquiggleCommand(Shape s, Squiggle squiggle, PaintPanel p)
	{
		this.squiggle = squiggle;
		this.s = s;
	}

	@Override
	public void excecute(GraphicsContext g) {
 {
		Color temp_c = Color.web(this.squiggle.getColour()); // gets colour of the point
		g.setStroke(temp_c); // sets colour of the 
			g.setLineWidth(this.squiggle.getLineThickness());
			g.strokeLine(this.squiggle.getstartX(), this.squiggle.getstartY(),this.squiggle.getendX(), this.squiggle.getendY());
		
}}}