package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Board implements IBoard {
    private final PropertyChangeSupport pcs;
    private final Cell[][] cells;
    private final Stack<Move> moveStack;
    Player whitePlayer;
    Player blackPlayer;
    Player currentPlayer;

    public Board() {
        this.moveStack = new Stack<>();
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
            case 4 -> new King(color);
            default -> null;
        };
    }

    public Cell getCellFromPreviousWithOffset(Cell cell, int offsetRow, int offsetCol) {
        int newRow = cell.getPosition().row() + offsetRow;
        int newCol = cell.getPosition().col() + offsetCol;
        if (newRow >= 8 || newCol >= 8 || newRow < 0 || newCol < 0) {
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

    private Move makeMove(Position from, Position to) {
        Cell fromCell = this.getCellFromPosition(from);
        Cell toCell = this.getCellFromPosition(to);
        Piece pieceToMove = fromCell.getPiece();
        Piece capturedPiece = toCell.getPiece();
        toCell.setPiece(pieceToMove);
        fromCell.setPiece(null);
        return new Move(from, to, pieceToMove, capturedPiece);
    }

    private void undoMove(Move move) {
        getCellFromPosition(move.from()).setPiece(move.movedPiece());
        getCellFromPosition(move.to()).setPiece(move.capturedPiece());
    }

    @Override
    public boolean movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        if (piece == null)
            return false;
        if (getLegalMoves(piece, from).stream().map(Cell::getPosition).toList().contains(to)) {
            Move move = makeMove(from, to);
            this.moveStack.add(move);
            switchPlayer();
            pcs.firePropertyChange("CellsUpdated", null, List.of(getCellFromPosition(from), getCellFromPosition(to)));
            return true;
        }
        return false;
    }

    public boolean undoLastMove() {
        if (moveStack.isEmpty()) {
            return false;
        }
        Move lastMove = moveStack.pop();
        undoMove(lastMove);
        switchPlayer();
        pcs.firePropertyChange("CellsUpdated", null, List.of(
                getCellFromPosition(lastMove.from()),
                getCellFromPosition(lastMove.to())
        ));
        return true;
    }

    public List<Cell> getLegalMoves(Piece piece, Position position) {
        List<Cell> possibleMoves = piece.getPossibleMoves(this, position);
        List<Cell> legalMoves = new ArrayList<>();
        for (Cell destinationCell : possibleMoves) {
            Move move = makeMove(position, destinationCell.getPosition());
            if (!isCurrentPlayerChecked()) {
                legalMoves.add(destinationCell);
            }
            undoMove(move);
        }
        return legalMoves;
    }


    public void switchPlayer() {
        currentPlayer = currentPlayer.equals(whitePlayer) ? blackPlayer : whitePlayer;
    }

    public boolean isPlayerChecked(Player player) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Cell currentCell = this.cells[row][col];
                Piece piece = currentCell.getPiece();
                if (piece != null && piece.getColor() != player.getColor()) {
                    List<Cell> threatenedCells = piece.getPossibleMoves(this, currentCell.getPosition());
                    for (Cell target : threatenedCells) {
                        if (target.getPiece() instanceof King) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isCurrentPlayerChecked() {
        return isPlayerChecked(currentPlayer);
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
        this.pcs.removePropertyChangeListener(listener);
    }
}
