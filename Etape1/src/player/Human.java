package player;


import display.Display;
import game.Input;
import grille.Grille;

public class Human extends Player {

    public Human(int type, int manche, String name) {
        super(type,manche,name);
    }

    @Override
    public void play(Grille grid) {
        System.out.println("Saisissez une colonne :");
        System.out.print("$");
        Input input = Input.handleCoinInput(grid.getColumnNbr());
        grid.playCoin(input.getColumn(),grid.tabCoins, this.type);
        Display.display_grid(grid);
    }
}
