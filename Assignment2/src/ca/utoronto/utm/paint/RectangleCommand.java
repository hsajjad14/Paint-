package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * Rectangle object is drawn
 * 
 * @author Group
 *
 */
public class RectangleCommand implements DrawingCommand {
	private int temp_x;
	private int temp_y;
	private Rectangle rectangle;
	private Shape s;

	public RectangleCommand( Shape s, Rectangle rect, int temp_x, int temp_y, PaintPanel p) {
		this.rectangle = rect;
		this.temp_x = p.d.temp_x;
		this.temp_y = p.d.temp_y;
		this.s = s;
	}

	@Override
	public void excecute(GraphicsContext g) {
		Rectangle r = (Rectangle) this.s;
		int x;
		int y;
		System.out.println("Ayoooooooo");
		System.out.println(this.temp_x);

		if (this.temp_x == 0) {
			this.temp_x = 600;

		}
		if (this.temp_y == 0) {
			this.temp_y = 600;

		}
		System.out.println(r.getDone());
		if (r.getDone() == false) { // checks if the current rectangle is the one being drawn or already on the
									// canvas
			x = Math.min(this.temp_x, r.getLocation().getX());
			y = Math.min(this.temp_y, r.getLocation().getY());
		} else {
			
			System.out.println("????????????????????????????");
			x = r.getLocation().getX();
			y = r.getLocation().getY();
		}


		int length = r.getLength();
		int width = r.getWidth();
		Color temp_r;
		if (r.getColour() == null) {
			temp_r = Color.WHITE;
		} else {
			temp_r = Color.web(r.getColour()); // gets the colour of the rectangle
		}
		g.setStroke(temp_r); // sets the colour of the rectangle

		if (r.isFill()) { // fill option
			g.setFill(temp_r); // sets the colour of the circle
			g.fillRect(x, y, length, width);
		} else {
			g.setLineWidth(r.getLineThickness());
			g.setStroke(temp_r); // sets the colour of the circle
			g.strokeRect(x, y, length, width);

		}
	}

}
