package player;

import grille.CoinType;
import grille.Grille;

public abstract class Player extends CoinType {

    public Player(int type) {
        super(type);
    }

    public abstract void play(Grille grid);

}
