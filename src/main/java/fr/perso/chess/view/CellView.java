package fr.perso.chess.view;

import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Position;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.function.Consumer;

public class CellView extends StackPane {

    public static final double SIZE = 50.0;
    private final Position position;
    private PieceView currentPieceView;
    private Circle activeDot = null;

    public Position getPosition() {
        return position;
    }


    public CellView(int row, int col) {
        this.position = new Position(row, col);
        Color baseColor = (row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN;
        Rectangle background = new Rectangle(SIZE, SIZE);
        background.setFill(baseColor);
        background.setStroke(Color.BLACK);
        getChildren().add(background);
        setPrefSize(SIZE, SIZE);
    }

    public void drawFromCell(Cell cell) {
        if (this.currentPieceView != null) {
            this.getChildren().remove(this.currentPieceView);
            this.currentPieceView = null;
        }
        if (cell.getPiece() != null) {
            this.currentPieceView = new PieceView(cell.getPiece());
            this.getChildren().add(this.currentPieceView);
        }
    }

    public void setOnClicked(Consumer<Position> func) {
        this.setOnMouseClicked(mouseEvent -> {
            func.accept(this.position);
        });
    }

    public void showDot(boolean visible) {
        if (visible) {
            if (this.currentPieceView == null)
                activeDot = createEmptyDot();
             else
                activeDot = createCaptureDot();
            this.getChildren().add(activeDot);
        } else {
            if (activeDot != null) {
                this.getChildren().remove(activeDot);
                activeDot = null;
            }
        }
    }

    private Circle createEmptyDot() {
        return new Circle(10, Color.web("#000000", 0.3));
    }

    private Circle createCaptureDot() {
        Circle dot = new Circle(22, Color.TRANSPARENT);
        dot.setStroke(Color.web("#000000", 0.3));
        dot.setStrokeWidth(4);
        return dot;
    }
}
