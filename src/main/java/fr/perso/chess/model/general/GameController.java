package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.Piece;

import java.util.List;
import java.util.function.Consumer;

public class GameController {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;
    private Cell selectedCell;
    private Consumer<List<Cell>> onMovesAvailable;

    public GameController() {
        this.whitePlayer = new Player(true);
        this.blackPlayer = new Player(false);
        this.board = new Board(whitePlayer, blackPlayer);
        this.currentPlayer = whitePlayer;
        this.selectedCell = null;
    }

    public void onCellPressed(Cell cell) {
        if (onMovesAvailable == null) return;
        Piece piece = cell.getPiece();
        if (piece != null && piece.getPlayer().equals(currentPlayer))
            selectedCell = cell.equals(selectedCell) ? null : cell;
        else if (selectedCell != null) {
            List<Cell> legalMoves = selectedCell.getPiece().getLegalMoves(board);

            if (legalMoves.contains(cell)) {
                cell.setPiece(selectedCell.getPiece());
                selectedCell.setPiece(null);
                currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
            }
            selectedCell = null;
        }

        List<Cell> legalMoves = (selectedCell != null) ? selectedCell.getPiece().getLegalMoves(board) : List.of();
        onMovesAvailable.accept(legalMoves);
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setOnMovesAvailable(Consumer<List<Cell>> callback) {
        onMovesAvailable = callback;
    }
}
