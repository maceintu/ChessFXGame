package fr.perso.chess.backend.pieces;

import fr.perso.chess.backend.general.Board;
import fr.perso.chess.backend.general.Cell;
import fr.perso.chess.backend.general.Player;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    public Knight(Player player, Cell cell) {
        super(player, cell);
    }

    @Override
    public List<Cell> getLegalMoves(Board board) {

        List<Cell> legalMoves = new ArrayList<>();
        int[][] jumps = {{1, 2}, {-1, -2}, {-1, 2}, {1, -2}, {2, 1}, {-2, -1}, {-2, 1}, {2, -1}};
        for(int[] jump :jumps){
            Cell cell = board.getCellFromPreviousWithOffset(this.cell, jump[0], jump[1]);
            if(cell == null)
                continue;
            if (cell.getPiece() != null && cell.getPiece().getPlayer() == this.getPlayer()){
                continue;
            }
            legalMoves.add(cell);
        }
        return legalMoves;
    }
}
