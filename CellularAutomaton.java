import java.util.Scanner;

public class CellularAutomaton {
    //if the cell is alive print '*' if dead print '.'
    public static void printBoard(boolean [] board){
        for (int i =0; i < board.length; i++){
            if (board[i]){
                System.out.print("*");
            }
            else {
                System.out.print(".");
            }

        }
        System.out.println();

    }
    public static void setCenterOfBoard(boolean [] board){
        board[board.length / 2]= true;
    }
    // contract: it will tell you how many cells are alive within 1 distance of
    //pos on board.
    public static int countLiveInNeighborhood(boolean [] board, int pos ){
        int alive = 0;
        for (int i = pos-1; i <= pos+1; i++){
            // this is what happens if we are out of bounds
            if (i < 0 || i >= board.length){
                continue;
            }
            if (board[i]){
                alive++;
            }
        }
        return alive;

    }
    public static boolean isAliveInNextBoard(boolean [] board, int pos, boolean [] rule){
        int neighbors;
        // 0, 3 -> false
        //1, 2 -> true
        // 0 | false 
        // 1 | true
        // 2 | true 
        // 3 | false
        int alive = countLiveInNeighborhood(board, pos);
        return rule [alive];
    }
    
    public static boolean [] nextBoard(boolean [] board , boolean [] rule){
        // for each cell in the board if there are 1 or 2 neighbors the cell is alive. 
        //Otherwise, its not
        boolean [] newBoard = new boolean [board.length];
        for (int i = 0; i < board.length; i ++){
            newBoard[i] = isAliveInNextBoard(board, i, rule);
        }
        return newBoard;
    }
    public static boolean [] getRuleFromUser (){
        Scanner scnr = new Scanner(System.in);
        /* user will input format as it follows: "tftf",
        otherwise, a boolean array size zero will return instead.*/      
        System.out.println("Please enter a rule");
        System.out.println("options: t or f");
        System.out.println("Example: tftf");
        String option1 = scnr.next(); 
        option1 = option1.toLowerCase();

        boolean [] rule = new boolean [4];
            if (option1.length() != 4){
                return new boolean [0];
            }
            for (int i = 0; i < option1.length(); i++){
                if (option1.charAt(i)== 't'){
                    rule [i]= true;
                }
                else if (option1.charAt(i)=='f'){
                    rule[i] = false;
                }
                else {
                    return new boolean [0];
                }
            }
           
             return rule;     
    }
    public static void main(String[] args) {
        boolean [] board = new boolean[41];
        boolean [] rule = getRuleFromUser();
            if (rule.length == 0){
            System.out.println("Error wrong rule format");
            }
  
            else {
                setCenterOfBoard(board);
                printBoard(board);

                for (int i = 0; i < 15; i++){
                    
                    board = nextBoard(board, rule);
                    printBoard(board);

                }
            }
    }

}









