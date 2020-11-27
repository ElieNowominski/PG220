package player;

import display.Display;
import player.Player;
import grille.Grille;
import game.Input;
import java.util.Random;

public class IA extends Player {
    String name;

    public IA(int type, String name){
        super(type);
        this.name = name;
    }

    @Override
    public void play(Grille grid) {
        Random random = new Random();
        grid.playCoin(1+random.nextInt(grid.getColumnNbr()),grid.tabCoins, this.type);
        Display.display_grid(grid);

    }
}
