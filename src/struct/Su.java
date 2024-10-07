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

    public void fillBoardWithRandomNumbers(int maxRandoms) {
        Random random = new Random();

        for (int i = 0; i < maxRandoms; i++) {
            int row, col, num;

            do {
                row = random.nextInt(9);
                col = random.nextInt(9);
            } while (sudokuBoard[row][col] != 0); // repeat if board pos is not empty (0)

            // generate a random number and check its validity
            for (num = 1; num <= 9; num++) {
                if (isRowColValueValid(sudokuBoard, row, col, num)) {
                    sudokuBoard[row][col] = num; // assign valid random number
                    break; 
                }
            }
        }
    }

    public void drawBoard(){

        for (i=0;i<9;i++){
            for (j=0;j<9;j++){
                System.out.print(sudokuBoard[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    public boolean SuSolved(int[][] sudokuBoard){

        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){

                // check for empty space (0)
                if(sudokuBoard[row][col] == 0){
                    // try to solve
                    // check the row and column of the first occurence of empty space
                    // place the valid num
                    for(int num=1;num<=9;num++){
                        if(isRowColValueValid(sudokuBoard,row,col,num)){
                            // assign the num if valid
                            sudokuBoard[row][col] = num;

                            // check func recursively
                            if(SuSolved(sudokuBoard)){
                                return true; //solved!
                            }

                            sudokuBoard[row][col] = 0; // undo all moves at pos row,col since it doesnt solve the puzzle
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRowColValueValid(int[][] su,int row,int col, int num){

        int one_cell_row = row - row % 3;
        int one_cell_col = col - col % 3;
        for(int x=0;x<9;x++){
            if(su[row][x] == num || su[x][col] == num){ // checking the whole row and column
                return false;
            }
            int gridRow = one_cell_row + x/3;
            int gridCol = one_cell_col + x%3;
    
            if(su[gridRow][gridCol] == num){
                return false; // check in the cell that is (0,0),(0,1),(0,2) and compare with num
            }
        }
        return true;
    }

    public int[][] getSu(){
        return sudokuBoard;
    }
}
