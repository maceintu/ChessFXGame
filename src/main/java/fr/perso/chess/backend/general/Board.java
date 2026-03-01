package fr.perso.chess.backend.general;

import fr.perso.chess.backend.pieces.Knight;
import fr.perso.chess.backend.pieces.Pawn;
import fr.perso.chess.backend.pieces.Queen;
import fr.perso.chess.backend.pieces.Tower;

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
                if(row==1 || row==2){
                    Knight pawn = new Knight(blackPlayer, cell);
                    cell.setPiece(pawn);
                } else if (row == 6) {
                    Queen pawn = new Queen(whitePlayer, cell);
                    cell.setPiece(pawn);
                } else if(row == 4 && col == 4){
                    Knight knight = new Knight(whitePlayer, cell);
                    cell.setPiece(knight);
                }
                this.cellMap.put(pos, cell);
            }
        }
    }

    public Cell getCellFromPreviousWithOffset(Cell cell, int offsetRow, int offsetCol){
        int currentRow = cell.position.row();
        int currentCol = cell.position.col();
        return cellMap.get(new Position(currentRow + offsetRow, currentCol + offsetCol));
    }
}