public static void main(String[] args) throws IOException {
    Game game = new Game();
    game.start("mapa.txt");
    game.loop(); // Começa o jogo interativo
}