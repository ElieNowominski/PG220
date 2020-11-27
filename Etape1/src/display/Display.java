package display;

import grille.Grille;
import game.Game;
import player.Player;

public class Display {
    public static void display_grid(Grille grid) {
        for(int i=1; i<=grid.getColumnNbr(); i++){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < grid.getLineNbr(); i++) {
            for(int j = 0; j < grid.getColumnNbr(); j++) {
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
