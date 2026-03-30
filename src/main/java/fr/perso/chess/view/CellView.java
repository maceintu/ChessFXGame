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

    public static final double SIZE = 70.0; // Taille d'une case

    public CellView(int row, int col) {
        // 1. Définir la taille du composant
        this.setPrefSize(SIZE, SIZE);
        this.setMinSize(SIZE, SIZE);

        // 2. Déterminer la couleur
        Color color = (row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN;

        // 3. Créer un fond visuel
        Rectangle background = new Rectangle(SIZE, SIZE);
        background.setFill(color);

        // 4. Ajouter le fond à la vue
        this.getChildren().add(background);
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

