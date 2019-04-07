package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * The location where mouse events are heard, passess information to
 * different classes depending on mouse movements
 * 
 * @author Group
 *
 */
class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private int i = 0;
	PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	DragCommand d;
	private String mode; // modifies how we interpret input (could be better?)
	Circle circle; // the circle we are building
	Rectangle rectangle; // Rectangle building
	 Square square;
	 Squiggle squiggle ; // list of all the squiggles
	 Polyline polyline;
	private String colour;
	double endPointx;
	double endPointy;
	Point temp_point;
	
	private String modifier;
	boolean fill = false;
	private String file_settings;

	private int temp_x;
	private int temp_y;

	private Canvas canvas;
	double LineThickness;
	private Shape shape;
	private double startPointx;
	private double startPointy;
	private String canvasColour;
	private Eraser eraser;
	

	public PaintPanel(PaintModel model, View view) {
		this.canvas = new Canvas(740, 570);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);

		// this.mode = "Circle"; // bad code here?
		this.colour = "BLACK";

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}

	public String getColour_command() {
		return this.colour.toUpperCase();
	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();
		this.model.DrawingCommand(g, this);
	

		}



	public void paintPoint(ArrayList<Shape> s, GraphicsContext g) {
	}

	public void paintCircle(Shape s, GraphicsContext g) {
	}

	public void paintRectangle(Shape s, GraphicsContext g) {
	}

	public void paintSquare(Shape s, GraphicsContext g) {

	}
	
	public void ShapeModifier() {
		new ShapeModifierCommand(this.modifier, this).execute();
	}
		
	public String getColour() {
		return "";
	}
	
	public String getMode() {
		return this.mode;
	}

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	// sets collour
	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setCanvas(String colour) {

		this.setStyle("-fx-background-color: "+colour);
		this.canvasColour = this.getStyle().substring(22);
		this.model.setEraserColour(this.canvasColour);
		this.repaint();

	}

	// sets fill style
	public void setFill(String fill_input) {
		if (fill_input == "Fill") {
			this.fill = true;
		} else {
			this.fill = false;

		}
	}

	public void setLineThickness(String LineThickness) {
		if (LineThickness == "Thin") {
			this.LineThickness = 1.0;

		} else if (LineThickness == "Medium") {
			this.LineThickness = 3.0;

		} else if (LineThickness == "Thick") {
			this.LineThickness = 5.0;

		}

	}

	@Override
	public void handle(MouseEvent event) {
		HandleCommand h = new HandleCommand(this);
		h.execute(event);
	}

	public void mouseMoved(MouseEvent e) {
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		}
	}

	public void mouseDragged(MouseEvent e) {
		// this.temp_x = (int)e.getX();
		// this.temp_y = (int)e.getX();

		
		if (this.mode == "Polyline")
		{
			
			 if (this.polyline != null)
			 {	
				 double x = this.polyline.getstartX();
				 double y = this.polyline.getstartY();
				 this.polyline = new Polyline(x,y,e.getX(),e.getY(),this.colour,this.LineThickness,false);
				 this.model.addPolyline(this.polyline);
			 }
		}
		if(this.mode != "Eraser") {
		this.d = new DragCommand(this, this.model, this.temp_point, this.circle, this.rectangle,this.square, this.mode, this.temp_x,
				this.temp_y, this.colour, this.LineThickness,this.polyline,this.squiggle,this.eraser);}
		
		if(this.mode == "Eraser") {
			System.out.println(this.canvasColour);
			this.canvasColour = this.getStyle().substring(22);

			this.d = new DragCommand(this, this.model, this.temp_point, this.circle, this.rectangle,this.square, this.mode, this.temp_x,
				this.temp_y, this.canvasColour, this.LineThickness,this.polyline,this.squiggle,this.eraser);
			}
		d.execute(e);
	}

	public void mouseClicked(MouseEvent e) {

		ClickCommand c = new ClickCommand(this, this.mode);
		c.execute(e);
	}

	public void mousePressed(MouseEvent e) {

		if(this.mode == "Eraser"){
			this.canvasColour = this.getStyle().substring(22);
			this.eraser = new  Eraser(e.getX(),e.getY(),e.getX(),e.getY(),this.canvasColour,this.LineThickness,false);
			PressedCommand x = new PressedCommand(this, this.model, this.temp_point, this.circle, this.rectangle, this.square, this.mode,
					this.temp_x, this.temp_y, this.canvasColour, this.LineThickness, this.fill,this.polyline,this.squiggle,this.eraser);
			x.execute(e);

		} 
	
		PressedCommand p = new PressedCommand(this,this.model, this.temp_point, this.circle, this.rectangle, this.square, this.mode,
				this.temp_x, this.temp_y, this.colour, this.LineThickness, this.fill,this.polyline,this.squiggle,this.eraser);
		p.execute(e);
		new ShapeBuilderFactory(this.mode, p, e, this).build();
		
		
		

		
	}

	public void mouseReleased(MouseEvent e) {

		// System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOO");
		if (this.mode == "Polyline") {
			if (this.polyline != null) {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
				System.out.println(this.polyline);
				this.startPointx = this.polyline.getstartX();
				this.startPointy = this.polyline.getstartY();
				this.polyline = new Polyline(this.startPointx, this.startPointy, e.getX(), e.getY(), this.colour,
						this.LineThickness, true);
				// this.model.addPolyline(this.polyline);
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
				System.out.println(this.polyline.getstartX());
				System.out.println(this.polyline.getstartY());
				System.out.println(this.polyline.getendX());

				System.out.println(this.polyline.getendY());
				double endPointx = e.getX();
				double endPointy = e.getY();
			}
		}

		ReleaseCommand r = new ReleaseCommand(this, this.model, this.temp_point, this.circle, this.rectangle,
				this.square, this.mode, this.temp_x, this.temp_y, this.colour, this.LineThickness, this.squiggle,
				this.fill, this.polyline, this.endPointx, this.endPointy, this.startPointx, this.startPointy);
		r.execute(e);

		if (this.mode == "Rectangle") {
			if (this.rectangle != null) {
				this.temp_x = (int) e.getX();
				this.temp_y = (int) e.getY();

				int length = Math.abs((int) this.rectangle.getLocation().getX() - (int) e.getX());
				int width = Math.abs((int) this.rectangle.getLocation().getY() - (int) e.getY());

				int x = (int) Math.min(e.getX(), this.rectangle.getLocation().getX());
				int y = (int) Math.min(e.getY(), this.rectangle.getLocation().getY());
				Point corner = new Point(x, y, this.getColour_command(), this.LineThickness);
				this.rectangle.setLength(length);
				this.rectangle.setWidth(width);

				this.rectangle.setLocation(corner);
				System.out.println(this.rectangle.getDone());
				this.rectangle.setDone(true);
				this.model.addShape(this.rectangle);//

				this.rectangle = null;

				this.d.temp_x = 0;
				this.d.temp_y = 0;
			}
		} else if (this.mode == "Square") {
			if (this.square != null) {
				this.temp_x = (int) e.getX();
				this.temp_y = (int) e.getY();
				// int length = Math.abs((int) this.rectangle.getLocation().getX() - (int)
				// e.getX());
				int width = Math.abs((int) this.square.getLocation().getX() - (int) e.getX());

				int x = (int) Math.min(e.getX(), this.square.getLocation().getX());
				int y = (int) Math.min(e.getY(), this.square.getLocation().getY());
				Point corner = new Point(x, y, this.getColour_command(), this.LineThickness);
				this.square.setWidth(width);
				this.square.setLocation(corner);
				this.square.setDone(true);
				this.model.addSquare(this.square);
				this.model.addShape(this.square);//

				this.square = null;
				this.d.temp_x = 0;
				this.d.temp_y = 0;
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		EnterCommand en = new EnterCommand(this, this.mode, this.file_settings, this.model);
		en.execute(e);
		if (this.file_settings != null) {
			if (this.file_settings == "New") {
				this.file_settings = null;
			}
		}

	}


	public void setFile_settings(String file_settings) {
		this.file_settings = file_settings;
	}

	public int gettemp_x() {
		return this.temp_x;
	}
	
	public int gettemp_y() {
		return this.temp_y;
	}
	
	public String getModifier() {
		return this.modifier;
	}
	
	public void setModifier(String s) {
		this.modifier = s;
	}
	public double getLineThickness() {
		return this.LineThickness;
		
	}
	
}
