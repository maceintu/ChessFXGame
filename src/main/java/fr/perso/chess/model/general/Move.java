package fr.perso.chess.model.general;

import fr.perso.chess.model.pieces.Piece;

public record Move(
        Position from,
        Position to,
        Piece movedPiece,
        Piece capturedPiece,
        boolean isDoublePawnPush,
        boolean isEnPassant,
        boolean isCastling,
        CastlingRights castlingRights
) {

    public boolean isCapture() {
        return capturedPiece != null || isEnPassant;
    }
}