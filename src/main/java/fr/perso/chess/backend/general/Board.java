package fr.perso.chess.backend.general;

import fr.perso.chess.backend.pieces.*;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Player whitePlayer;
    private Player blackPlayer;
    public Map<Position, Cell> cellMap;

    public Board() {
        this.cellMap = new HashMap<>();
        whitePlayer = new Player(true);
        blackPlayer = new Player(false);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position pos = new Position(row, col);
                Cell cell = new Cell(pos);
                if (row == 1) cell.setPiece(new Pawn(whitePlayer, cell));
                if (row == 6) cell.setPiece(new Pawn(blackPlayer, cell));

                if (row == 0 || row == 7) {
                    Player player = (row == 0) ? whitePlayer : blackPlayer;
                    Piece piece = createHeavyPiece(player, cell, col);
                    if (piece != null) cell.setPiece(piece);
                }
                this.cellMap.put(pos, cell);
            }
        }
    }

    private Piece createHeavyPiece(Player player, Cell cell, int col) {
        return switch (col) {
            case 0, 7 -> new Tower(player, cell);
            case 1, 6 -> new Knight(player, cell);
            case 2, 5 -> new Bishop(player, cell);
            case 3 -> new Queen(player, cell);
            //case 4    -> new King(player, cell);
            default -> null;
        };
    }

    public Cell getCellFromPreviousWithOffset(Cell cell, int offsetRow, int offsetCol) {
        int currentRow = cell.position.row();
        int currentCol = cell.position.col();
        return cellMap.get(new Position(currentRow + offsetRow, currentCol + offsetCol));
    }
}