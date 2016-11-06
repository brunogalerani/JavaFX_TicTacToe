package app;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

	private Text content = new Text();

	public Tile() {

		Rectangle gameBoard = new Rectangle(200, 200);
		gameBoard.setFill(null);
		gameBoard.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);

		content.setFont(Font.font(72));

		getChildren().addAll(gameBoard, content);

		setOnMouseClicked(event -> {
			if (App.gameEnded) {
				return;
			}

			if (event.getButton() == MouseButton.PRIMARY) {
				if (!App.xRound || !content.getText().isEmpty()) {
					return;
				}
				drawX();

			} else if (event.getButton() == MouseButton.SECONDARY) {
				if (App.xRound || !content.getText().isEmpty()) {
					return;
				}
				drawO();
			}
		});

	}

	void drawX() {
		content.setText("X");
		App.xRound = false;
		App.checkGameState();
	}

	void drawO() {
		content.setText("O");
		App.xRound = true;
		App.checkGameState();
	}

	public String getValue() {
		return content.getText();
	}
}
