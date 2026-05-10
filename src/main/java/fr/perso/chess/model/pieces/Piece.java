package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;

import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.general.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private final PlayerColor color;

    public Piece(PlayerColor color) {
        this.color = color;
    }

    public PlayerColor getColor() {
        return color;
    }

    public List<Cell> getLinearLegalMoves(Board board, Position position, int[][] directions) {
        ArrayList<Cell> legalMoves = new ArrayList<>();
        for (int[] d : directions) {
            Cell next = board.getCellFromPosition(position);
            while ((next = board.getCellFromPreviousWithOffset(next, d[0], d[1])) != null) {
                Piece targetPiece = next.getPiece();
                if (targetPiece == null)
                    legalMoves.add(next);
                else {
                    if (!targetPiece.getColor().equals(this.getColor()))
                        legalMoves.add(next);
                    break;
                }
            }
        }
        return legalMoves;
    }

    public abstract List<Cell> getLegalMoves(Board board, Position position);
}

