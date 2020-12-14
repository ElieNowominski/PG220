package player;

import game.Input;
import game.Log;

public class Human extends Player {

    public Human(int type, int round, String name) {
        super(type,round,name);
    }

    @Override
    public int play(Input input, int columnNbr, Log hist) {
        System.out.println("Saisissez une colonne :");
        System.out.print("$");
        int column = input.handleCoinInput(columnNbr,hist);
        return column;
    }
}
