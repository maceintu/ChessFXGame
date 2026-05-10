package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.Piece;

public class Cell {
    Cell(Position position) {
        this.position = position;
    }

    private Position position;
    private Piece piece;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

}
