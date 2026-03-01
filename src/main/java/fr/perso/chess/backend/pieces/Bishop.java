package fr.perso.chess.backend.pieces;

import fr.perso.chess.backend.general.Board;
import fr.perso.chess.backend.general.Cell;
import fr.perso.chess.backend.general.Player;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(Player player, Cell cell) {
        super(player, cell);
    }

    @Override
    public List<Cell> getLegalMoves(Board board) {
        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        return this.getLinearLegalMoves(board, directions);
    }
}

