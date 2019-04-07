package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * 
 * Draws the circle, the circle command to draw the circle 
 * 
 * @author Haider
 *
 */
public class CircleCommand implements DrawingCommand {
	Shape s;
	public CircleCommand(Shape s) {
		this.s = s;
	}

	@Override
	public void excecute(GraphicsContext g) {
		Circle c = (Circle) this.s;
		int x = (int) (c.getLocation().getX() - c.getRadius() / 2);
		int y = (int) (c.getLocation().getY() - c.getRadius() / 2);

		int radius = c.getRadius();

		Color temp_c = Color.web(c.getColour()); // gets the colour of the circle

		if (c.isFill()) { // fill option
			g.setFill(temp_c); // sets the colour of the circle
			g.fillOval(x, y, radius, radius);
		} else {
			g.setLineWidth(c.getLineThickness());
			g.setStroke(temp_c); // sets the colour of the circle
			g.strokeOval(x, y, radius, radius);
		}
	}

}
