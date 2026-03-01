package fr.perso.chess.frontend.components;

import fr.perso.chess.backend.pieces.Piece;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class PieceView extends StackPane {
    public PieceView(Piece piece) {
        Circle circle = new Circle(25);
        circle.setFill(piece.getPlayer().isWhite() ? Color.WHITE : Color.BLACK);
        circle.setStroke(Color.GRAY);

        String initial = piece.getClass().getSimpleName().substring(0, 1);
        Text text = new Text(initial);
        text.setFill(piece.getPlayer().isWhite() ? Color.BLACK : Color.WHITE);

        this.getChildren().addAll(circle, text);
    }
}