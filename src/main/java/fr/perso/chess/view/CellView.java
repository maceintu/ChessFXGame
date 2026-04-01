package fr.perso.chess.view;

import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.pieces.Piece;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.function.Consumer;

public class CellView extends StackPane {

    private final Circle dot = new Circle(10, Color.web("#000000", 0.3));

    public static final double SIZE = 50.0;

    public CellView(int row, int col) {
        Color baseColor = (row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN;
        Rectangle background = new Rectangle(SIZE, SIZE);
        background.setFill(baseColor);
        background.setStroke(Color.BLACK); // bordure fine pour chaque cellule
        getChildren().add(background);
        setPrefSize(SIZE, SIZE);
    }
}

//private void updatePieceGraphic(Piece piece) {
//    this.getChildren().removeIf(node -> node instanceof PieceView);
//    if (piece != null) {
//        this.getChildren().add(new PieceView(piece));
//    }
//}
//
//public void showDot(boolean visible) {
//    if (visible) {
//        if (!this.getChildren().contains(dot)) {
//            this.getChildren().add(dot);
//        }
//    } else {
//        this.getChildren().remove(dot);
//    }

