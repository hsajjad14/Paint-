package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class RectangleStrategy {

	Rectangle r;
	
	PaintPanel p;
	
	public RectangleStrategy(PaintPanel p, Rectangle r) {
		this.p = p;
		this.r =r;
	}
	

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.r != null) {
//			this.temp_x = (int) e.getX();
//			this.temp_y = (int) e.getY();
//			
			int length = Math.abs((int) this.r.getLocation().getX() - (int) e.getX());
			int width = Math.abs((int) this.r.getLocation().getY() - (int) e.getY());

			int x = (int) Math.min(e.getX(), this.r.getLocation().getX());
			int y = (int) Math.min(e.getY(), this.r.getLocation().getY());
			Point corner = new Point(x, y, this.p.getColour_command(), this.p.LineThickness);
			
			this.r = (new Rectangle(corner, length, width, this.p.getColour_command(), this.p.fill,
					this.p.LineThickness));
			
			this.r.setLength(length);
			this.r.setWidth(width);
			this.r.setDone(true);
			this.r.setLocation(corner);
			

//			this.p.model.addRectangle(this.r);
			this.p.model.addShape(this.r);
			
			

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
		int length = 0, width = 0;

		this.r = (new Rectangle(corner, length, width, this.p.getColour_command(), this.p.fill,
				this.p.LineThickness));
		this.p.rectangle = this.r;
		
	}


	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
//		this.temp_x = (int) e.getX();
//		this.temp_y = (int) e.getY();
		//if thi
		System.out.println(this.r.getLocation().getX());
		int length = Math.abs((int) this.r.getLocation().getX() - (int) e.getX());
		int width = Math.abs((int) this.r.getLocation().getY() - (int) e.getY());

		//System.out.println(this.rectangle.getLocation().getX());
		this.r.setLength(length);
		this.r.setWidth(width);

		this.p.model.addRectangle(this.r);
		this.p.model.addShape(this.r);
	}
	public Rectangle getRect() {
		return this.r;
	}
	
	

}
