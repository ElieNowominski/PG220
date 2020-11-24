package game;

import display.Display;
import player.Player;
import grille.Grille;

import java.util.Arrays;

public class Game {
    public static void main(String[] args) {
        System.out.println("Joueur1?");
        Grille grid = new Grille(6, 7);
        String type = Grille.handle_input();
        String name = Grille.handle_input();

        Player p1 = Grille.handle_type(type,name,1);

        System.out.println("Joueur2?");

        String type2 = Grille.handle_input();
        String name2 = Grille.handle_input();

        Player p2 = Grille.handle_type(type2,name2,2);


        Display.display_grid(grid);

    }
}
