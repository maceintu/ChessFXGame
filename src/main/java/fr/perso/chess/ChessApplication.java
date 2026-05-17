package fr.perso.chess;

import fr.perso.chess.controller.GameManager;
import fr.perso.chess.view.ImageFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) {
        ImageFactory.preload();
        GameManager gameManager = new GameManager(stage);
        gameManager.start();
    }

    public static void main(String[] args) {
        launch();
    }
}