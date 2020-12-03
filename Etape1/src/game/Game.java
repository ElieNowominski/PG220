package game;

import display.Display;
import player.Human;
import player.IA;
import player.Player;
import grille.Grille;

import static java.lang.Math.min;


public class Game {
    public static void main(String[] args) {
        int turn = 0;
        Grille grid = new Grille(7, 6);
        System.out.println("Joueur 1?");
        Input input = Input.handleInput();
        // System.out.println("" + input.getName());  // test si les infos sont bien recupérées
        // System.out.println("" + input.getType());
        Historique.writeNameType(input.getName(),input.getType(),1);
        Player p1 = handleType(input.getType(),input.getName(),1);

        System.out.println("Joueur 2?");
        input = Input.handleInput();

        Historique.writeNameType(input.getName(),input.getType(),2);
        Player p2 = handleType(input.getType(),input.getName(),2);

        Display.display_grid(grid);
        int testwin;
        while(true){
            turn++;
            p1.play(grid);
            if(Grille.tabIsFull(grid)){
                System.out.println("Égalité");
                System.exit(1);
            }
            testwin = win(grid, 1, grid.lastCoin[0],grid.lastCoin[1]);
            System.out.println(testwin);
            p2.play(grid);
            if(Grille.tabIsFull(grid)){
                System.out.println("Égalité");
                System.exit(1);
            }
            testwin = win(grid, 2, grid.lastCoin[0],grid.lastCoin[1]);
            System.out.println(testwin);
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
    public static int win(Grille grid, int noPlayer, int x, int y) {
        int compteur;
        compteur = 0;
        int xMin = min(x, 3);
        int xMax = min(grid.getLineNbr() - 1 - x, 3);
        int yMin = min(y, 3);
        int yMax = min(grid.getColumnNbr() - 1 - y, 3);
        for (int i = x - xMin; i <= x + xMax; i++) {   //Victoire sur la ligne
            if (grid.tabCoins[i][y] == noPlayer) {
                compteur++;
            }
            else {
                compteur = 0;
            }
            if (compteur == 4) {
                return noPlayer;
            }
        }
        for (int i = y - yMin; i <= y + yMax; i++) {  //Victoire sur la colonne
            if (grid.tabCoins[x][i] == noPlayer) {
                compteur++;
            }
            else {
                compteur = 0;
            }
            if (compteur == 4) {
                return noPlayer;
            }
        }
        for (int i = y - yMin, j = x - xMin; i <= y + yMax && j <= x + xMax; i++, j++) {   //Victoire sur la diagonale gauche vers droite
            if (grid.tabCoins[j][i] == noPlayer) {
                compteur++;
            }
            else {
                compteur = 0;
            }
            if (compteur == 4) {
                return noPlayer;
            }
        }
        for (int i = y + yMax, j = x - xMin; i >= y - yMin && j <= x + xMax; i--, j++) {   //Victoire sur la diagonale droite vers gauche
            if (grid.tabCoins[j][i] == noPlayer) {
                compteur++;
            }
            else {
                compteur = 0;
            }
            if (compteur == 4) {
                return noPlayer;
            }
        }
        return 0;
    }
    public static void winRound(Player player){
        System.out.print(player.name + "gagne la manche");
        player.manche++;
        if (player.manche == 3){
            System.out.print(player.name + "gagne la partie");
            System.exit(1);
        }
    }
}

