package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.general.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    public Knight(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Cell> getLegalMoves(Board board, Position position) {

        List<Cell> legalMoves = new ArrayList<>();
        int[][] jumps = {{1, 2}, {-1, -2}, {-1, 2}, {1, -2}, {2, 1}, {-2, -1}, {-2, 1}, {2, -1}};
        for(int[] jump :jumps){
            Cell cell = board.getCellFromPreviousWithOffset(board.getCellFromPosition(position), jump[0], jump[1]);
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
