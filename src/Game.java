import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private map map;
    private Tank player;
    private List<Tank> enemies;
    private boolean running = true;

    public Game() {
        map = new map();
        enemies = new ArrayList<>();
    }

    public void start(String mapFile) throws IOException {
        map.loadFile(mapFile);

        // Varre mapa para criar inimigos
        for (int l = 0; l < map.getRows(); l++) {
            for (int c = 0; c < map.getCols(); c++) {
                if (map.getCell(l, c) == 'E') {
                    // Cria inimigo e limpa a célula no mapa
                    Tank enemy = new EnemyTank(l, c, Direction.DOWN);
                    enemies.add(enemy);
                    map.setCell(l, c, '-');
                }
            }
        }

        // Cria jogador (posição inicial ajustada para o seu mapa)
        player = new Tank(12, 6, Direction.UP);
    }

    public void loop() {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            clearScreen(); // Limpa antes de desenhar
            printGame();

            System.out.println("\nComandos: w(Cima) s(Baixo) a(Esq) d(Dir) x(Sair)");
            System.out.print("Ação: ");

            String input = scanner.nextLine();
            if (input.isEmpty()) continue;

            processPlayerTurn(input.charAt(0));

            if (running) {
                processEnemyTurn();
            }
        }
        scanner.close();
    }

    // --- Lógica de Movimento do Jogador ---
    private void processPlayerTurn(char command) {
        int r = player.getRow();
        int c = player.getCol();

        switch (command) {
            case 'w': if (canMove(r - 1, c)) player.moveUP();    break;
            case 's': if (canMove(r + 1, c)) player.moveDOWN();  break;
            case 'a': if (canMove(r, c - 1)) player.moveLEFT();  break;
            case 'd': if (canMove(r, c + 1)) player.moveRIGHT(); break;
            case 'x': running = false; break;
        }
    }

    // --- Lógica de Movimento dos Inimigos ---
    private void processEnemyTurn() {
        for (Tank enemy : enemies) {
            if (enemy instanceof EnemyTank) {
                // Aqui a IA tentaria mover.
                // Para simplificar agora, a IA só imprime que agiu,
                // pois ela precisaria ter acesso ao 'canMove' para não bater.
                // ((EnemyTank) enemy).act();
            }
        }
    }

    // --- Verificação de Colisão ---
    private boolean canMove(int r, int c) {
        // 1. Limites do mapa
        if (r < 0 || r >= map.getRows() || c < 0 || c >= map.getCols()) {
            return false;
        }

        // 2. Obstáculos (Parede #, Tijolo %, Base B)
        char cell = map.getCell(r, c);
        if (cell == '#' || cell == '%' || cell == 'B') {
            return false;
        }

        // 3. Outros Tanques (Inimigos)
        for (Tank enemy : enemies) {
            if (enemy.getRow() == r && enemy.getCol() == c) {
                return false;
            }
        }

        // 4. Jogador (caso seja um inimigo se movendo)
        if (player.getRow() == r && player.getCol() == c) {
            return false;
        }

        return true;
    }

    // --- Desenhar o Jogo ---
    public void printGame() {
        for (int l = 0; l < map.getRows(); l++) {
            for (int c = 0; c < map.getCols(); c++) {

                char symbol = map.getCell(l, c); // Desenho base (mapa)

                // Sobrepõe Jogador
                if (player.getRow() == l && player.getCol() == c) {
                    symbol = 'T';
                }

                // Sobrepõe Inimigos
                for (Tank enemy : enemies) {
                    if (enemy.getRow() == l && enemy.getCol() == c) {
                        symbol = 'I';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    // --- Limpar Tela ---
    public void clearScreen() {
        // Imprime 50 linhas vazias para "limpar" a tela de forma simples e compatível
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
