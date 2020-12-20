package player;

import game.Input;
import game.Log;

import java.util.Random;

public class IA2 extends IA{
    int lastCoin;
    public IA2(int type, int round, String name){
        super(type,round,name);
        this.lastCoin = 0;
    }

    public int play(Input input, int columnNbr, Log hist) {
        Random random = new Random();
        if(this.lastCoin == 0) {
            int column = 1 + random.nextInt(columnNbr);
            this.lastCoin = column;
            return column;
        }
        else if(this.lastCoin == 1){
            int number = random.nextInt(100);
            if(number<50){
                return 1;
            }
            else{
                this.lastCoin = 2;
                return 2;
            }
        }
        else if(this.lastCoin == columnNbr-1){
            int number = random.nextInt(100);
            if(number<50){
                return columnNbr-1;
            }
            else{
                this.lastCoin = columnNbr-2;
                return columnNbr-2;
            }
        }
        else{
            int number = random.nextInt(100);
            if(number<33){
                int column = this.lastCoin-1;
                this.lastCoin = column;
                return column;
            }
            else if(number>66){
                int column = this.lastCoin+1;
                this.lastCoin = column;
                return column;
            }
            else{
                return this.lastCoin;
            }
        }
    }
}