package ca.utoronto.utm.paint;
import javafx.scene.input.MouseEvent;

/**
 * 
 * Command interface
 * 
 * @author Group
 *
 */
public interface  Command {
	
	public void execute(MouseEvent e);
	
}
