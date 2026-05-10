package fr.perso.chess.view;

import fr.perso.chess.model.general.Cell;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CellView extends StackPane {

    private final Circle dot = new Circle(10, Color.web("#000000", 0.3));
    private PieceView currentPieceView;
    public static final double SIZE = 50.0;

    public CellView(int row, int col) {
        Color baseColor = (row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN;
        Rectangle background = new Rectangle(SIZE, SIZE);
        background.setFill(baseColor);
        background.setStroke(Color.BLACK);
        getChildren().add(background);
        setPrefSize(SIZE, SIZE);
    }

    public void drawFromCell(Cell cell){
        if (this.currentPieceView != null) {
            this.getChildren().remove(this.currentPieceView);
            this.currentPieceView = null;
        }
        if (cell.getPiece() != null) {
            this.currentPieceView = new PieceView(cell.getPiece());
            this.getChildren().add(this.currentPieceView);
        };
    }

}

//public void showDot(boolean visible) {
//    if (visible) {
//        if (!this.getChildren().contains(dot)) {
//            this.getChildren().add(dot);
//        }
//    } else {
//        this.getChildren().remove(dot);
//    }

