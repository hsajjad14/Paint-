package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SquareStrategy {

	Square s;
	
	PaintPanel p;
	
	public SquareStrategy(PaintPanel p, Square s) {
		this.p = p;
		this.s =s;
	} 
	

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.s != null) {
//			this.temp_x = (int) e.getX();
//			this.temp_y = (int) e.getY();

			int width = Math.abs((int) this.s.getLocation().getX() - (int) e.getX());

			int x = (int) Math.min(e.getX(), this.s.getLocation().getX());
			int y = (int) Math.min(e.getY(), this.s.getLocation().getY());
			Point corner = new Point(x, y, this.p.getColour_command(), this.p.LineThickness);
			
			this.s = (new Square(corner, width, this.p.getColour_command(), this.p.fill,
					this.p.LineThickness));
			this.s.setWidth(width);
			this.s.setDone(true);
			this.s.setLocation(corner);
			

			//this.p.model.addSquare(this.s);
			this.p.model.addShape(this.s);
			
			

		}
		
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point corner = new Point((int) e.getX(), (int) e.getY(), this.p.getColour_command(), this.p.LineThickness);
		int width = 0;

		this.s = (new Square(corner, width, this.p.getColour_command(), this.p.fill,
				this.p.LineThickness));
		
	}


	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
//		this.temp_x = (int) e.getX();
//		this.temp_y = (int) e.getY();
		//if thi
		int width = Math.abs((int) this.s.getLocation().getX() - (int) e.getX());
		//System.out.println(this.rectangle.getLocation().getX());
		this.s.setWidth(width);

		this.p.model.addSquare(this.s);
		this.p.model.addShape(this.s);
	}
	public Square getSquare() {
		return this.s;
	}
	
	

}
