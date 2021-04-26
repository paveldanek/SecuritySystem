package application;

import display.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private GUI gui = new GUI();

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			gui.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
