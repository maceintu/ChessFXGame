package fr.perso.chess.controller;

import fr.perso.chess.model.general.*;
import fr.perso.chess.model.pieces.Piece;
import fr.perso.chess.view.BoardView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button; // N'oublie pas l'import

import java.util.List;

public class LocalMatchController {

    private final Board board;
    private final BoardView boardView;
    private Position selectedPosition = null;
    private List<Cell> possibleMoves;

    public LocalMatchController(Board board, BoardView boardView, Button undoButton) {
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
                boardView.showPossibleMoves(possibleMoves);
            }
        } else {
            boolean moveDone = board.movePiece(selectedPosition, clickedPosition);
            boardView.clearPossibleMoves(possibleMoves);
            selectedPosition = null;
            if (moveDone) {
                checkAndHandleGameEnd();
            }
        }
    }

    private void checkAndHandleGameEnd() {
        GameStatus status = board.checkGameStatus();

        if (status != GameStatus.ACTIVE) {
            showGameOverPopup(status);
        }
    }

    private void showGameOverPopup(GameStatus status) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("End of game");
        alert.setHeaderText(null);
        switch (status) {
            case CHECKMATE -> alert.setContentText("Check mate,  " + (board.getCurrentPlayer().getColor().equals(PlayerColor.WHITE) ? "Black" : "White") + " Wins.");
            case STALEMATE -> alert.setContentText("Draw : Stale Mate");
            case DRAW_FIFTY_MOVES -> alert.setContentText("Draw : 50 coups");
        }
        alert.showAndWait();
    }
}