import java.util.*;

public class cell {
    private Set<List<Integer>> emptyCells = new HashSet<>();

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

    public Set<List<Integer>> emptyCellsList(Set<List<Integer>> cells){
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    cells.add(List.of(i,j));
                }
            }
        }
        // List<List<Integer>> copyCells = new ArrayList<>(cells);
        return cells;
    }

    public static void main(String args[]){
        cell ce = new cell();

        System.err.println(ce.emptyCellsList(ce.emptyCells));
    }

}
