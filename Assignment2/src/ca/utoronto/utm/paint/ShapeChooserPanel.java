package ca.utoronto.utm.paint;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


/**
 * 
 * A Panel for the buttons.
 * 
 * @author Haider
 *
 */
public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private Image img;
	private Button btnOldMode;
	private Button btnOldColour;
	private Button btnCanvas;
	public ShapeChooserPanel(View view) {

		this.view = view;

		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Eraser"};
		
		int row = 0;
		for (String label : buttonLabels) {
			try {
				img = new Image(new FileInputStream("src/ca/utoronto/utm/paint/resources/"+label+".png"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Button button = new Button(label);
			button.setStyle("-fx-text-fill: transparent; -fx-background-color: white; -fx-border-color: black");
			button.setGraphic(new ImageView(img));

			button.setPrefSize(40, 95);
			
			//Parameters of add, (btn, column, row, column span, row span)
			this.add(button, 0, row,3,1);
			row++;
			button.setOnAction(this);
		}
		
}

	@Override
	public void handle(ActionEvent event) {
		String[] btnLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Eraser" };
		String command = ((Button) event.getSource()).getText();
		if (Arrays.asList(btnLabels).contains(command)) {
			if (btnOldMode!=null) {
				btnOldMode.setEffect(null);
			}
			if (btnCanvas!= null) {
				btnCanvas.setEffect(null);
			}
			DropShadow shadow = new DropShadow();
			Button btn = (Button)event.getSource();
			btn.setEffect(shadow);
			this.view.getPaintPanel().setMode(command);
			System.out.println(command);
			btnOldMode = btn;
		}
		else {
			if (btnOldColour != null) {
				String colour = btnOldColour.getText();
				DropShadow shadow = new DropShadow();
				Button btn = (Button)event.getSource();
				btn.setEffect(shadow);
				this.view.getPaintPanel().setCanvas(colour);
				System.out.println(command);
				btnCanvas = btn;
			}
		}
		
	}
	

	

}
