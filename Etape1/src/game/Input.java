package game;

import java.util.Scanner;

public class Input {
    String name;
    String type;
    int column;

    public Input(String name, String type, int column){
        this.name = name;
        this.type = type;
        this.column = column;
    }

    public int handleCoinInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("sortir")){
            System.out.print("Vous quittez le jeu");
            System.exit(1);
        }
        int column = Integer.parseInt(input);
        if (!(0 <= column && column < 8)) {
            System.out.println("La colonne doit être entre 1 et 7");
            return 0;
        } else {
            return column;
        }
    }

     void handleInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // Gestion du type
        if(input.substring(0,6).equals("humain")) {
            this.type = "humain";
            this.name = input.substring(7);
        }
        else if (input.substring(0,2).equals("ia")) {
            this.type = "ia";
            this.name = input.substring(3);
            // Petit problème à gérer quand le nom de l'ia < 2 lettres
        }
        /*else {

            // Gérer les exceptions + column
        }*/
    }
    public int getColumn() { return this.column; }
}


