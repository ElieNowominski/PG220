package grille;

public class IA extends Player{
    String name;

    IA(String name, int type){
        super(type);
        this.name = name;
    }

    @Override
    public int play() {
        System.out.println("J'ai pas envie de jouer");
        return 0;
    }
}
