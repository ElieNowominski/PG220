package display;

import grille.Grille;
import game.Game;
import player.Player;

public class Display {
    public static void display_grid(Grille grid) {
        System.out.println("1 2 3 4 5 6 7");

        for (int i = 0; i < grid.getcolumnLength()*grid.getlineLength(); i++) {
            if (i%grid.getlineLength()==0 && i!=0) {
                System.out.println("");
            }
            if (grid.tabCoins[i].getType() == 0) {
                System.out.print(". ");
            } else if (grid.tabCoins[i].getType() == 1) {
                System.out.print("X ");
            } else if (grid.tabCoins[i].getType() == 2) {
                System.out.print("O ");
            }
        }
    }
}
