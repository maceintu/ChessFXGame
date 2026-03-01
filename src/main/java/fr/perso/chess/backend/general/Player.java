package fr.perso.chess.backend.general;

import java.sql.Time;

public class Player {
    Player(boolean isWhite){
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
