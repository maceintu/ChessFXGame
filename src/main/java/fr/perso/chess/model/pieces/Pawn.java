package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Cell> getPossibleMoves(Board board, Position position) {
        List<Cell> legalMoves = new ArrayList<>();
        int direction = this.getColor().equals(PlayerColor.BLACK) ? 1 : -1;
        int startRow = this.getColor().equals(PlayerColor.BLACK) ? 1 : 6;
        Cell currentCell = board.getCellFromPosition(position);
        Cell forward1 = board.getCellFromPreviousWithOffset(currentCell, direction, 0);
        if (forward1 != null && forward1.getPiece() == null) {
            legalMoves.add(forward1);
            if (position.row() == startRow) {
                Cell forward2 = board.getCellFromPreviousWithOffset(currentCell, (2 * direction), 0);
                if (forward2 != null && forward2.getPiece() == null) {
                    legalMoves.add(forward2);
                }
            }
        }
        Cell diag1 = board.getCellFromPreviousWithOffset(currentCell, direction, 1);
        if (diag1 != null && diag1.getPiece() != null && !diag1.getPiece().getColor().equals(this.getColor()))
            legalMoves.add(diag1);
        Cell diag2 = board.getCellFromPreviousWithOffset(currentCell, direction, -1);
        if (diag2 != null && diag2.getPiece() != null && !diag2.getPiece().getColor().equals(this.getColor()))
            legalMoves.add(diag2);
        return legalMoves;
    }
}
