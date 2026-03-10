package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Player;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(Player player) {
        super(player);
    }

    @Override
    public List<Cell> getLegalMoves(Board board) {
        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        return this.getLinearLegalMoves(board, directions);
    }
}

