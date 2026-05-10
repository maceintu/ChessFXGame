package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Player;
import fr.perso.chess.model.general.PlayerColor;

import java.util.List;

public class Tower extends Piece {
    public Tower(PlayerColor color) {
        super(color);
    }

//    @Override
//    public List<Cell> getLegalMoves(Board board) {
//        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//        return this.getLinearLegalMoves(board, directions);
//    }
}
