package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * 
 * Drawing command for eraser
 * 
 * @author Group
 *
 */
public class EraserCommand  implements DrawingCommand{

	private Eraser eraser;
	private Shape s;

	public EraserCommand(Shape s, Eraser eraser, PaintPanel p)
	{
		this.eraser = eraser;
		this.s = s;
	}

	@Override
	public void excecute(GraphicsContext g) {
 {
		Color temp_c = Color.web(this.eraser.getColour()); // gets colour of the point
		g.setStroke(temp_c); // sets colour of the 
			g.setLineWidth(this.eraser.getLineThickness());
			g.strokeLine(this.eraser.getstartX(), this.eraser.getstartY(),this.eraser.getendX(), this.eraser.getendY());
		
}}}
