package struct;
import java.util.*;

public class Hard {
    public Set<List<Integer>> emptyCells = new HashSet<>();

    private int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public Set<List<Integer>> emptyCellsList(){
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    emptyCells.add(List.of(i,j));
                }
            }
        }
        // List<List<Integer>> copyCells = new ArrayList<>(cells);
        return emptyCells;
    }

    public boolean trySolve(int[][] su){

        if(emptyCells.isEmpty()){
            return true;
        }

        List<Integer> cell = emptyCells.iterator().next();
        int row = cell.get(0);
        int col = cell.get(1);

        for(int num=1;num<=9;num++){
            if(numReside(row,col,board,num)){
                su[row][col] = num;
                emptyCells.remove(cell);
                if(trySolve(su)){
                    return true;
                }
            
                su[row][col] = 0;
                emptyCells.add(cell);
            }
        }
        return false; // backtrack
    }

    public boolean numReside(int row, int col,int[][] board,int num){

        int one_cell_row = row - row%3;
        int one_cell_col = col - col%3;
        for(int x=0;x<9;x++){
            if(board[row][x]==num || board[x][col]==num){
                return false;
            }

            int gridRow = one_cell_row + x/3;
            int grid_col = one_cell_col + x%3;

            if(board[gridRow][grid_col] == num){
                return false;
            }
        }

        return true;
    }

    public void drawBoard(int[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int[][] getBoard(){
        return board;
    }

}
