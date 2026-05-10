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

    public Cell[][] getCells() {
        return cells;
    }

    @Override
    public Piece getPiece(Position position) {
        return null;
    }

    @Override
    public boolean movePiece(Position from, Position to) {
        return false;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public Player getCurrentPlayer() {
        return null;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
    }
}
