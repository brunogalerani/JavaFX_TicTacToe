package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
	
	
	protected static Boolean xRound = true;
	protected static Boolean gameEnded = false;
	private static List<Sequences> sequences = new ArrayList<>();
	private Tile[][] gameBoard = new Tile[3][3];
	
	private static Socket socket;
	private static PrintWriter writer;
	private static Scanner reader;
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(600, 600);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * 200);
				tile.setTranslateY(i * 200);
				
				root.getChildren().add(tile);
				
				gameBoard[j][i] = tile;
			}
		}
		
		// horizontal
        for (int y = 0; y < 3; y++) {
            sequences.add(new Sequences(gameBoard[0][y], gameBoard[1][y], gameBoard[2][y]));
        }

        // vertical
        for (int x = 0; x < 3; x++) {
            sequences.add(new Sequences(gameBoard[x][0], gameBoard[x][1], gameBoard[x][2]));
        }

        // diagonals
        sequences.add(new Sequences(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]));
        sequences.add(new Sequences(gameBoard[2][0], gameBoard[1][1], gameBoard[0][2]));

		return root;
	}

	public static void checkGameState(){
		for(Sequences sequence : sequences){
			if(sequence.isSequenceComplete()){
				gameEnded = true;
			}
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {

		stage.setScene(new Scene(createContent()));
		networkConfig();

		stage.show();

	}
	
	public void networkConfig() {
		try {
			socket = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(socket.getOutputStream());
			reader = new Scanner(socket.getInputStream());
			new Thread(new ListenServer()).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public class ListenServer implements Runnable {

		@Override
		public void run() {
			try {
				String text;
				while ((text = reader.nextLine()) != null) {
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
}
