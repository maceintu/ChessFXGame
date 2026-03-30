package fr.perso.chess.controller;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.view.BoardView;
import fr.perso.chess.view.CellView;

public class GameController {

    private final Board board;
    private CellView[][] cellViews;

    public GameController(Board board, BoardView boardView) {
        this.board = board;
        cellViews = boardView.getAllCellViews();
        for (int r = 0; r < cellViews.length; r++) {
            for (int c = 0; c < cellViews.length; c++) {
                Cell cell = board.getCell(r, c);
                CellView cellView = new CellView(r, c);
                cellViews[r][c] = cellView;
                boardView.add(cellView, c, r);
            }
        }
    }

    private void onCellPressed(Cell cell) {
    }

}
