package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.Piece;

public interface IBoard {

    void initialize();
    Piece getPiece(Position position);
    boolean isEmpty(Position position);
    boolean isGameOver();
    void addListener(BoardListener listener);
    void removeListener(BoardListener listener);
}