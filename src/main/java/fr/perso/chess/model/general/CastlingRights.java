package fr.perso.chess.model.general;

public record CastlingRights(
        boolean whiteKingSide,
        boolean whiteQueenSide,
        boolean blackKingSide,
        boolean blackQueenSide
) {
    public CastlingRights withWhiteRights(boolean whiteKingSide, boolean whiteQueenSide) {
        return new CastlingRights(whiteKingSide, whiteQueenSide, this.blackKingSide, this.blackQueenSide());
    }

    public CastlingRights withBlackRights(boolean blackKingSide, boolean blackQueenSide) {
        return new CastlingRights(this.whiteKingSide, this.whiteQueenSide, blackKingSide, blackQueenSide);
    }

}

