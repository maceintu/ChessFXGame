package fr.perso.chess.model.general;

public interface BoardListener {
    void onPieceMoved(Position from, Position to);
}
