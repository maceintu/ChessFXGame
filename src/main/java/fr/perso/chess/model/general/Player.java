package fr.perso.chess.model.general;

import java.sql.Time;

public class Player {
    public Player(boolean isWhite){
        this.white = isWhite;
    };
    private final boolean white;
    private boolean check = false;
    private Time leftTime;

    public boolean isCheck() {
        return check;
    }

    public boolean isWhite() {
        return white;
    }
}
