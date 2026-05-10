package fr.perso.chess.model.general;

public class Player {
    public Player(PlayerColor color) {
        this.color = color;
        this.time = Long.MAX_VALUE;
        this.check = false;
    }

    private PlayerColor color;
    private long time;
    boolean check;

    public boolean isCheck() {
        return check;
    }

    public PlayerColor getColor(){
        return this.color;
    }
}
