package ca.utoronto.utm.paint;

/**
 * 
 * Polyline class.
 * 
 * @author Group
 *
 */
public class Polyline extends Shape{
	double xstart;
	double ystart;
	double xend;
	double yend;
	String colour;
	double LineThickness;
	boolean finished;
	
	public Polyline(double startx, double starty, double endx,double endy, String colour, double LineThickness,boolean finished) {
		super(colour, false, LineThickness);
		this.LineThickness = LineThickness;
		this.colour = colour;
		this.xstart = startx;
		this.ystart = starty;
		this.xend = endx;
		this.yend = endy;
		this.finished = finished;
	}
	

	public double getstartX() {
		return this.xstart;
		}public double getstartY() {
			return this.ystart;
			}public double getendX() {
				return this.xend;
			}public double getendY() {
				return this.yend;
			}
			
	public String getColour() {
		return this.colour;}
	

//	public void setX(int x) {
//		this.x = x;
//	}

	//public int getY() {
	//	return y;
	//}

	//public void setY(int y) {
	//	this.y = y;
	//}
	public void endPoint(double x, double y) {
		this.xend = x;
		this.yend = y;
	}


	public void startPoint(double x2, double y2) {
		this.xstart = x2;
		this.ystart = y2;
		// TODO Auto-generated method stub
		
	}


	public void isFinished(boolean b) {
		this.finished = b;
		// TODO Auto-generated method stub
		
	}
	public boolean isdone() {
		return this.finished;
		// TODO Auto-generated method stub
		
	}
	
	//public double distance(Point other) {
		//int x1 = this.x - other.getX();
		//int x2 = this.y - other.getY();
		//double d = Math.sqrt(x1*x1 + x2*x2);
		//return d;
	//}



}

