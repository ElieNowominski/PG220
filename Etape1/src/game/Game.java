package game;

import display.Display;
import grid.Grid;
import player.Human;
import player.IA;
import player.Player;

import java.io.File;

import static java.lang.Math.min;


public class Game {
    Grid grid;
    Input input;
    Player[] playerTab;
    Log hist;

    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        Display.display_grid(game.grid);
        game.run();
    }

    private void initialize(){
        this.hist = new Log();  // Init log
        hist.delLog();
        this.grid = new Grid(7, 6);  // Init grid
        this.input = new Input("","",0); // Init input
        this.playerTab = new Player[2];  // Init player tab

        System.out.println("Joueur 1?");
        input.handleInput(1,hist);

        hist.writeNameType(input.name,input.type,1);
        hist.writeLog(hist.log);
        playerTab[0] = handleType(input.type,input.name,1);

        System.out.println("Joueur 2?");
        input.handleInput(2,hist);

        hist.writeNameType(input.name,input.type,2);
        hist.writeLog(hist.log);
        playerTab[1] = handleType(input.type,input.name,2);
    }

    private void run(){
        while(true){
            for(int i = 0;i<2;i++){
                boolean coinIsFalse;
                do {
                    input.column = playerTab[i].play(input, grid.getColumnNbr(),hist);
                    if (grid.columnIsFull(input.column)) {
                        System.out.println("Erreur colonne pleine "+input.column);
                        hist.writeColumnErrorFull(input.column);
                        coinIsFalse = true;
                    }
                    else{
                        coinIsFalse = false;
                    }
                }while(coinIsFalse);
                grid.playCoin(input.column,grid.tabCoins, i);
                hist.writePlayedCoin(input.column,i+1);
                hist.writeLog(hist.log);
                Display.display_grid(grid);

                if(grid.tabIsFull()){
                    System.out.println("Égalité");
                    this.grid = new Grid(7,6);
                    hist.writeRoundVictory(playerTab[i].type,1, playerTab[i].round);
                    hist.writeLog(hist.log);
                    Display.display_grid(this.grid);
                    break;
                }
                if(this.win(playerTab[i].type)==playerTab[i].type){
                    this.grid = new Grid(7,6);
                    hist.writeRoundVictory(playerTab[i].type,0,playerTab[i].round);
                    hist.writeLog(hist.log);
                    this.winRound(i);
                    Display.display_grid(this.grid);
                    break;
                }
            }
        }
    }

    private Player handleType(String type, String name, int noPlayer){
        if(type.equals("humain")){
            return new Human(noPlayer,0,name);
        }
        else{
            return new IA(noPlayer,0,name);
        }
    }

    private int modifyCounter(int x, int y, int noPlayer, int compteur){
        if(this.grid.tabCoins[x][y] == noPlayer){
            return ++compteur;
        }
        else{
            return 0;
        }
    }
    private int win(int noPlayer) {
        int counter;
        counter = 0;
        int x = this.grid.lastCoin[0];
        int y = this.grid.lastCoin[1];
        int xMin = min(x, 3);
        int xMax = min(this.grid.getLineNbr() - 1 - x, 3);
        int yMin = min(y, 3);
        int yMax = min(this.grid.getColumnNbr() - 1 - y, 3);

        for (int i = x - xMin; i <= x + xMax; i++) {   //Victoire sur la colonne
            counter = this.modifyCounter(i,y,noPlayer,counter);
            if (counter == 4) {
                System.out.println("victoire sur colonne");
                return noPlayer;
            }
        }
        counter = 0;
        for (int i = y - yMin; i <= y + yMax; i++) {  //Victoire sur la ligne
            counter = this.modifyCounter(x,i,noPlayer,counter);
            if (counter == 4) {
                System.out.println("victoire sur ligne");
                return noPlayer;
            }
        }
        counter = 0;
        int yMin2 = min(yMin,xMin);
        int xMin2 = min(yMin,xMin);
        int yMax2 = min(yMax, xMax);
        int xMax2 = min(yMax,xMax);
        for (int i = y - yMin2, j = x - xMin2; i <= y + yMax2 && j <= x + xMax2; i++, j++) {   //Victoire sur la diagonale gauche vers droite
            counter = this.modifyCounter(j,i,noPlayer,counter);
            if (counter == 4) {
                System.out.println("victoire sur diagonale de gauche vers droite");
                return noPlayer;
            }
        }
        counter = 0;
        yMax = min(yMax, xMin);
        xMin = min(yMax, xMin);
        xMax = min(xMax, yMin);
        yMin = min(xMax, yMin);
        for (int i = y + yMax, j = x - xMin; i >= y - yMin && j <= x + xMax; i--, j++) {   //Victoire sur la diagonale droite vers gauche
            counter = this.modifyCounter(j,i,noPlayer,counter);
            if (counter == 4) {
                System.out.println("victoire sur diagonale de droite vers gauche");
                return noPlayer;
            }
        }
        return 0;
    }
    private void winRound(int i){
        System.out.println(this.playerTab[i].name + " gagne la manche");
        this.playerTab[i].round++;
        if (this.playerTab[i].round == 3){
            System.out.print(this.playerTab[i].name + " gagne la partie");
            hist.writeWinGame();
            hist.writeLog(hist.log);
            System.exit(1);
        }
    }
}

