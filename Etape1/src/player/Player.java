package player;

import grille.CoinType;

public abstract class Player extends CoinType {

    public Player(int type) {
        super(type);
    }

    public abstract int play();
}
