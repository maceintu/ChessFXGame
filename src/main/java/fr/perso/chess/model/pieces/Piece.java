package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    protected Cell cell;
    private final Player player;

    public Piece(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Cell getPosition() {
        return cell;
    }

    public void setPosition(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public abstract List<Cell> getLegalMoves(Board board);


    List<Cell> getLinearLegalMoves(Board board, int[][] directions) {
        ArrayList<Cell> legalMoves = new ArrayList<>();
        for (int[] d : directions) {
            Cell next = this.cell;
            while ((next = board.getCellFromPreviousWithOffset(next, d[0], d[1])) != null) {
                Piece targetPiece = next.getPiece();
                if (targetPiece == null)
                    legalMoves.add(next);
                else {
                    if (targetPiece.getPlayer() != this.getPlayer())
                        legalMoves.add(next);
                    break;
                }
            }
        }
        return legalMoves;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + player + " at " + cell + "}";
    }
}