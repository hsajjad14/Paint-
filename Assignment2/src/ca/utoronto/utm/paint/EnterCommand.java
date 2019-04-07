package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;

/**
 * 
 * Enter command, Whenever a mouse is entered this class occurs.
 * 
 * @author Group
 *
 */
public class EnterCommand implements Command {

	private PaintPanel p;
	String mode;
	String file_settings;
	PaintModel model;

	public EnterCommand(PaintPanel panel, String mode, String fs, PaintModel model) {
		this.p = panel;
		this.mode = mode;
		this.file_settings = fs;
		this.model = model;
	}

	@Override
	public void execute(MouseEvent e) {

		if (this.file_settings != null) {
			if (this.file_settings == "New") {
				this.model.getShapes().clear();
				this.p.repaint();
				this.file_settings = null;
			}
			if (this.file_settings == "Exit") {
				System.exit(0);
			}
		}
		
		if (this.mode == "Squiggle") {

		} else if (this.mode == "Circle") {

		} else if (this.mode == "Rectangle") {

		}else if (this.mode == "Square") {

		}
		
	}

}
