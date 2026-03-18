package fr.perso.chess.controller;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.view.components.BoardView;
import fr.perso.chess.view.components.CellView;

public class GameController {

    private final Board board;

    public GameController(Board board, BoardView boardView) {
        this.board = board;
        CellView[][] cellViews = boardView.getAllCellViews();
        for (int r = 0; r < cellViews.length; r++) {
            for (int c = 0; c < cellViews.length; c++) {
                Cell cell = board.getCell(r, c);
                CellView cellView = new CellView(cell, this::onCellPressed);
                cellViews[r][c] = cellView;
                boardView.add(cellView, c, r);
            }
        }
    }

    private void onCellPressed(Cell cell) {
    }

}
