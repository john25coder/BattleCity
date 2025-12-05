public class Tank {

    private int life = 10;
    private Double damageNOW = 2;
    private int damage = 2;
    private int level = 1;

    private int row = 13;
    private int col = 6;
    private Direction direction;

    public Tank (int row, int col,  Direction direction ) {

        this.row = row;
        this.col = col;
        this.direction = direction;

    }

    public void moveUP(){
        row--;
    }

    public void moveDOWN(){
        row++;
    }

    public void moveLEFT(){
        col--;
    }

    public void moveRIGHT(){
        col++;
    }

    public void Damage(int damage, int level){
        this.damageNOW = damage*(1+0.1*level) ;
    }

    public void TakeDMG(int damage){
        this.life -= damage;
    }
}
