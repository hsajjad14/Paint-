package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;

/**
 * 
 * Pressed command, any mouse event that is pressed
 * 
 * @author Group
 *
 */
public class PressedCommand implements Command {
	private PaintModel model;
	private Point temp_point;
	private Circle circle;
	private Square square;
	private Rectangle rectangle;
	private String mode;
	private int temp_x;
	private int temp_y;
	private String color;
	private double LineThickness;
	private boolean fill;
	private double xstart;
	private double ystart;
	private double xend;
	private double yend;
	private Polyline polyline;
	PaintPanel p;
	CircleStrategy c;
	RectangleStrategy r;
	SquareStrategy s;

	private Squiggle squiggle;
	private Eraser eraser;

	public PressedCommand(PaintPanel p,PaintModel model, Point temp_point, Circle circle, Rectangle rectangle, Square square, String mode, int temp_x, int temp_y, String color, Double LineThickness, boolean fill, Polyline polyline2, Squiggle squiggle, Eraser eraser) {
		this.model = model;
		this.temp_point = temp_point;
		this.circle = circle;
		this.square = square;
		this.rectangle = rectangle;
		this.mode = mode;
		this.temp_x = temp_x;
		this.temp_y = temp_y;
		this.color = color;
		this.LineThickness = LineThickness;
		this.fill = fill;
		this.polyline = polyline2;
		this.p = p;
		this.squiggle = squiggle;
		
	}

	@Override
	public void execute(MouseEvent e) {
		if(this.mode == "Eraser") {
				if (this.eraser !=null) 
				{
					
		//			Squiggle x  = (Squiggle)this.model.getLastShape();
//					double newStartx = x.getendX();
//					double newStarty = x.getendY();
//				//	this.polyline.startPoint(newStartx,newStarty);
					this.eraser = new Eraser(e.getX(),e.getY(),e.getX(),e.getY(), this.color, (this.LineThickness+1)*5,false);
					this.model.addEraser(this.eraser);
					this.model.addShape(this.eraser);
					
				}
				else
				{
				xstart = xend = e.getX();
				ystart = yend = e.getY();
				this.eraser = new Eraser(xstart,ystart,xend,yend,this.color,(this.LineThickness+1)*5,false);
				this.model.addShape(this.eraser);
				this.model.addEraser(this.eraser);
				}
			}
			
	
		
		
		
		
		
		
		if (this.mode == "Squiggle") 
		{	if (this.mode == "Squiggle") 
		{
			if (this.squiggle !=null) 
			{
				
	//			Squiggle x  = (Squiggle)this.model.getLastShape();
//				double newStartx = x.getendX();
//				double newStarty = x.getendY();
//			//	this.polyline.startPoint(newStartx,newStarty);
				this.squiggle = new Squiggle(e.getX(),e.getY(),e.getX(),e.getY(), this.color, this.LineThickness,false);
				this.model.addSquiggle(this.squiggle);
				this.model.addShape(this.squiggle);
				
			}
			else
			{
			xstart = xend = e.getX();
			ystart = yend = e.getY();
			this.squiggle = new Squiggle(xstart,ystart,xend,yend,this.color,this.LineThickness,false);
			this.model.addShape(this.squiggle);
			this.model.addSquiggle(this.squiggle);
			}
		}}
		
		else if (this.mode == "Polyline")
		{
			if (this.polyline !=null) 
			{
				System.out.println("NNNNNNNNNNNUUUUUUUUUULLLLLLLLLLLLLLLL");
				if(this.model.getLastShape().getClass() == Polyline.class) 
				{
				System.out.println("PPPPPPPPPPPPPPPPPPUUUUUUUUUUUUUUUUUU");
				Polyline x  = (Polyline)this.model.getLastShape();
				double newStartx = x.getendX();
				double newStarty = x.getendY();
			//	this.polyline.startPoint(newStartx,newStarty);
				this.polyline = new Polyline(newStartx,newStarty,newStartx,newStarty, this.color, this.LineThickness,false);
				this.model.addPolyline(this.polyline);
				this.model.addShape(this.polyline);
				}
				else {
					xstart = xend = e.getX();
					ystart = yend = e.getY();
					this.polyline = new Polyline(xstart,ystart,xend,yend,this.color,this.LineThickness,false);
					this.model.addShape(this.polyline);
					this.model.addPolyline(this.polyline);
					
				}
			}
			else
			{
			xstart = xend = e.getX();
			ystart = yend = e.getY();
			this.polyline = new Polyline(xstart,ystart,xend,yend,this.color,this.LineThickness,false);
			this.model.addShape(this.polyline);
			this.model.addPolyline(this.polyline);
			}
		}
		else if (this.mode == "Circle") {
			// Problematic notion of radius and centre!!
			this.c = new CircleStrategy(this.p,this.circle);
			this.c.mousePressed(e);
			
		} else if (this.mode == "Rectangle") {

			this.r = new RectangleStrategy(this.p,this.rectangle);
			this.r.mousePressed(e);

		}
		else if (this.mode == "Square") {
			System.out.println("pressed");
			this.s = new SquareStrategy(this.p,this.square);
			this.s.mousePressed(e);

		}

	}

	public Circle getCircle() {
		return this.c.getCircle();
	}


	public Rectangle getRectangle() {
		return this.r.getRect();
	}
	public Square getSquare() {
		return this.s.s;
	}

	

}
