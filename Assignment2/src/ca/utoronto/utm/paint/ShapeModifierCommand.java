package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

public class ShapeModifierCommand implements DrawingCommand {
	private String mode;
	private PaintPanel p;

	public ShapeModifierCommand(String mode, PaintPanel p) {
		this.mode = mode;
		this.p = p;
	}

	@Override
	public void excecute(GraphicsContext g) {
		
	}
	
	public void execute() {
		if (this.mode == "Fill" || this.mode == "No Fill") {
			this.p.setFill(this.mode);
		} else if (this.mode == "Thin" || this.mode  == "Thick" || this.mode  == "Medium"){
			this.p.setLineThickness(this.mode);
		} else if ((this.mode == "New") || (this.mode == "Open") || (this.mode == "Save") || (this.mode == "Exit")){
			this.p.setFile_settings(this.mode);
		} else {
			this.p.setColour(this.mode);
		} 
	}
}
