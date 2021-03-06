package player;

import game.Input;
import game.Log;

public abstract class Player{
    public int type;
    public int round;
    public String name;

    public Player(int type, int round, String name) {
        this.type = type;
        this.round = round;
        this.name = name;
    }
    public abstract int play(Input input, int columnNbr, Log hist);
}
