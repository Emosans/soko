package struct;
import java.util.*;

public class Su {
    // private variables
    private int[][] sudokuBoard;
    private int i = 0;
    private int j = 0;

    //protected variables

    // objects if any


    public Su(int[][] su){
        // assign board
        this.sudokuBoard = su;
    }

    public void drawBoard(){

        // max random numbers
        int maxRandoms = 10;

        Random random = new Random();

        for(i=0;i<maxRandoms;i++){
            int row,col,num;

            do{
                row = random.nextInt(9);
                col  = random.nextInt(9);
            } while(sudokuBoard[row][col] != 0); // repeat if board pos is not empty (0)

            num = random.nextInt(9) + 1;

            sudokuBoard[row][col] = num;
        }

        for (i=0;i<9;i++){
            for (j=0;j<9;j++){
                System.out.print(sudokuBoard[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}
