package grille;

public class Coin extends CoinType{
    int x;
    int y;

    public Coin(int type, int x, int y){
        super(type);
        this.x = x;
        this.y = y;
    }

}
