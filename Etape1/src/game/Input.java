package game;

import java.util.Scanner;

public class Input {
    String name;
    String type;
    int column;

    Input(String name, String type, int column){
        this.name = name;
        this.type = type;
        this.column = column;
    }

    public int handleCoinInput(int columnNbr) {
        boolean coinIsFalse;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                if (input.equals("sortir")) {
                    System.out.print("Vous quittez le jeu");
                    System.exit(1);
                }
                int column = Integer.parseInt(input);
                System.out.println(column);
                if (!(0 <= column && column < columnNbr)) {
                    System.out.println("Erreur colonne non valide");
                    coinIsFalse = true;
                } else {
                    coinIsFalse = false;
                    return column;
                }
            } catch (java.lang.NumberFormatException e) {
                coinIsFalse = true;
                System.out.println("Erreur saisi colonne xyz");
            }
        } while (coinIsFalse);
        return column;
    }
     void handleInput(int noPlayer) {
         boolean playerIsFalse;
         // Gestion du type
         do {
             Scanner sc = new Scanner(System.in);
             String input = sc.nextLine();
             try {
             if (input.substring(0, 2).equals("ia")) {
                 this.type = "ia";
                 this.name = input.substring(3);
                 playerIsFalse = false;
             } else if (input.substring(0, 6).equals("humain")) {
                 this.type = "humain";
                 this.name = input.substring(7);
                 playerIsFalse = false;
             } else {
                 System.out.println("Erreur saisie Joueur " + noPlayer);
                 playerIsFalse = true;
                 System.out.println("Joueur " + noPlayer + "?");
             }
         }
             catch(java.lang.StringIndexOutOfBoundsException e){
                 System.out.println("Erreur saisie Joueur " + noPlayer);
                 playerIsFalse = true;
                 System.out.println("Joueur "+noPlayer+"?");
             }
         } while (playerIsFalse);
     }
}


