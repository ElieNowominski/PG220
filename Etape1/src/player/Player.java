package player;

import grille.Grille;

public abstract class Player{
    public int type;
    int manche;

    public Player(int type, int manche) {
        this.type = type;
        this.manche = manche;
    }

    public abstract void play(Grille grid);

}
