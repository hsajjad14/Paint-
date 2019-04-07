package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * 
 * Handler command, used for the handler in paintpanel
 * 
 * @author Group
 *
 */
public class HandleCommand implements Command {
	private PaintPanel p;

	public HandleCommand(PaintPanel p) {
		this.p = p;
	}

	@Override
	public void execute(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			p.mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			p.mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			p.mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			p.mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			p.mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			p.mouseEntered(event);
		} 

	}

}
