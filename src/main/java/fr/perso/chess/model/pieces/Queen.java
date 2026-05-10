package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.PlayerColor;


public class Queen extends Piece {
    public Queen(PlayerColor color) {
        super(color);
    }

//    @Override
//    public List<Cell> getLegalMoves(Board board) {
//        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//        return this.getLinearLegalMoves(board, directions);
//    }
}
