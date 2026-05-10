package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.general.Position;

import java.util.List;


public class Queen extends Piece {
    public Queen(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Cell> getLegalMoves(Board board, Position position) {
        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        return this.getLinearLegalMoves(board, position, directions);
    }
}
