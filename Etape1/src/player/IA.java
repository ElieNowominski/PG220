package player;

import display.Display;
import player.Player;
import grille.Grille;
import game.Input;
import java.util.Random;

public class IA extends Player {

    public IA(int type, int manche, String name){
        super(type,manche,name);
    }

    @Override
    public int play(Input input,int columnNbr) {
        Random random = new Random();
        int column = 1+random.nextInt(columnNbr);
        return column;
    }


    /*class Game
    {
        Grille g;
        void initialize();
        void run()
        {
            while(!hasWon)
            {
                for(int i = 0;i<2;i++)
                {
                    int numCol = player[i].jouer();
                    g.ajouterToken(i,numCol);
                    if(g.Victory())
                    {
                        hasWon = true;
                    }
                }
            }
        }

    }

    main(String[] arg)
    {

        Game g = new Game();
        g.initialize();
        g.run();
    }*/

}
