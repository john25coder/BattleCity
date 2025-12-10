import java.util.Random;

public class EnemyTank extends Tank {

    private Random random;

    public EnemyTank(int row, int col, Direction direction) {
        super(row, col, direction); // Chama o construtor do pai (Tank)
        this.random = new Random();
    }

    public void act() {
        // Escolhe uma ação aleatória: 0=Mover, 1=Mudar Direção, etc.
        int action = random.nextInt(4); // 0 a 3

        // Exemplo simples de IA
        switch (action) {
            case 0:
                moveUP();
                break;
            case 1:
                moveDOWN();
                break;
            case 2:
                moveLEFT();
                break;
            case 3:
                moveRIGHT();
                break;
        }

        // Se quiser atirar aleatoriamente depois
        // if (random.nextBoolean()) fire();
    }
}

