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

    public static Input handleCoinInput(){
        Scanner sc = new Scanner(System.in);

            String input = sc.nextLine();
            if (input.equals("sortir")){
                System.out.print("Vous quittez le jeu");
                System.exit(1);
            }
            int column = Integer.parseInt(input);
            if (!(0 <= column && column < 8)) {
                System.out.println("La colonne doit être entre 0 et 7");
                return new Input("", "", 0);
            } else {
                return new Input("", "", column);
            }

    }


    public static Input handleInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // Gestion du type
        if(input.substring(0,6).equals("humain")) {
            return new Input(input.substring(7),"humain",0);
        }
        else if (input.substring(0,2).equals("ia")) {
            return new Input(input.substring(3),"ia",0);
            // Petit problème à gérer quand le nom de l'ia < 2 lettres
        }
        else {
            return new Input("","",0);
            // Gérer les exceptions + column
        }
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public int getColumn() { return this.column; }
}


