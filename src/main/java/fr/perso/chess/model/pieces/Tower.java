package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.general.Position;

import java.util.List;

public class Tower extends Piece {
    public Tower(PlayerColor color) {
        super(color);
    }

    @Override
    public List<Cell> getPossibleMoves(Board board, Position position) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        return getLinearMoves(board, position, directions);
    }

    @Override
    public String getName() {
        return "Tower";
    }
}
