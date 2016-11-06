package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

	protected static Boolean xRound = true;
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(600, 600);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * 200);
				tile.setTranslateY(i * 200);
				
				root.getChildren().add(tile);
			}
		}

		return root;
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setScene(new Scene(createContent()));

		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
