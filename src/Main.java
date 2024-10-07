import struct.Su;

public class Main {
    public static void main(String[] args){

        boolean naiveBacktrack = false;

        int[][] su = new int[9][9];
        Su suBoard = new Su(su);


        for(String arg: args){
            if(arg.equals("-nb")){
                naiveBacktrack=true;
            }
        }

        if(naiveBacktrack){
            long cTime = System.currentTimeMillis();
    
            System.out.println(cTime);
    
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
            
            long eTime = System.currentTimeMillis();
            long timeTaken = eTime-cTime;
            System.out.println("time taken : "+timeTaken+" ms");
        }
    }
}
