import struct.Su;
import struct.Hard;

public class Main {
    public static void main(String[] args){

        boolean naiveBacktrack = false;
        boolean listMethod = false;

        int[][] su = new int[9][9];
        Su suBoard = new Su(su);

        Hard hard = new Hard();
        hard.emptyCells = hard.emptyCellsList();

        long cTime;
        long eTime;
        long timeTaken;


        for(String arg: args){
            if(arg.equals("-nb")){
                naiveBacktrack=true;
            }
            if(arg.equals("-h")){
                listMethod = true;
            }
        }

        if(naiveBacktrack){
            
            
            // System.out.println(cTime);
            cTime = System.currentTimeMillis();
    
            // fill random nos first
            suBoard.fillBoardWithRandomNumbers(20);
            System.out.println("Board with random nos before solving : \n");
    
            suBoard.drawBoard();
    
            System.out.println("");
    
            System.out.println("After solving : \n");
    
            // return solved board
            if(suBoard.SuSolved(suBoard.getSu())){
                System.out.println("Sol exists");
                suBoard.drawBoard();
            } else {
                System.out.println("no soln exists");
            }
    
            // suBoard.drawBoard();
            
            eTime = System.currentTimeMillis();
            timeTaken = eTime-cTime;
            System.out.println("time taken : "+timeTaken+" ms");
        }

        if(listMethod){

            cTime = System.currentTimeMillis();
            System.out.println("Before Solving\n");
            hard.drawBoard(hard.getBoard());
    
            hard.trySolve(hard.getBoard());
    
            System.out.println("\nAfter Solving\n");
            if(hard.trySolve(hard.getBoard())){
                hard.drawBoard(hard.getBoard());
            }

            eTime = System.currentTimeMillis();
            timeTaken = eTime-cTime;
            System.out.println("time taken : "+timeTaken+" ms");
        }

    }
}
