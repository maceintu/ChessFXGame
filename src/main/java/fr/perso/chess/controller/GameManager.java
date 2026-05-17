package fr.perso.chess.controller;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.view.BoardView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class GameManager {

    private final Stage primaryStage;

    public GameManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Mon Super Jeu d'Échecs");
    }

    public void start() {
        showMainMenu();
        this.primaryStage.show();
    }

    public void showMainMenu() {
        VBox menuRoot = new VBox(20);
        menuRoot.setAlignment(Pos.CENTER);

        Button btnLocal = new Button("Jouer en Local (1v1)");
        Button btnOnline = new Button("Jouer en Ligne");
        btnLocal.setOnAction(e -> startLocalGame());
        menuRoot.getChildren().addAll(btnLocal, btnOnline);
        primaryStage.setScene(new Scene(menuRoot, 600, 600));
    }

    public void startLocalGame() {
        Board board = new Board();
        BoardView boardView = new BoardView();
        Button undoButton = new Button("Undo");
        VBox sidebar = new VBox(20);
        sidebar.setAlignment(Pos.CENTER);
        sidebar.getChildren().add(undoButton);
        HBox gameRoot = new HBox(30);
        gameRoot.getChildren().addAll(boardView, sidebar);
        LocalMatchController controller = new LocalMatchController(board, boardView, undoButton);
        primaryStage.setScene(new Scene(gameRoot, 900, 600));
    }

    public void onGameEnded(String message) {
        System.out.println("Partie terminée : " + message);
        showMainMenu();
    }
}