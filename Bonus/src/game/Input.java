package game;

import java.util.Scanner;

public class Input {
    String name;
    String type;
    int column;
    int line;
    int players;
    int round;
    int columnPlayed;

    Input(String name, String type, int column, int line, int players, int round, int columnPlayed){
        this.name = name;
        this.type = type;
        this.column = column;
        this.line = line;
        this.players = players;
        this.round = round;
        this.columnPlayed = columnPlayed;
    }

    void handleNumberPlayer(Log hist){
        System.out.print("Indiquez le nombre de joueur (de 2 à 4) :  ");
        while (true){
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int players = sc.nextInt();
                if(2 <= players && players<=4) {
                    this.players = players;
                    hist.writeNbPlayer(players);
                    hist.writeLog(hist.log);
                    break;
                }
                else{
                    System.out.println("Vous devez entrez un nombre de joueur cohérent :  ");
                }
            }
            else {
                System.out.println("Vous devez entrez un nombre de joueur cohérent :  ");
            }
        }
    }

    void handleRoundToWin(Log hist) {
        System.out.print("Indiquez le nombre de manche nécessaire pour gagner :  ");
        while (true){
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                this.round = sc.nextInt();
                hist.writeRoundNeeded(round);
                hist.writeLog(hist.log);
                break;
            }
            else {
                System.out.println("Vous devez entrez un nombre de manche cohérent :  ");
            }
        }
    }

    void handleGridSize(Log hist, int players){
        System.out.println("Indiquez : Lignes Colonnes pour choisir la taille de la grille ");
        while(true) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                this.line = sc.nextInt();
                System.out.println("Ligne : " + this.line);
                if (sc.hasNextInt()) {
                    this.column = sc.nextInt();
                    System.out.println("Colonne : " + column);
                    if(testGridSize(column, line, players)){
                        hist.writeGridSize(column, line);
                        hist.writeLog(hist.log);
                        break;
                    }
                    else {
                        System.out.println("La grille ne respecte pas les critères de tailles");
                    }
                }
                else {
                    System.out.println("Problème de saisie de la colonne");
                }
            }
            else {
                System.out.println("Problème d'entrée de la ligne");
            }
        }
    }

    private boolean testGridSize(int column, int line, int players){
        if(column >= players*2){
            if((column * line >= 4*players && ((column * line) % 2 == 0))){
                return true;
            }
        }
        return false;
    }

    public int handleCoinInput(int columnNbr, Log hist) {
        boolean coinIsFalse;
        do {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            try {
                if (input.equals("sortir")) {
                    System.exit(1);
                }
                int column = Integer.parseInt(input);
                if (!(0 <= column && column <= columnNbr)) {
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
                 if (input.equals("sortir")) {
                     System.exit(1);
                 }
                 if(input.substring(0,4).equals("ia:2")){
                     this.type = "ia:2";
                     this.name = input.substring(5);
                     playerIsFalse = false;
                 }
                 else if (input.substring(0, 6).equals("humain")) {
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


