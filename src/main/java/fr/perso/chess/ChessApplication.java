package fr.perso.chess;

import fr.perso.chess.controller.GameManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) {
        GameManager gameManager = new GameManager(stage);
        gameManager.start();
    }
}