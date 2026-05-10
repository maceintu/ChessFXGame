package fr.perso.chess.view;

import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.pieces.Piece;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class PieceView extends StackPane {
    public PieceView(Piece piece) {
        Circle circle = new Circle(25);
        circle.setFill(piece.getColor() == PlayerColor.WHITE ? Color.WHITE : Color.BLACK);
        circle.setStroke(Color.GRAY);

        String initial = piece.getClass().getSimpleName().substring(0, 1);
        Text text = new Text(initial);
        text.setFill(piece.getColor() == PlayerColor.WHITE ? Color.BLACK : Color.WHITE);

        this.getChildren().addAll(circle, text);
    }
}