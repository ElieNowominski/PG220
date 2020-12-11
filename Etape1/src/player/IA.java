package player;

import grid.Grid;
import game.Input;
import java.util.Random;

public class IA extends Player {

    public IA(int type, int round, String name){
        super(type,round,name);
    }

    @Override
    public int play(Input input, Grid grid) {
        Random random = new Random();
        int column = 1+random.nextInt(grid.getColumnNbr());
        return column;
    }
}
