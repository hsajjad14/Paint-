package ca.utoronto.utm.paint;
import javafx.scene.input.MouseEvent;


public class ShapeBuilderFactory {
	private PressedCommand p;
	private String mode;
	private PaintPanel pannel;
	private MouseEvent e;

	public ShapeBuilderFactory(String mode, PressedCommand p, MouseEvent e, PaintPanel pannel) {
		this.mode = mode;
		this.p = p;
		this.pannel = pannel;
		this.e = e;
				
	}
	
	public void build() {
	
		if (this.mode == "Circle") {
			this.pannel.circle = p.getCircle();
		} else if (this.mode == "Rectangle") {
			this.pannel.rectangle = p.getRectangle();
		} 
		
		if (this.mode == "Square") {
			this.pannel.square = p.getSquare();
		}
		
		if( this.mode == "Polyline"){
			this.pannel.polyline = new Polyline(this.e.getX(),this.e.getY(),this.e.getX(),this.e.getY(),this.pannel.getColour(),this.pannel.getLineThickness(),false);
			}

		if(this.mode == "Squiggle") {
			this.pannel.squiggle = new Squiggle(this.e.getX(),this.e.getY(),this.e.getX(),this.e.getY(),this.pannel.getColour(),this.pannel.getLineThickness(),false);
		}
	}
	

}
