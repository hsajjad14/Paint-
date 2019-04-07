package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;

public class ReleaseCommand implements Command {
	private PaintModel model;
	private Point temp_point;
	private Circle circle;
	private Square square;
	Rectangle rectangle;
	private String mode;
	int temp_x;
	int temp_y;
	private String color;
	private double LineThickness;
	private Squiggle squiggle ; // list of all the squiggles
	private boolean fill;
	private Polyline polyline;
	private double xstart;
	private double ystart;
	private double xend;
	private double yend;
	PaintPanel p;
	CircleStrategy c;

	public ReleaseCommand(PaintPanel p, PaintModel model, Point temp_point, Circle circle, Rectangle rectangle,
			Square square, String mode, int temp_x, int temp_y, String color, Double LineThickness,
			Squiggle squiggle2, boolean fill, Polyline polyline2, double endPointx, double endPointy,
			double startPointx, double startPointy) {
		this.model = model;
		this.temp_point = temp_point;
		this.circle = circle;
		this.rectangle = rectangle;
		this.square = square;
		this.p = p;
		this.mode = mode;
		this.temp_x = temp_x;
		this.temp_y = temp_y;
		this.color = color;
		this.LineThickness = LineThickness;
		this.squiggle = squiggle2;
		this.fill = fill;
		this.polyline = polyline2;
		this.xend = endPointx;
		this.yend = endPointy;
		this.xstart = startPointx;
		this.ystart = startPointy;
	}

	@Override
	public void execute(MouseEvent e) {


		if (this.mode == "Eraser") {	
			if (this.squiggle!=null){
				
				
			//	Squiggle x  = (Squiggle)this.model.getLastShape();
				//double newStartx = x.getendX();
			//	double newStarty = x.getendY();
			//	this.polyline.startPoint(newStartx,newStarty);
			//	this.squiggle = new Squiggle(this.squiggle.getstartX(),this.squiggle.getstartY(),e.getX(),e.getY(), this.color, this.LineThickness,true);
				
			//	this.model.addSquiggle(this.squiggle);
				//this.model.addShape(this.squiggle);
				
				
				
			}
			}
		
		
		
		if (this.mode == "Squiggle") {	
			if (this.squiggle!=null){
				
				
			//	Squiggle x  = (Squiggle)this.model.getLastShape();
				//double newStartx = x.getendX();
			//	double newStarty = x.getendY();
			//	this.polyline.startPoint(newStartx,newStarty);
			//	this.squiggle = new Squiggle(this.squiggle.getstartX(),this.squiggle.getstartY(),e.getX(),e.getY(), this.color, this.LineThickness,true);
				
				this.model.addSquiggle(this.squiggle);
				this.model.addShape(this.squiggle);
//				this.model.resetPoints();
//				this.model.removeAllPoints();
				// this.model.clearShapes();

			}
		}

		if (this.mode == "Polyline") {
			if (this.polyline != null) {
				// xend = e.getX();
				// yend = e.getY();
				//
				// this.polyline.endPoint(xend,yend);
				// this.model.addPolyline(this.polyline);
				// this.model.addShape(this.polyline);
				// System.out.println(xend+ " y " + yend);
				// // this.polyline = new Polyline(xend,yend,xend,yend, this.color,
				// this.LineThickness);
				// //this.model.addPolyline(this.polyline);
				//
				// //this.polyline.startPoint(xend, yend);
				// Polyline x = (Polyline)this.model.getLastShape();
				// double newStartx = x.getendX();
				// double newStarty = x.getendY();
				// // this.polyline.startPoint(newStartx,newStarty);
				// this.polyline = new Polyline(newStartx,newStarty,e.getX(),e.getY(),
				// this.color, this.LineThickness,true);
				//
				// this.polyline.isFinished(true);
				// this.polyline = null;
				//
				if (this.model.getShapes().size() > 0 && this.model.getLastShape().getClass() == Polyline.class) {
					System.out.println("PPPPPPPPPPPPPPPPPPUUUUUUUUUUUUUUUUUU");
					Polyline x = (Polyline) this.model.getLastShape();
					double newStartx = x.getendX();
					double newStarty = x.getendY();
					// this.polyline.startPoint(newStartx,newStarty);
					this.polyline = new Polyline(newStartx, newStarty, e.getX(), e.getY(), this.color,
							this.LineThickness, true);

					this.model.addPolyline(this.polyline);
					this.model.addShape(this.polyline);

					System.out.println("START X" + this.polyline.getstartX());
					this.xend = e.getX();
					this.yend = e.getY();

					this.polyline.endPoint(xend, yend);
					// this.model.addPolyline(this.polyline);
					// this.model.addShape(this.polyline);
					// System.out.println(this.polyline);
				}
			} else {

				this.xend = e.getX();
				this.yend = e.getY();
				this.polyline = new Polyline(this.polyline.getstartX(), this.polyline.getstartY(), this.xend, this.yend,
						this.color, this.LineThickness, false);
				this.model.addPolyline(this.polyline);
				this.model.addShape(this.polyline);
			}
		}

		if (this.mode == "Circle") {
			if (this.circle != null) {
				// Problematic notion of radius and centre!!
				this.c = new CircleStrategy(this.p, this.circle);
				this.c.mouseReleased(e);

			}
		} else if (this.mode == "Rectangle") {

			// if (this.rectangle != null) {
			// this.temp_x = (int) e.getX();
			// this.temp_y = (int) e.getY();
			//
			// int length = Math.abs((int) this.rectangle.getLocation().getX() - (int)
			// e.getX());
			// int width = Math.abs((int) this.rectangle.getLocation().getY() - (int)
			// e.getY());
			//
			// int x = (int) Math.min(e.getX(), this.rectangle.getLocation().getX());
			// int y = (int) Math.min(e.getY(), this.rectangle.getLocation().getY());
			// Point corner = new Point(x, y, this.color, this.LineThickness);
			//
			// this.rectangle = (new Rectangle(corner, length, width, this.color, this.fill,
			// this.LineThickness));
			//
			// this.rectangle.setLength(length);
			// this.rectangle.setWidth(width);
			// this.rectangle.setDone(true);
			// this.rectangle.setLocation(corner);
			//
			//
			// this.model.addRectangle(this.rectangle);
			// this.model.addShape(this.rectangle);
			//
			//
			//
			// }

		} else if (this.mode == "Square") {
			System.out.println("Released");
			if (this.square != null) {
				this.temp_x = (int) e.getX();
				this.temp_y = (int) e.getY();

				SquareStrategy s = new SquareStrategy(this.p, this.square);
				s.mouseReleased(e);
				this.square = s.s;
			}
		}

}}