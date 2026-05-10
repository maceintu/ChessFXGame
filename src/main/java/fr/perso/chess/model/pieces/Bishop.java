package fr.perso.chess.model.pieces;
import fr.perso.chess.model.general.PlayerColor;

public class Bishop extends Piece {
    public Bishop(PlayerColor color) {
        super(color);
    }

//    @Override
//    public List<Cell> getLegalMoves(Board board) {
//        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
//        return this.getLinearLegalMoves(board, directions);
//    }
}

