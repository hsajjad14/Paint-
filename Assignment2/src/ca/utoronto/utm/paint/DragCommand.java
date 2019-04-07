/**
 * 
 */
package ca.utoronto.utm.paint;
import javafx.scene.input.MouseEvent;


/**
 * 
 * Command for when mouse is being dragged. Everything that occurs
 * during a mouse drag occurs here.
 * 
 * @author kazmiza2
 *
 */
public class DragCommand implements Command {
	private PaintModel model;
	private Point temp_point;
	private Circle circle;
	private Square square;
	private Rectangle rectangle;
	private String mode;
	int temp_x;
	int temp_y;
	private String color;
	private double LineThickness;
	private double xstart;
	private double ystart;
	private double xend;
	private double yend;
	private Polyline polyline;
	PaintPanel p;
	private Squiggle squiggle;
	private Eraser eraser;
	
	public DragCommand(PaintPanel p, PaintModel model, Point temp_point, Circle circle, Rectangle rectangle, Square square, String mode, int temp_x, int temp_y, String color, Double LineThickness, Polyline polyline2,Squiggle squiggle, Eraser eraser2) {
this.p = p;
		this.model = model;
		this.temp_point = temp_point;
		this.circle = circle;
		this.rectangle = rectangle;
		this.square = square;
		this.mode = mode;
		this.color = color;
		this.LineThickness = LineThickness;
		this.temp_x = temp_x;
		this.temp_y = temp_y;
		this.polyline = polyline2;

		this.squiggle = squiggle;
		this.eraser = eraser;
	}

	@Override
	public void execute(MouseEvent e) {

		if(this.mode == "Eraser") 
		{
				if( this.model.getShapes().size() >0 && this.model.getLastShape().getClass() == Eraser.class) 
					{


					Eraser x  = (Eraser)this.model.getLastShape();
					double newStartx = x.getendX();
					double newStarty = x.getendY();
				//	this.polyline.startPoint(newStartx,newStarty);
					this.eraser = new Eraser(newStartx,newStarty,e.getX(),e.getY(), this.color, this.LineThickness,true);
					
					this.model.addEraser(this.eraser);
					this.model.addShape(this.eraser);
					
					this.xend = e.getX();
					this.yend = e.getY();
			
					this.eraser.endPoint(xend,yend);
					//this.model.addPolyline(this.polyline);
					//this.model.addShape(this.polyline);
					//System.out.println(this.polyline);
				}
			
		
		
				}
		
			
		
		if (this.mode == "Squiggle") 
		{
			if(this.squiggle != null) 
				if( this.model.getShapes().size() >0 && this.model.getLastShape().getClass() == Squiggle.class) 
					{
					Squiggle x  = (Squiggle)this.model.getLastShape();
					double newStartx = x.getendX();
					double newStarty = x.getendY();
				//	this.polyline.startPoint(newStartx,newStarty);
					this.squiggle = new Squiggle(newStartx,newStarty,e.getX(),e.getY(), this.color, this.LineThickness,true);
					
					this.model.addSquiggle(this.squiggle);
					this.model.addShape(this.squiggle);
					
					this.xend = e.getX();
					this.yend = e.getY();
			
					this.squiggle.endPoint(xend,yend);
					//this.model.addPolyline(this.polyline);
					//this.model.addShape(this.polyline);
					//System.out.println(this.polyline);
				}
			
		
		
				else {
					xstart = xend = e.getX();
					ystart = yend = e.getY();
					this.squiggle = new Squiggle(xstart,ystart,xend,yend,this.color,this.LineThickness,false);
					this.model.addShape(this.squiggle);
					this.model.addSquiggle(this.squiggle);
					
				}
		
			}
		
		else if(this.mode == "Polyline"){
			if(this.polyline != null)		
			{
				
				
//				if( this.model.getShapes().size() >0 && this.model.getLastShape().getClass() == Polyline.class) 
//				{
//				System.out.println("PPPPPPPPPPPPPPPPPPUUUUUUUUUUUUUUUUUU");
//				Polyline x  = (Polyline)this.model.getLastShape();
//				double newStartx = x.getendX();
//				double newStarty = x.getendY();
//			//	this.polyline.startPoint(newStartx,newStarty);
//				this.polyline = new Polyline(newStartx,newStarty,e.getX(),e.getY(), this.color, this.LineThickness,true);
//				
//				this.model.addPolyline(this.polyline);
//				this.model.addShape(this.polyline);
//				
//				System.out.println("START X" + this.polyline.getstartX());
//				this.xend = e.getX();
//				this.yend = e.getY();
//		
//				this.polyline.endPoint(xend,yend);
//				//this.model.addPolyline(this.polyline);
//				//this.model.addShape(this.polyline);
//				//System.out.println(this.polyline);
//			}}
//			else {
//			
//			this.xend = e.getX();
//			this.yend = e.getY();
//			this.polyline = new Polyline(this.polyline.getstartX(),this.polyline.getstartY(),this.xend,this.yend, this.color, this.LineThickness,false);
//			this.model.addPolyline(this.polyline);
//			this.model.addShape(this.polyline);
//			}
			}
			
		}else if (this.mode == "Circle") {

			CircleStrategy c = new CircleStrategy(this.p,this.circle);
			c.mouseDragged(e);
   
		} else if (this.mode == "Rectangle") {
			this.temp_x = (int) e.getX();
			this.temp_y = (int) e.getY();

			if (this.rectangle != null) {
				System.out.println(this.rectangle.getLocation().getX());
				RectangleStrategy r = new RectangleStrategy(this.p,this.rectangle);
				r.mouseDragged(e);
				this.p.rectangle = r.r;
			}
			

		}else if (this.mode == "Square") {
			System.out.println("drag");
			this.temp_x = (int) e.getX();
			this.temp_y = (int) e.getY();

			if (this.square != null) {
				SquareStrategy s = new SquareStrategy(this.p,this.square);
				s.mouseDragged(e);
			}


		}
		
	}
	
	
	public Circle getCircle() {
		return circle;
	}


	public Rectangle getRectangle() {
		return rectangle;
	}
	public Square getSquare() {
		return square;
	}
	
	public Point getPoint() {
		return this.temp_point;
	}

	

}
