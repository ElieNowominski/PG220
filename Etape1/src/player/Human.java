package player;


import display.Display;
import game.Input;
import grille.Grille;

public class Human extends Player {

    public Human(int type, int manche, String name) {
        super(type,manche,name);
    }

    @Override
    public int play(Input input, int columnNbr) {
        System.out.println("Saisissez une colonne :");
        System.out.print("$");
        int column = input.handleCoinInput(columnNbr);
        return column;
    }
}
