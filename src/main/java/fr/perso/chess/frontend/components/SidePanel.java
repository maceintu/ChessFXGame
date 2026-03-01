package fr.perso.chess.frontend.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SidePanel extends VBox {
    public SidePanel() {
        setSpacing(20);
        setPadding(new Insets(15));
        setMinWidth(200);
        setStyle("-fx-background-color: #E8E8E8; -fx-border-color: #CCCCCC; -fx-border-width: 0 0 0 2;");

        Label playerLabel = new Label("Joueur : Blanc");
        Label turnLabel = new Label("Tour : 1");
        Button newGameBtn = new Button("Nouvelle Partie");

        // On rend le bouton large pour le design
        newGameBtn.setMaxWidth(Double.MAX_VALUE);

        this.getChildren().addAll(playerLabel, turnLabel, newGameBtn);
    }
}