package grille;

public class Cell extends CoinType {
        int x;
        int y;

        public int getX(){
            return this.x;
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
