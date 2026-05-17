package fr.perso.chess.controller;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Position;
import fr.perso.chess.model.pieces.Piece;
import fr.perso.chess.view.BoardView;
import fr.perso.chess.view.ImageFactory;
import javafx.scene.control.Button; // N'oublie pas l'import

import java.util.List;

public class LocalMatchController {

    private final Board board;
    private final BoardView boardView;
    private Position selectedPosition = null;
    private List<Cell> possibleMoves;

    public LocalMatchController(Board board, BoardView boardView, Button undoButton) {
        ImageFactory.preload();
        this.board = board;
        this.boardView = boardView;
        this.boardView.initializeBoard(this.board);
        this.boardView.bindCellsClickAction(this::handlePlayerClick);
        this.board.addListener(this.boardView::onBoardUpdate);
        undoButton.setOnAction(event -> handleUndoAction());
    }

    private void handleUndoAction() {
        boolean success = board.undoLastMove();
        if (success) {
            if (possibleMoves != null) {
                boardView.clearPossibleMoves(possibleMoves);
            }
            selectedPosition = null;
            possibleMoves = null;
        }
    }

    private void handlePlayerClick(Position clickedPosition) {
        if (selectedPosition == null) {
            Piece piece = board.getPiece(clickedPosition);
            if (piece != null && piece.getColor().equals(board.getCurrentPlayer().getColor())) {
                selectedPosition = clickedPosition;
                possibleMoves = board.getLegalMoves(piece, clickedPosition);
                boardView.showPossibleMoves(possibleMoves);}
        } else {
            boolean moveDone = board.movePiece(selectedPosition, clickedPosition);
            boardView.clearPossibleMoves(possibleMoves);
            selectedPosition = null;
        }
    }
}