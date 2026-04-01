package fr.perso.chess;

import fr.perso.chess.controller.GameController;
import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Player;
import fr.perso.chess.view.BoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) {
        BoardView boardView = new BoardView();
        Board board = new Board(new Player(true), new Player(false));
        GameController gc = new GameController(board, boardView);
        HBox.setHgrow(boardView, Priority.ALWAYS);
        HBox root = new HBox(boardView);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Échecs");
        //stage.setFullScreen(true);
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(800);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}