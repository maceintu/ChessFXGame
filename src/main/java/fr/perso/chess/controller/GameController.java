package fr.perso.chess.controller;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Position;
import fr.perso.chess.view.BoardView;
import fr.perso.chess.view.CellView;

import java.util.Arrays;

public class GameController {

    private Board board;
    private BoardView boardView;
    private Position selectedPosition = null;

    public GameController(Board board, BoardView boardView) {
        this.board = board;
        this.boardView = boardView;
        this.boardView.initializeBoard(this.board);
        this.boardView.bindCellsClickAction(this::handlePlayerClick);
        this.board.addListener(event -> this.boardView.onBoardUpdate(event));
    }

    private void handlePlayerClick(Position clickedPosition) {
        if (selectedPosition == null) {
            if (board.getPiece(clickedPosition) != null) {
                selectedPosition = clickedPosition;
                this.boardView.getCellViews()[selectedPosition.row()][selectedPosition.col()].showDot(true);
            }
        } else {
            board.movePiece(selectedPosition, clickedPosition);
            selectedPosition = null;
        }
    }

}
