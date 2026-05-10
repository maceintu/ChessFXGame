package fr.perso.chess.model.pieces;

import fr.perso.chess.model.general.Board;
import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.Player;
import fr.perso.chess.model.general.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private final PlayerColor color;

    public Piece(PlayerColor color) {
        this.color = color;
    }

    public PlayerColor getColor() {
        return color;
    }
}