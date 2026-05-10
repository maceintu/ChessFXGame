package fr.perso.chess.controller;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.view.BoardView;
import fr.perso.chess.view.CellView;

public class GameController {

    private Board board;
    private BoardView boardView;

    public GameController(Board board, BoardView boardView) {
        this.board = board;
        this.boardView = boardView;
        this.boardView.initializeBoard(this.board);
        this.board.addListener(event -> this.boardView.onBoardUpdate(event));    }

}
