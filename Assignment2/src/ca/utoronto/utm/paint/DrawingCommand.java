package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * Drawing command interface
 * 
 * @author Group
 *
 */
public interface DrawingCommand {
	
	public void excecute(GraphicsContext g);

}
