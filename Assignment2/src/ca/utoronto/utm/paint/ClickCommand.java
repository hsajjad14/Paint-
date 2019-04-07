package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;


/**
 * 
 * Whenever a mouse is click, this command hears it.
 * 
 * @author Group
 *
 */
public class ClickCommand implements Command {

	private PaintPanel p;
	String mode;

	public ClickCommand(PaintPanel panel, String mode) {
		this.p = panel;
		this.mode = mode;
	}

	@Override
	public void execute(MouseEvent e) {

		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {


		} else if (this.mode == "Rectangle") {

		} else if (this.mode == "Square") {

		}else if (this.mode == "Canvas") {
			if (this.p.getColour_command() != null) {
				String s = this.p.getColour_command().toLowerCase();
				this.p.setStyle("-fx-background-color: " + s);

			}
		}
	}

}
