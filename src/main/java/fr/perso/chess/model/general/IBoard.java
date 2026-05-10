package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.Piece;

import java.beans.PropertyChangeListener;

public interface IBoard {
    Piece getPiece(Position position);
    boolean movePiece(Position from, Position to);
    boolean isGameOver();
    Player getCurrentPlayer();
    void addListener(PropertyChangeListener listener);
    void removeListener(PropertyChangeListener listener);
}