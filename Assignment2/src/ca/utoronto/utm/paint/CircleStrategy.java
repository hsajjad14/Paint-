package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


/**
 * 
 * A builder for a Circle object, drags, presses, and releases circles (mouse movements)
 * 
 * @author Haider
 *
 */
public class CircleStrategy {

	Circle c;
	
	PaintPanel p;
	
	public CircleStrategy(PaintPanel p, Circle c) {
		this.p = p;
		this.c =c;
	}
	

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this.p.circle != null) { 
			// Problematic notion of radius and centre!!

			int x = Math.abs((int) this.p.circle.getLocation().getX() - (int) e.getX());
			int y = Math.abs((int) this.p.circle.getLocation().getY() - (int) e.getY());

			int rad = 2 * (int) Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

			this.p.circle.setRadius(rad);
			// System.out.println(rad);
			Point centre = new Point((int) this.p.circle.getLocation().getX(), (int) this.p.circle.getLocation().getY(),
					this.p.getColour_command(), this.p.LineThickness);
			this.p.circle.setLocation(centre);

			this.p.model.addCircle(this.p.circle);
			this.p.model.addShape(this.p.circle);//

			this.p.circle = null;

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
		Point centre = new Point((int) e.getX(), (int) e.getY(), this.p.getColour_command(), this.p.LineThickness);
		int radius = 0;
		this.c = (new Circle(centre, radius, this.p.getColour_command(), this.p.fill, this.p.LineThickness));
		this.p.circle = this.c;
	}


	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
		
		
		System.out.println(this.c.getLocation());
		int x = Math.abs((int) this.c.getLocation().getX() - (int) e.getX());
		int y = Math.abs((int) this.c.getLocation().getY() - (int) e.getY());

		int rad = 2 * (int) Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5);

		this.c.setRadius(rad);

		//System.out.println(rad);
		this.p.circle = this.c;
		this.p.model.addShape(this.p.circle);//
	}
	public Circle getCircle() {
		return this.c;
	}
	
	

}
