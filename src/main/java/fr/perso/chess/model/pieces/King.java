package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.*;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Cell> getPossibleMoves(Board board, Position position) {
        List<Cell> possibleMoves = new ArrayList<>();
        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            Cell cell = board.getCellFromPreviousWithOffset(board.getCellFromPosition(position), dir[0], dir[1]);
            if (cell == null)
                continue;
            Piece targetPiece = cell.getPiece();
            if (targetPiece != null && targetPiece.getColor().equals(this.getColor())) {
                continue;
            }
            possibleMoves.add(cell);
        }
        // gestion rock
        int row = this.getColor() == PlayerColor.WHITE ? 7 : 0;
        if (position.row() == row && position.col() == 4) {
            CastlingRights rights = board.getCastlingRights();
            boolean canKingSide = this.getColor() == PlayerColor.WHITE ? rights.whiteKingSide() : rights.blackKingSide();
            boolean canQueenSide = this.getColor() == PlayerColor.WHITE ? rights.whiteQueenSide() : rights.blackQueenSide();
            if (canKingSide
                    && board.getCellFromPosition(new Position(row, 5)).getPiece() == null
                    && board.getCellFromPosition(new Position(row, 6)).getPiece() == null)
                possibleMoves.add(board.getCellFromPosition(new Position(row, 6)));
            if (canQueenSide
                    && board.getCellFromPosition(new Position(row, 1)).getPiece() == null
                    && board.getCellFromPosition(new Position(row, 2)).getPiece() == null
                    && board.getCellFromPosition(new Position(row, 3)).getPiece() == null)
                possibleMoves.add(board.getCellFromPosition(new Position(row, 2)));
        }
        return possibleMoves;
    }

    @Override
    public String getName() {
        return "King";
    }
}
