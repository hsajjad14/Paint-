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
 * The colour pannel at the bottom of the application.
 * 
 * @author Haider
 *
 */
public class ColourChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private Button btnOldColour;
	private Button btnCanvas;

	public ColourChooserPanel(View view) {
		this.view = view;
		int row = 0;

		Button button = new Button("Change Canvas colour");
		button.setMinWidth(800);
		button.setStyle("-fx-text-fill: black; -fx-background-color: white; -fx-border-color: black");
		//Parameters of add, (btn, column, row, column span, row span)
		this.add(button, 0, row,10,1);
		row++;
		button.setOnAction(this);
		
		// Draw colour grid
		String[] btnColours = { "#6e7f80", "#536872", "#708090", "#536878", "#36454f", "#011f4b", "#03396c", "#005b96",
				"#6497b1", "#b3cde0	", "#ff0000", "#bf0000", "#800000", "#400000", "#000000", "#b2d8d8", "#66b2b2",
				"#008080", "#006666", "#004c4c", "#007777", "#006666", "#005555", "#004444", "#003333", "#9762ff",
				"#b466db", "#cc64b2", "#e5658b", "#ff6969" };
		int column = 0;
		int level = 0;
		for (String colour : btnColours) {
			Button btn = new Button(colour);
			btn.setMinWidth(80);
			btn.setMaxWidth(80);
			btn.setStyle("-fx-focus-color: transparent;" + "-fx-background-radius: 0;" + "-fx-background-color: "
					+ colour + ";" + "-fx-text-fill: transparent");
			this.add(btn, column, row);
			column++;
			level++;
			if (level % 10 == 0) {
				row++;
				column = 0;
			}
			btn.setOnAction(this);
		}
	

	}

	@Override
	public void handle(ActionEvent event) {
		String[] btnColours = { "#6e7f80", "#536872", "#708090", "#536878", "#36454f", "#011f4b", "#03396c", "#005b96",
				"#6497b1", "#b3cde0	", "#ff0000", "#bf0000", "#800000", "#400000", "#000000", "#b2d8d8", "#66b2b2",
				"#008080", "#006666", "#004c4c", "#007777", "#006666", "#005555", "#004444", "#003333", "#9762ff",
				"#b466db", "#cc64b2", "#e5658b", "#ff6969" };
		String command = ((Button) event.getSource()).getText();

		if (Arrays.asList(btnColours).contains(command)) {
			if (btnOldColour != null) {
				btnOldColour.setEffect(null);
			}
			DropShadow shadow = new DropShadow();
			Button btn = (Button) event.getSource();
			btn.setEffect(shadow);
			this.view.getPaintPanel().setColour(command);
			System.out.println(command);
			btnOldColour = btn;

		} else {
			if (btnOldColour != null) {
				String colour = (btnOldColour).getText();
				DropShadow shadow = new DropShadow();
				Button btn = (Button) event.getSource();
				btn.setEffect(shadow);
				this.view.getPaintPanel().setCanvas(colour);
				System.out.println(colour+" "+ command);
				btnCanvas = btn;
			}
		}

	}

}
