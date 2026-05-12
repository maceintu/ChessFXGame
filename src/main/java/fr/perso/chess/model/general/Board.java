package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Board implements IBoard {
    private final PropertyChangeSupport pcs;


    private Cell[][] cells;
    Player whitePlayer;
    Player blackPlayer;
    Player currentPlayer;


    public Board() {
        this.pcs = new PropertyChangeSupport(this);
        whitePlayer = new Player(PlayerColor.WHITE);
        blackPlayer = new Player(PlayerColor.BLACK);
        currentPlayer = whitePlayer;
        cells = new Cell[8][8];
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                cells[row][col] = new Cell(new Position(row, col));
            }
        }
        for (int i = 0; i < 8; i++) {
            cells[0][i].setPiece(createHeavyPiece(PlayerColor.BLACK, i));
            cells[1][i].setPiece(new Pawn(PlayerColor.BLACK));
            cells[6][i].setPiece(new Pawn(PlayerColor.WHITE));
            cells[7][i].setPiece(createHeavyPiece(PlayerColor.WHITE, i));
        }
    }

    private Piece createHeavyPiece(PlayerColor color, int col) {
        return switch (col) {
            case 0, 7 -> new Tower(color);
            case 1, 6 -> new Knight(color);
            case 2, 5 -> new Bishop(color);
            case 3 -> new Queen(color);
            //case 4    -> new King(player, cell);
            default -> null;
        };
    }

    public Cell getCellFromPreviousWithOffset(Cell cell, int offsetRow, int offsetCol) {
        int newRow = cell.getPosition().row() + offsetRow;
        int newCol = cell.getPosition().col() + offsetCol;
        if (newRow >= 8 || newCol >= 8 || newRow < 0 || newCol < 0) {
            System.out.println("index non valide sur le board");
            return null;
        }
        return cells[newRow][newCol];
    }

    public Cell getCellFromPosition(Position position) {
        return this.cells[position.row()][position.col()];
    }

    public Cell[][] getCells() {
        return cells;
    }

    @Override
    public Piece getPiece(Position position) {
        return cells[position.row()][position.col()].getPiece();
    }

    @Override
    public boolean movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        if (piece == null)
            return false;
        if (piece.getLegalMoves(this, from).stream().map(Cell::getPosition).toList().contains(to)) {
            Cell fromCell = this.getCellFromPosition(from);
            Cell toCell = this.getCellFromPosition(to);
            fromCell.setPiece(null);
            toCell.setPiece(piece);
            switchPlayer();
            pcs.firePropertyChange("CellsUpdated", null, List.of(fromCell, toCell));
        }
        return false;
    }

    public void switchPlayer(){
        currentPlayer = currentPlayer.equals(whitePlayer) ? blackPlayer : whitePlayer;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
    }
}
