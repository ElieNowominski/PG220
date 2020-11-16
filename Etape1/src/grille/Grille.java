package grille;

import java.util.Scanner;

public class Grille {

    public static void main(String[] args) {
        System.out.println("Joueur1?");

        String type = handle_input();
        String name = handle_input();

        Player p1 = handle_type(type,name);

        System.out.println("Joueur2?");

        String type2 = handle_input();
        String name2 = handle_input();

        Player p2 = handle_type(type2,name2);

        p1.play();
        p2.play();
    }
    private static Player handle_type(String type, String name){
        if(type.equals("humain")){
            return new Human(1,name);
        }
        else{
            return new IA(name, 1);
        }
    }
    private static String handle_input(){
        Scanner sc1 = new Scanner(System.in);
        return sc1.nextLine();
    }
}
