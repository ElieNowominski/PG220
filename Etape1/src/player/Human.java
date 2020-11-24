package player;



public class Human extends Player {
    String name;

    public Human(int type, String name) {
        super(type);
        this.name = name;
    }

    @Override
    public int play() {
        return 0;
    }
}
