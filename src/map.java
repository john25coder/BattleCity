import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class map {

    private final int row = 13;
    private final int col = 13;
    private char [][] grid;


    public map (){
        grid= new char[row][col];

    }

    public void loadFile(String path) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line;
            int l = 0;

            while ((line = br.readLine()) != null && l< row){

                for(int c=0; c<col && c<line.length(); c++){

                    grid[l][c] = line.charAt(c);

                }
                l++;
            }

        }

    }

    public void Imprime(){
        for(int l=0; l<row; l++){
            for(int c=0; c<col; c++){

                System.out.print(grid[l][c]);

            }
        }
    }

    public char getCell(int l, int c){

        return grid [l][c];

    }

    public void setCell(int l, int c, char val){

        grid[l][c] = val;

    }
    public int getRows() { return row; }
    public int getCols() { return col; }

}
