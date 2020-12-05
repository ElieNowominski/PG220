package grille;

import game.Historique;

public class Grille {
    int columnNbr;
    int lineNbr;
    public int[][] tabCoins;
    public int[] lastCoin;

    public Grille(int columnNbr, int lineNbr){
        this.columnNbr = columnNbr;
        this.lineNbr = lineNbr;
        this.tabCoins = initTab(columnNbr, lineNbr);
        this.lastCoin = new int[2];
    }

    public int[][] initTab(int columnNbr, int lineNbr){
        int[][] Tab = new int[lineNbr][columnNbr];
        for(int i=0; i<lineNbr; i++){
            for (int j=0; j<columnNbr; j++){
                Tab[i][j] = 0;
            }
        }
        return Tab;
    }

    public void playCoin(int column, int[][] tab, int player){
        int line = getLastPos(tab,column);
        if (player == 1) {
            tab[line - 1][column - 1] = 2;
        }
        else {
            tab[line - 1][column - 1] = 1;
        }
        this.lastCoin[0] = line-1;
        this.lastCoin[1] = column-1;
    }

    public int getLastPos(int[][] tab, int column){
        column = column - 1;
        int line = this.lineNbr;
        while ((tab[line - 1][column] != 0) && (line > 0)){
            line--;
        }
        return line;
    }


    public int getColumnNbr(){
        return this.columnNbr;
    }
    public int getLineNbr(){
        return this.lineNbr;
    }

    public boolean tabIsFull(){
        for(int i=0; i<this.getLineNbr(); i++){
            for(int j=0; j<this.getColumnNbr(); j++){
                if(this.tabCoins[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
