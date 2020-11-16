package grille;

import java.util.Scanner;

public class Grille {
    int columnLength;
    int lineLength;

    Grille(int columnLength, int lineLength){
        this.columnLength = columnLength;
        this.lineLength = lineLength;
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


    public static void main(String[] args) {
        System.out.println("Joueur1?");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Vous êtes : "+ str);
    }



}
