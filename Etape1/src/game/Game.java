package game;

import display.Display;
import player.Human;
import player.IA;
import player.Player;
import grille.Grille;


public class Game {
    public static void main(String[] args) {
        int turn = 0;
        Grille grid = new Grille(7, 6);
        System.out.println("Joueur 1?");
        Input input = Input.handleInput();
        // System.out.println("" + input.getName());  // test si les infos sont bien recupérées
        // System.out.println("" + input.getType());

        Player p1 = handleType(input.getType(),input.getName(),1);

        System.out.println("Joueur 2?");
        input = Input.handleInput();


        Player p2 = handleType(input.getType(),input.getName(),2);

        Display.display_grid(grid);

        while(true){
            turn++;
            p1.play(grid);
            if(Grille.tabIsFull(grid)){
                System.out.println("Égalité");
                System.exit(1);
            }
            p2.play(grid);
            if(Grille.tabIsFull(grid)){
                System.out.println("Égalité");
                System.exit(1);
            }
        }

    }
    public static Player handleType(String type, String name, int noPlayer){
        if(type.equals("humain")){
            return new Human(noPlayer,0,name);
        }
        else{
            return new IA(noPlayer,0,name);
        }
    }
}
