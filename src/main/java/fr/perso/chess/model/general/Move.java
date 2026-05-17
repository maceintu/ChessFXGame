package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.Piece;

public record Move(
        Position from,
        Position to,
        Piece movedPiece,
        Piece capturedPiece,
        boolean isDoublePawnPush,
        boolean isEnPassant,
        boolean isCastling
) {

    public Move(Position from, Position to, Piece movedPiece, Piece capturedPiece) {
        this(from, to, movedPiece, capturedPiece, false, false, false);
    }

    public boolean isCapture() {
        return capturedPiece != null || isEnPassant;
    }
}