package fr.perso.chess.controller;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Position;
import fr.perso.chess.model.pieces.Piece;
import fr.perso.chess.view.BoardView;
import fr.perso.chess.view.CellView;
import fr.perso.chess.view.ImageFactory;

import java.util.Arrays;
import java.util.List;

public class GameController {

    private Board board;
    private BoardView boardView;
    private Position selectedPosition = null;
    private List<Cell> possibleMoves;

    public GameController(Board board, BoardView boardView) {
        ImageFactory.preload();
        this.board = board;
        this.boardView = boardView;
        this.boardView.initializeBoard(this.board);
        this.boardView.bindCellsClickAction(this::handlePlayerClick);
        this.board.addListener(event -> this.boardView.onBoardUpdate(event));
    }

    private void handlePlayerClick(Position clickedPosition) {
        if (selectedPosition == null) {
            Piece piece = board.getPiece(clickedPosition);
            if (piece != null && piece.getColor().equals(board.getCurrentPlayer().getColor())) {
                selectedPosition = clickedPosition;
                possibleMoves = piece.getLegalMoves(board, selectedPosition);
                boardView.showPossibleMoves(possibleMoves);
            } else {
                boardView.clearPossibleMoves(possibleMoves);
            }
        } else {
            board.movePiece(selectedPosition, clickedPosition);
            boardView.clearPossibleMoves(possibleMoves);
            selectedPosition = null;
        }
    }

}
