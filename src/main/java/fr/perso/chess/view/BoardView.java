package fr.perso.chess.view;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.pieces.Piece;
import javafx.scene.layout.GridPane;

import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.List;


public class BoardView extends GridPane {
    private final CellView[][] cellViews;

    public BoardView() {
        cellViews = new CellView[8][8];
        for (int r = 0; r < cellViews.length; r++) {
            for (int c = 0; c < cellViews.length; c++) {
                CellView cell = new CellView(r, c);
                cellViews[r][c] = cell;
                this.add(cell, c, r);
            }
        }
    }

    public void onBoardUpdate(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("MoveUpdate"))
            renderBoard((List<Cell>) event.getNewValue());
    }

    private void renderBoard(List<Cell> updatedCells) {
        // On parcourt les 64 cases du modèle
        for (Cell cell : updatedCells) {
            cellViews[cell.getPosition().row()][cell.getPosition().col()].drawFromCell(cell);
        }
    }

    public void initializeBoard(Board board) {
        renderBoard(Arrays.stream(board.getCells()).flatMap(Arrays::stream).toList());
    }
}