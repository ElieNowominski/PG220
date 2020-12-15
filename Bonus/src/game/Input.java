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

    public int handleCoinInput(int columnNbr, Log hist) {
        boolean coinIsFalse;
        do {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            try {
                if (input.equals("sortir")) {
                    System.out.print("Vous quittez le jeu");
                    System.exit(1);
                }
                int column = Integer.parseInt(input);
                if (!(0 <= column && column < columnNbr)) {
                    System.out.println("Erreur colonne non valide " + column);
                    hist.writeColumnErrorOut(column);
                    hist.writeLog(hist.log);
                    coinIsFalse = true;
                } else {
                    coinIsFalse = false;
                    return column;
                }
            } catch (java.lang.NumberFormatException e) {
                coinIsFalse = true;
                hist.writeColumnErrorXyz(input);
                hist.writeLog(hist.log);
                System.out.println("Erreur saisi colonne " + input);
            }
        } while (coinIsFalse);
        return column;
    }
     void handleInput(int noPlayer, Log hist) {
         boolean playerIsFalse;
         // Gestion du type
         do {
             Scanner sc = new Scanner(System.in);
             String input = sc.nextLine();
             try {
                 if (input.substring(0, 6).equals("humain")) {
                     this.type = "humain";
                     this.name = input.substring(7);
                     playerIsFalse = false;
                 }

                 else if (input.substring(0, 9).equals("ia:random")) {
                     this.type = "ia:random";
                     this.name = input.substring(3);
                     playerIsFalse = false;
                 }
                 else {
                     System.out.println("Erreur saisie Joueur " + noPlayer);
                     playerIsFalse = true;
                     hist.writeInputError(noPlayer);
                     hist.writeLog(hist.log);
                     System.out.println("Joueur " + noPlayer + "?");
                 }
         }
             catch(java.lang.StringIndexOutOfBoundsException e){
                 System.out.println("Erreur saisie Joueur " + noPlayer);
                 playerIsFalse = true;
                 hist.writeInputError(noPlayer);
                 hist.writeLog(hist.log);
                 System.out.println("Joueur "+noPlayer+"?");
             }
         } while (playerIsFalse);
     }
}


