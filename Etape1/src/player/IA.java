package player;

import player.Player;

public class IA extends Player {
    String name;

    public IA(int type, String name){
        super(type);
        this.name = name;
    }

    @Override
    public int play() {

        return 0;
    }
}
