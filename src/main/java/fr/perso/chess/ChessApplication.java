package fr.perso.chess;

import fr.perso.chess.controller.GameController;
import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Player;
import fr.perso.chess.view.components.BoardView;
import fr.perso.chess.view.components.SidePanel;
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
        SidePanel sidePanel = new SidePanel();
        HBox.setHgrow(boardView, Priority.ALWAYS);
        HBox root = new HBox(boardView, sidePanel);
        Scene scene = new Scene(root, 900, 700);
        stage.setTitle("Échecs 2.0 - Architecture Propre");
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}