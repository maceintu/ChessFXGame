package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public Cell[][] cells;
    private final List<BoardListener> listeners = new ArrayList<>();

    public Board(Player whitePlayer, Player blackPlayer) {
        cells = new Cell[8][8];
        for(int row = 0; row<cells.length; row++){
            for(int col = 0; col<cells.length; col++){
                cells[row][col] = new Cell(new Position(row, col));
            }
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == 1) cells[row][col].setPiece(new Pawn(whitePlayer));
                if (row == 6) cells[row][col].setPiece(new Pawn(blackPlayer));

                if (row == 0 || row == 7) {
                    Player player = (row == 0) ? whitePlayer : blackPlayer;
                    Piece piece = createHeavyPiece(player, col);
                    if (piece != null) cells[row][col].setPiece(piece);
                }
            }
        }
    }

    private Piece createHeavyPiece(Player player, int col) {
        return switch (col) {
            case 0, 7 -> new Tower(player);
            case 1, 6 -> new Knight(player);
            case 2, 5 -> new Bishop(player);
            case 3 -> new Queen(player);
            //case 4    -> new King(player, cell);
           default -> null;
       };
   }

    public Cell getCell(int row, int col){
        return cells[row][col];
    }
    public Cell getCellFromPreviousWithOffset(Cell cell, int offsetRow, int offsetCol) {
        return cells[cell.position.row() + offsetRow][cell.position.col() + offsetCol];
    }
}