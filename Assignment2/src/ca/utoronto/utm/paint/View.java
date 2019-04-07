package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View implements EventHandler<ActionEvent> {

	private PaintModel model;

	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColourChooserPanel colourChooserPanel;

	public View(PaintModel model, Stage stage) {

		this.model = model;
		initUI(stage);
	}

	private void initUI(Stage stage) {
		this.paintPanel = new PaintPanel(this.model, this);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.colourChooserPanel = new ColourChooserPanel(this);
		
		BorderPane root = new BorderPane();
		root.setTop(createMenuBar());
		root.setCenter(this.paintPanel);
		root.setLeft(this.shapeChooserPanel);
		root.setBottom(this.colourChooserPanel);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Paint");
		stage.show();
	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}

	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	
	

	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);
		
		
		// A menu for colour
		//menu = new Menu("Colour");

//		menuItem = new MenuItem("Red");
//		menuItem.setOnAction(this);
//		menu.getItems().add(menuItem);

//		menuItem = new MenuItem("Blue");
//		menuItem.setOnAction(this);
//		menu.getItems().add(menuItem);

//		menuItem = new MenuItem("Green");
//		menuItem.setOnAction(this);
//		menu.getItems().add(menuItem);

//		menuItem = new MenuItem("Yellow");
//		menuItem.setOnAction(this);
//		menu.getItems().add(menuItem);

//		menuItem = new MenuItem("White");
//		menuItem.setOnAction(this);
//		menu.getItems().add(menuItem);
		
//		menuItem = new MenuItem("Purple");
//		menuItem.setOnAction(this);
//		menu.getItems().add(menuItem);

//		menuItem = new MenuItem("Black");
//		menuItem.setOnAction(this);
//		menu.getItems().add(menuItem);
		
//		menuBar.getMenus().add(menu);
		
		// add option fill style
		menu = new Menu("Fill Option");

		menuItem = new MenuItem("No Fill");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);
		
		menuItem = new MenuItem("Fill");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);
		menuBar.getMenus().add(menu);

		
		// A menu for Line Thickness
		menu = new Menu("Line Thickness");
		menuItem = new MenuItem("Thin");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Medium");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Thick");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);


		return menuBar;
	}

	@Override
	public void handle(ActionEvent event) {
		String command = ((MenuItem)event.getSource()).getText();
		System.out.println(command);
		this.getPaintPanel().setModifier(command);
		this.getPaintPanel().ShapeModifier();
		//System.out.println(((MenuItem)event.getSource()).getText());
	}
}
