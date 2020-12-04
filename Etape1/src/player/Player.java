package player;

import game.Input;
import grille.Grille;

public abstract class Player{
    public int type;
    public int manche;
    public String name;

    public Player(int type, int manche, String name) {
        this.type = type;
        this.manche = manche;
        this.name = name;
    }

    public abstract int play(Input input, Grille grid);

}
