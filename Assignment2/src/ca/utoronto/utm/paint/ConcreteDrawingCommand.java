package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * Draws the canvas, calls different commands for each object drawn.
 * 
 * @author Group
 *
 */
public class ConcreteDrawingCommand implements DrawingCommand {
	private Rectangle rectangle;
	private Square square;
	private int temp_x;
	private int temp_y;
	private double Height;
	private double Width;
	private PaintModel model;
	PaintPanel p;
	private Polyline polyline;

	private String modifier;

	private Squiggle squiggle;
	private Eraser eraser;
	public ConcreteDrawingCommand(PaintModel model, double Height, int temp_x, int temp_y, double Width, PaintPanel p,String modifier) {

		this.Width = Width;
		this.Height = Height;
		this.model = model;
		this.temp_x = temp_x;
		this.temp_y = temp_y;
		this.p = p;
		this.modifier = modifier;
	}

	@Override
	public void excecute(GraphicsContext g) {
		// Clear the canvas
		g.clearRect(0, 0, this.Width, this.Height);

		g.setStroke(Color.WHITE); // default
		g.setLineWidth(1);



		// int count = 0;
	
		
		ArrayList<Shape> shapes = this.model.getShapes();
		for (Shape s : shapes) {
			if (s.getClass() == Point.class) {
				
				new PointCommand(shapes).excecute(g);
				

			}
			if (s.getClass() == Polyline.class) {
				this.polyline = (Polyline) s;

				new PolylineCommand(s,this.polyline, this.p).excecute(g);

			}

			if (s.getClass() == Circle.class) {
				new CircleCommand(s).excecute(g);

			}
			if (s.getClass() == Rectangle.class) {
				this.rectangle = (Rectangle) s;
				
				new RectangleCommand(s, this.rectangle, this.temp_x, this.temp_y, this.p).excecute(g);

			}
			if (s.getClass() == Square.class) {
				this.square = (Square) s;
				
				new SquareCommand(s, this.square, this.temp_x, this.temp_y, this.p).excecute(g);

			} else {
				
				new ShapeModifierCommand(this.modifier, this.p).excecute(g);
			}

			if (s.getClass() == Squiggle.class) {
				this.squiggle = (Squiggle) s;
				new SquiggleCommand(s,this.squiggle,this.p).excecute(g);
			}
			if (s.getClass() == Eraser.class) {
				this.eraser = (Eraser) s;
				new EraserCommand(s,this.eraser,this.p).excecute(g);
			}
			
			
			}
		}

	}


