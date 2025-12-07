public class enemy {

        private int life = 5;
        private int damage = 1;

        private int row = 1;
        private int col = 9;
        private Direction direction;

        public enemy(int row, int col, Direction direction ) {

            this.row = row ;
            this.col = col;
            this.direction = direction;

        }

}
