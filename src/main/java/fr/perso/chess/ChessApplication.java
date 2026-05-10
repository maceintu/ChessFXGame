package fr.perso.chess;

import fr.perso.chess.controller.GameController;
import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Player;
import fr.perso.chess.view.BoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) {
        BoardView boardView = new BoardView();
        Board board = new Board();
        GameController gc = new GameController(board, boardView);
        HBox.setHgrow(boardView, Priority.ALWAYS);
        BorderPane root = new BorderPane();
        root.setCenter(boardView);
        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Échecs");
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}