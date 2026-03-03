package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.Piece;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Cell {
    Cell(Position position){
        this.position = position;
    }

    public Position position;
    private final ObjectProperty<Piece> pieceProperty = new SimpleObjectProperty<>(null);
    public ObjectProperty<Piece> pieceProperty() { return pieceProperty; }

    public void setPiece(Piece piece) {
        this.pieceProperty.set(piece);
        if(piece != null)
            piece.setPosition(this);
    }
    public Piece getPiece() { return this.pieceProperty.get(); }
}
