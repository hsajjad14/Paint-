package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * 
 * The command to draw the polyline.
 * 
 * @author Group
 *
 */
public class PolylineCommand implements DrawingCommand {

	private Polyline polyline;
	private Shape s;

	public PolylineCommand(Shape s, Polyline poly, PaintPanel p)
	{
		this.polyline = poly;
		this.s = s;
	}

	@Override
	public void excecute(GraphicsContext g) {
		if( this.polyline.isdone() == true) {
			Color temp_c = Color.web(this.polyline.getColour()); // gets colour of the point
			g.setStroke(temp_c); // sets colour of the 
				g.setLineWidth(this.polyline.getLineThickness());
				g.strokeLine(this.polyline.getstartX(), this.polyline.getstartY(),this.polyline.getendX(), this.polyline.getendY());
			
	}}}



