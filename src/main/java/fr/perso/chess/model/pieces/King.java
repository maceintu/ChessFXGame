package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.general.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Cell> getPossibleMoves(Board board, Position position) {
        List<Cell> legalMoves = new ArrayList<>();
        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : directions){
            Cell cell = board.getCellFromPreviousWithOffset(board.getCellFromPosition(position), dir[0], dir[1]);
            if(cell == null)
                continue;
            Piece targetPiece = cell.getPiece();
            if (targetPiece != null && targetPiece.getColor().equals(this.getColor())){
                continue;
            }
            legalMoves.add(cell);
        }
        return legalMoves;
    }
}
