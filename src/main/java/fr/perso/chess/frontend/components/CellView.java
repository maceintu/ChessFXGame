package fr.perso.chess.frontend.components;

import fr.perso.chess.backend.general.Board;
import fr.perso.chess.backend.general.Cell;
import fr.perso.chess.backend.pieces.Piece;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public class CellView extends StackPane {

    private final Cell cell;
    private final Circle dot = new Circle(10, Color.web("#000000", 0.3)); // Noir semi-transparent

    public CellView(Cell cell) {
        this.cell = cell;

        // 1. Définition de la couleur de fond
        int r = cell.position.row();
        int c = cell.position.col();
        Color bgColor = (r + c) % 2 == 0 ? Color.BEIGE : Color.BROWN;
        this.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));

        this.setOnMousePressed(e -> handlePress());

        cell.pieceProperty().addListener((obs, oldP, newP) -> updatePieceGraphic(newP));

        updatePieceGraphic(cell.getPiece());
    }

    private void handlePress() {
        Piece piece = cell.getPiece();
        if (this.getParent() instanceof BoardView parent) {
            parent.clearHints();
            if (piece != null) {
                Board board = parent.getBoardBackend();
                List<Cell> possibleMoves = piece.getLegalMoves(board);
                for (Cell targetCell : possibleMoves) {
                    parent.showHintOn(targetCell);
                }
            }
        }
    }

    /**
     * Met à jour le visuel de la pièce (ajout/suppression de PieceView).
     */
    private void updatePieceGraphic(Piece piece) {
        // Supprime l'ancienne vue de pièce si elle existe
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