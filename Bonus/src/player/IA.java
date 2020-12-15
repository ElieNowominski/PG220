package player;

import game.Log;
import game.Input;
import java.util.Random;

public abstract class IA extends Player {

    public IA(int type, int round, String name){
        super(type,round,name);
    }

    public abstract int play(Input input, int columnNbr, Log hist);

}
