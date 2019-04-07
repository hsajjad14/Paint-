package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * PaintModel holds arraylist of objects: shape, squiggle, polyline
 * ***rest are unused***
 * 
 * @author Group
 *
 */
public class PaintModel extends Observable {

	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Square> squares = new ArrayList<Square>();
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

	private ArrayList<Squiggle> squiggle = new ArrayList<Squiggle>();
	private ArrayList<Eraser> eraser = new ArrayList<Eraser>();

	private ArrayList<Polyline> polyline = new ArrayList<Polyline>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public void addPoint(Point p) {
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void addCircle(Circle c) {
		this.circles.add(c);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Circle> getCircles() {
		return circles;
	}

	public void addRectangle(Rectangle r) {
		this.rectangles.add(r);
		this.setChanged();
		this.notifyObservers();
	}

	public void addSquare(Square q) {
		this.squares.add(q);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Rectangle> getRectangles() {
		return rectangles;
	}

	public ArrayList<Square> getSquares() {
		return squares;
	}

	public void addShape(Shape s) {
		this.shapes.add(s);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public Shape getLastShape() {
		return this.shapes.get(this.shapes.size()-1);
	}
	
	public Polyline getLastPolyline() {
		return this.polyline.get(this.polyline.size()-1);
		
	}
	

	public void addSquiggle(Squiggle squiggle) {
		// TODO Auto-generated method stub
		this.squiggle.add(squiggle);
		this.setChanged();
		this.notifyObservers();

	}

	public void resetPoints() {
		this.points = new ArrayList<Point>();
		// TODO Auto-generated method stub
	}

	public void removeAllPoints() {
		ArrayList<Shape> newShape = new ArrayList<Shape>();

		for (int i = 0; i < this.shapes.size(); i++) {
			if (this.shapes.get(i).getClass() != Point.class) {
				newShape.add(this.shapes.get(i));
			}

		}
		this.shapes = newShape;

	}

	public void DrawingCommand(GraphicsContext g, PaintPanel p) {
		new ConcreteDrawingCommand(this, p.getHeight(), p.gettemp_x(), p.gettemp_y(), p.getWidth(), p, p.getMode()).excecute(g);
	}

	public void addPolyline(Polyline polyline) {
		this.polyline.add(polyline);
		this.setChanged();
		this.notifyObservers();
	
		
		// TODO Auto-generated method stub
		
	}

	public void addEraser(Eraser eraser) {
		this.eraser.add(eraser);
		this.setChanged();
		this.notifyObservers();

		// TODO Auto-generated method stub
		
	}

	public void setEraserColour(String colour) {
		for(Eraser x : this.eraser) {
			x.setColour(colour);
		}
		// TODO Auto-generated method stub
		
	}
}
