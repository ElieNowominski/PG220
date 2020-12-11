package player;

import game.Input;
import grid.Grid;

public class Human extends Player {

    public Human(int type, int round, String name) {
        super(type,round,name);
    }

    @Override
    public int play(Input input, int columnNbr) {
        System.out.println("Saisissez une colonne :");
        System.out.print("$");
        int column = input.handleCoinInput(columnNbr);
        return column;
    }
}
