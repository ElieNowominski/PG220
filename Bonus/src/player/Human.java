package player;

import game.Input;
import game.Log;

public class Human extends Player {

    public Human(int type, int round, String name) {
        super(type,round,name);
    }

    @Override
    public int play(Input input, int columnNbr, Log hist) {
        int column = input.handleCoinInput(columnNbr,hist);
        return column;
    }
}
