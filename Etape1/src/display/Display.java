package display;

import grille.Grille;
import game.Game;
import player.Player;

public class Display {
    public static void display_grid(Grille grid) {
        System.out.println("1 2 3 4 5 6 7");
        for (int i = 0; i < grid.getlineNbr(); i++) {
            for(int j = 0; j < grid.getcolumnNbr(); j++) {
                if (grid.tabCoins[i][j] == 0) {
                    System.out.print(". ");
                } else if (grid.tabCoins[i][j] == 1) {
                    System.out.print("X ");
                } else if (grid.tabCoins[i][j] == 2) {
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
    }
}
