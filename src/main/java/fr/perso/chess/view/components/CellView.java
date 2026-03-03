package fr.perso.chess.view.components;

import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.pieces.Piece;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.function.Consumer;

public class CellView extends StackPane {

    private final Cell cell;
    private final Circle dot = new Circle(10, Color.web("#000000", 0.3));

    public CellView(Cell cell, Consumer<Cell> onCellPressed) {
        this.cell = cell;

        int r = cell.position.row();
        int c = cell.position.col();
        Color bgColor = (r + c) % 2 == 0 ? Color.BEIGE : Color.BROWN;
        this.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));

        this.setOnMousePressed(e -> onCellPressed.accept(cell));

        cell.pieceProperty().addListener((obs, oldP, newP) -> updatePieceGraphic(newP));

        updatePieceGraphic(cell.getPiece());
    }

    private void updatePieceGraphic(Piece piece) {
        this.getChildren().removeIf(node -> node instanceof PieceView);
        if (piece != null) {
            this.getChildren().add(new PieceView(piece));
        }
    }

    public void showDot(boolean visible) {
        if (visible) {
            if (!this.getChildren().contains(dot)) {
                this.getChildren().add(dot);
            }
        } else {
            this.getChildren().remove(dot);
        }
    }
}