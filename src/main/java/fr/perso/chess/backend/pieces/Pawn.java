package fr.perso.chess.backend.pieces;

import fr.perso.chess.backend.general.Board;
import fr.perso.chess.backend.general.Cell;
import fr.perso.chess.backend.general.Player;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(Player player, Cell cell) {
        super(player, cell);
    }

    @Override
    public List<Cell> getLegalMoves(Board board) {
        List<Cell> legalMoves = new ArrayList<>();

        int direction = this.getPlayer().isWhite() ? -1 : 1;
        int startRow = this.getPlayer().isWhite() ? 6 : 1; //

        Cell forward1 = board.getCellFromPreviousWithOffset(this.cell, direction, 0);
        if (forward1 != null && forward1.getPiece() == null) {
            legalMoves.add(forward1);
            if (this.cell.position.row() == startRow) {
                Cell forward2 = board.getCellFromPreviousWithOffset(this.cell, (2 * direction), 0);
                if (forward2 != null && forward2.getPiece() == null) {
                    legalMoves.add(forward2);
                }
            }
        }

        Cell diag1 = board.getCellFromPreviousWithOffset(this.cell, direction,  1);
        if (diag1 != null && diag1.getPiece() != null && diag1.getPiece().getPlayer() != this.getPlayer())
            legalMoves.add(diag1);
        Cell diag2 = board.getCellFromPreviousWithOffset(this.cell, direction,  - 1);
        if (diag2 != null && diag2.getPiece() != null && diag2.getPiece().getPlayer() != this.getPlayer())
            legalMoves.add(diag2);

        return legalMoves;
    }
}
