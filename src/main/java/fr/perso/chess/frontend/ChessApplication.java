package fr.perso.chess.frontend;

import fr.perso.chess.backend.general.Board;
import fr.perso.chess.backend.general.GameController;
import fr.perso.chess.frontend.components.BoardView;
import fr.perso.chess.frontend.components.SidePanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) {
        GameController gc = new GameController();
        BoardView boardView = new BoardView(gc);
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