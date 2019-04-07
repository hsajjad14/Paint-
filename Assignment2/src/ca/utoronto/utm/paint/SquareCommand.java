package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SquareCommand implements DrawingCommand {
	private int temp_x;
	private int temp_y;
	private Square square;
	private Shape s;

	public SquareCommand( Shape s, Square square, int temp_x, int temp_y, PaintPanel p) {
		this.square = square;
		this.temp_x = p.d.temp_x;
		this.temp_y = p.d.temp_y;
		this.s = s;
	}

	@Override
	public void excecute(GraphicsContext g) {
		Square q = (Square) this.s;
		int x;
		int y;
		System.out.println("execute sq");
		System.out.println(this.temp_x);

		if (this.temp_x == 0) {
			this.temp_x = 600;

		}
		if (this.temp_y == 0) {
			this.temp_y = 600;

		}
		System.out.println(q.getDone());
		if (q.getDone() == false) { // checks if the current rectangle is the one being drawn or already on the
									// canvas
			x = Math.min(this.temp_x, q.getLocation().getX());
			y = Math.min(this.temp_y, q.getLocation().getY());
		} else {
			
			x = q.getLocation().getX();
			y = q.getLocation().getY();
		}

		int width = q.getWidth();
		Color temp_q;
		if (q.getColour() == null) {
			temp_q = Color.WHITE;
		} else {
			temp_q = Color.web(q.getColour()); // gets the colour of the rectangle
		}
		g.setStroke(temp_q); // sets the colour of the rectangle

		if (q.isFill()) { // fill option
			g.setFill(temp_q); // sets the colour of the circle
			g.fillRect(x, y, width, width);
		} else {
			g.setLineWidth(q.getLineThickness());
			g.setStroke(temp_q); // sets the colour of the circle
			g.strokeRect(x, y, width, width);

		}
	}

}
