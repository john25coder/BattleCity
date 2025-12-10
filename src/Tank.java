public class Tank {

    //Atributos do tank
    final Double Baselife = 10.0;
    private Double life;
    final Double Basedamage = 3.0;
    private Double damage;
    private int Speed = 1;
    private int level = 1;
    private int xp = 0;
    private int xpUP = 2;
    //private int kill = 0;

    //Movimento
    private int row = 0;
    private int col = 0;
    private Direction direction;


    //Construtor
    public Tank (int row, int col,  Direction direction ) {

        this.row = row;
        this.col = col;
        this.direction = direction;
        this.life = Baselife;
        this.damage = Basedamage;

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

    //Sistema de XP
    public void gainXP(int amount) {
        this.xp -= amount;

        if (this.xp == xpUP) {
            levelUP();
            this.xp = 0;
            this.xpUP += 2;

        }
    }


    //Sistema de Level
    private void levelUP(){

        this.level++;
        this.life = Baselife*(1+0.4*level);
        this.damage = Basedamage*(1+0.1*level) ;

        if (this.level%2 ==0){
            Speed++;
        }

    }
    //Sistema de dano
    public void Takedamage(int amount){
        this.life -= damage;
        if (this.life < 0){
            this.life = 0.0;
            System.out.println("Voce morreu!");
        }
    }

    public Double getLife() {
        return life;
    }
    public void setLife(Double life) {
        if(life<0){
            this.life = 0.0;
        }else {
            this.life = life;
        }
    }

    public Double getDamage() {
        return damage;
    }
    public void setDamage(Double damage) {
        this.damage = damage;
    }
    public int getSpeed() {
        return Speed;
    }
    public void setSpeed(int speed) {
        this.Speed = speed;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level){
        if (level==10){
            System.out.println("Voce atingiu o nivel maximo");
            this.level = 10;
        }else {
            this.level = level;
        }
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public Direction getDirection() {
        return direction;
    }

    // Tank.java

    public int getRow() { // Remove o parâmetro 'int row'
        return this.row;
    }

    public int getCol() { // Remove o parâmetro 'int col'
        return this.col;
    }


}
