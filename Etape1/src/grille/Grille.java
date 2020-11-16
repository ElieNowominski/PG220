package grille;

import java.util.Scanner;

public class Grille {

    public static void main(String[] args) {
        System.out.println("Joueur1?");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Vous êtes : "+ str);
    }

}
