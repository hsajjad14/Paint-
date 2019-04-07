package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * Point command which draws points
 * 
 * @author Group
 *
 */
public class PointCommand implements DrawingCommand {
	private  ArrayList<Shape>  sh;
	public PointCommand( ArrayList<Shape>  sh) {
		this.sh = sh;
	}

	public void excecute(GraphicsContext g) {
		ArrayList<Shape> s = this.sh;
		for (int i = 0; i < s.size() - 1; i++) {
			if (s.get(i).getClass() == Point.class && s.get(i + 1).getClass() == Point.class) {
				Point p1 = (Point) s.get(i);
				Point p2 = (Point) s.get(i + 1);

				Color temp_c = Color.web(p1.getColour()); // gets colour of the point
				g.setStroke(temp_c); // sets colour of the stroak
				g.setLineWidth(p1.getLineThickness());
				g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}

		}
	}

}
