package grille;

public class Cell extends CoinType {
        int x;
        int y;

    public Cell() {
        super(0);
        this.x = 0;
        this.y = 0;
    }

    public int getX(){
            return this.x;
        }

        public int getType(){
            return this.type;
        }
        public int getY(){
            return this.y;
        }
        public Cell(int type, int x, int y){
            super(type);
            this.x = x;
            this.y = y;
        }

}
