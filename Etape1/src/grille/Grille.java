package grille;

import player.Human;
import player.IA;
import player.Player;

import java.util.Scanner;

public class Grille {
    int columnLength;
    int lineLength;
    public Cell[] tabCoins;

    public Grille(int columnLength, int lineLength){
        this.columnLength = columnLength;
        this.lineLength = lineLength;
        this.tabCoins = initTab(columnLength, lineLength);
    }

    public Cell[] initTab(int columnLength, int lineLength){
        Cell[] Tab = new Cell[columnLength*lineLength];
        int i;
        int j=0;
        for(i=0; i<columnLength*lineLength; i++){
            if(i%lineLength == 0){
                j++;
            }
            Tab[i] = new Cell(0,i,j);
        }
        return Tab;
    }
    boolean OutsideGrille(Cell c){
        if(c.getX() > this.columnLength){
            return true;
        }
        else if(c.getY() > this.lineLength){
            return true;
        }
        else {
            return false;
        }
    }


    public static Player handle_type(String type, String name, int noPlayer){
        if(type.equals("humain")){
            return new Human(noPlayer,name);
        }
        else{
            return new IA(noPlayer, name);
        }
    }
    public static String handle_input(){
        Scanner sc1 = new Scanner(System.in);
        return sc1.nextLine();
    }

    public int getcolumnLength(){
        return this.columnLength;
    }
    public int getlineLength(){
        return this.lineLength;
    }
}
