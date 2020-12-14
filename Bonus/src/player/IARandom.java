package player;

import game.Input;
import game.Log;

import java.util.Random;

public class IARandom extends IA{
    public IARandom(int type, int round, String name){
        super(type,round,name);
    }

    public int play(Input input, int columnNbr, Log hist) {
        Random random = new Random();
        int column = 1+random.nextInt(columnNbr);
        return column;
    }
}
