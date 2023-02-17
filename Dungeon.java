
/*The objective of the game is to defeat a dragon that has 
been lurking villagers from the nearby town. To succeed, the character will need equip itself with a sword
and a shield. Both items got lost in time. The mission of the game is to find and acquire both sacred tools 
to stop the nightmare of the fearsome monster.*/
 

import java.util.Random;
import java.util.Scanner;

public class Dungeon {

    // Constants for defining the number of rows and columns the dungeon will have.
    static int NUM_ROWS = 4;
    static int NUM_COLUMNS = 4;

    // Constants for defining room types. Feel free to use these in your code.
    static int ROOM_TYPE_EMPTY = 0;
    static int ROOM_TYPE_SHIELD = 1;
    static int ROOM_TYPE_SWORD = 2;
    static int ROOM_TYPE_DRAGON = 3;

    public static void main(String[] args) {

        // Your code STARTS HERE.

        // To get started, first call generateRandomDungeon() to create your dungeon.
        int [][] dungeon = generateRandomDungeon();
        boolean [][] tmp = new boolean [row][col];
        int row = 0;
        int col = 0;
        System.out.println("Oh no! A dragon is killing our sheep and scaring our villagers, please help the knight put a stop to this nightmare!");
        System.out.println("You are in a cell");
        // the variables that we will utilize throughtout are declared 
        int row = 0;
        int col = 0;
        int hpPoints = 5;
        boolean shieldFound = false;
        boolean swordFound = false;
        boolean playingGame = true;
        while (playingGame){
            System.out.println();
            //board is printed
            playDungeon(dungeon, tmp, row, col);
            System.out.println();
            System.out.println("You are in cell " + row + " , " + col);
            // Main menu method is called with the variables needed and it's printed out
            mainMenu(hpPoints, shieldFound, swordFound);
            // previous position array is made 
            int [] prevPos = new int [2];
            prevPos[0] = row;
            prevPos[1] = col;
            //next position as user inputs which direction is called
            int[] nextPos = nextPosition(dungeon, row, col); // nextPos[0] holds the new row and nextPos[1] holds the new column
            row = nextPos[0]; 
            col = nextPos[1];
            boolean emptyRoom = false;
            // if user enters a room with 0 it is an empty room
            if (dungeon[row][col] == 0){ 
                
                emptyRoom = true;
                System.out.println("You have entered an empty room, looks like there's nothing to do here."); 
                     
            }
            // if user enters a room with 1 or 2 it is a monster room
            else if ((dungeon[row][col] == 1) || (dungeon[row][col] == 2)){
                if (dungeon[row][col] == 1){
                    System.out.println("The mythical shield is located in this room!");
                    System.out.println();
                }
                else if (dungeon[row][col] == 2){
                    System.out.println("The mythical sword is located in this room!");
                    System.out.println();
                }
                System.out.println("A monster is guarding it.");
                System.out.println();
                //monster room options is called
                facingMonsters();
                Scanner newScnr = new Scanner(System.in);
                String option1 = newScnr.next();
                //so user can enter both lowercase and uppercase letters and it will run
                option1 = option1.toLowerCase();
               // while the correct options method is not true then user will have to input again until correct option
                while (!correctOptions(option1)){
                    System.out.println("Invalid please try again");
                    facingMonsters();
                    option1 = newScnr.next();
                    option1 = option1.toLowerCase();

                }

                if (option1.equals("a")){
                    boolean optionA = true;
                    //while option a is chosen all of a options will print up until user inputs another choice
                    while(optionA){
                    System.out.println("You have chosen to do nothing.");
                    System.out.println();
                    System.out.println("The monster hit you");
                    System.out.println();
                    hpPoints = hpPoints - 1;
                    System.out.println("Your remaining health points are: " + hpPoints);
                    System.out.println();
                        if (hpPoints == 0){
                        System.out.println("Game Over");
                        break;
                        }
                    facingMonsters();
                    option1 = newScnr.next();
                    option1 = option1.toLowerCase();
                        if ((option1.equals("b") || (option1.equals("c")))){
                            optionA = false;
                        }
             
                    }
                    if (hpPoints <= 0){
                        break;
                    }
                }

                if (option1.equals("b")){
                    System.out.println("You have chosen to hit the monster.");
                    System.out.println();
                    System.out.println("The monster hit you.");
                    System.out.println();
                    hpPoints = hpPoints - 1;
                   
                        if (hpPoints == 0){
                        System.out.println("Game Over");
                        break;
                        }

                        if (dungeon[row][col] == 1){
                            System.out.println("You have defeated the monster and aquired the shield");
                            System.out.println();
                            shieldFound = true;
                        }
                        else if (dungeon[row][col] == 2){
                            System.out.println("You have defeated the monster and aquired the sword");
                            System.out.println();
                            swordFound = true;
                        }
                }
                    
                

                if (option1.equals("c")){
                    //if user runs away the previous position is inputted 
                    System.out.println("You have chose to run away.");
                    row = prevPos[0];
                    col = prevPos[1];

                }
            } 

            else if (dungeon[row][col] == 3){
                System.out.println("The dragon is located in this room");
                facingMonsters();
                Scanner newScnr1 = new Scanner(System.in);
                String option1 = newScnr1.next();
                option1 = option1.toLowerCase();
                while (!correctOptions(option1)){
                    System.out.println("Invalid please try again");
                    facingMonsters();
                    option1 = newScnr1.next();
                    option1 = option1.toLowerCase();

                }
                
                if ((option1.equals("a")) || option1.equals("b")){
                    if (option1.equals("a")){
                    System.out.println("You have chose to do nothing");
                    System.out.println();
                    }

                    if (shieldFound == false){
                        System.out.println("You are missing the shield");
                        System.out.println();
                        if (swordFound == false){
                            System.out.println("You are missing the sword");
                            System.out.println();
                        }
                       hpPoints = 0;
                        if (hpPoints <= 0){
                            System.out.println("The dragon killed you");
                            System.out.println();
                            System.out.println("Game Over...");
                            break;
                        }
                    }

                    
                    if (swordFound == false){
                        System.out.println("You are missing the sword");
                        System.out.println();
                            if (shieldFound == false){
                            System.out.println("You are missing the shield");
                            System.out.println();
                            }

                        hpPoints = 0;
                            if (hpPoints <= 0){
                                System.out.println("The dragon killed you");
                                System.out.println();
                                System.out.println("Game Over...");
                                break;
                            }
                    }
                    if (option1.equals("a")){
                        boolean newOptionA = true; 
                        while (newOptionA){
                        if ((swordFound == true) && (shieldFound == true)){
                            hpPoints = hpPoints - 2;
                            if (hpPoints <= 0){
                                System.out.println("The dragon killed you");
                                System.out.println("Game Over...");
                                break;
                            }
                            
                            else {
                                 System.out.println("The dragon hit you");
                                 System.out.println();
                            }
                            System.out.println("Your remaining health points are " + hpPoints);
                            System.out.println();
                            facingMonsters();
                            option1 = newScnr1.next();
                            option1 = option1.toLowerCase();
                            if ((option1.equals("b")) || (option1.equals("c"))){
                                newOptionA = false;
                            }

                        }
                        }
                        if (hpPoints <= 0){
                        break;
                        }
                    }
                    if (option1.equals("b")){
                        System.out.println("You have chosen to hit the dragon");
                        System.out.println();
                        if ((swordFound == true) && (shieldFound == true)){
                            hpPoints = hpPoints - 2;
                            System.out.println("The dragon hit you");
                            System.out.println();
                            System.out.println("You have defeated the dragon");
                            System.out.println();
                            if (hpPoints <= 0){
                                System.out.println("remaining hpPoints: " + hpPoints);
                                System.out.println();
                                System.out.println("You have saved the village but died in the process");
                                System.out.println();
                                System.out.println("Game Over...");
                                break;
                            }
                            else{
                                System.out.println("remaining hpPoints: " + hpPoints);
                                System.out.println();
                                System.out.println("Congratulations, you have survived this quest!");
                                System.out.println();
                                System.out.println("Game Over...");
                                break;
                            }
                        }

                    }         
                        
                }
               
                else if (option1.equals("c")){
                    System.out.println("You have chosen to run away");
                    row = prevPos[0];
                    col = prevPos[1];
                }

            } 
            
        }
        // Make sure you save it in a variable!

        // Your code ENDS HERE
    

}
    // Your methods START HERE
  
    //Method that prints the board
    public static void playDungeon(int [][] dungeon, boolean [][] tmp, int i, int j){
        for (int row = 0; row < dungeon.length; row++){
            for (int col = 0; col < dungeon[row].length; col++){
                if (tmp[row][col] == true){
                    if (i == row && j == col){
                        System.out.println("C");
                    }
                    else if (dungeon[row][col] == 0 || dungeon[row][col] == 1 || dungeon[row][col] == 2){
                        System.out.println("E");
                    }
                    else {
                        System.out.println("D");
                    }
                }
                else {
                    System.out.println("?");
                }
                
            }
            System.out.println();
        }
    }
    //Method that prints the main menu 
    public static void mainMenu (int hpPoints, boolean shieldFound, boolean swordFound){
        System.out.println();
        System.out.println("Your remaining health points are: " + hpPoints);
        System.out.println();
            if (shieldFound == false){
                System.out.println("Shield aquired: No");
                System.out.println();
            }
            else if (shieldFound == true) {
                System.out.println("Shield aquired: Yes");  
                System.out.println();
            }
           
            if (swordFound == false){
                System.out.println("Sword aquired: No");
                System.out.println();
            }
            else if (swordFound == true){
                System.out.println("Sword aquired: Yes"); 
                System.out.println(); 
            }
            
        System.out.println("Where would you like to move now?");
        System.out.println();
        System.out.println("Use L to move left");
        System.out.println("Use R to move right");
        System.out.println("Use U to move up");
        System.out.println("Use D to move down");
        System.out.println();
    }
    //Method when user moves to a direction
    public static int [] nextPosition(int [] [] dungeon, int row, int col){
        //set isBounds variable to false 
        boolean isBounds = false;
        int [] position = new int[2];
        position[0] = row;
        position[1] = col;
        Scanner scnr = new Scanner(System.in);
        //while isBounds is true run the correct positions
        while(!isBounds){
          
            String positionDirection = scnr.nextLine();
            positionDirection = positionDirection.toLowerCase();

    
            if (positionDirection.equals("l")){
                position [0] = row;
                position [1] = col - 1;
                
            }

            else if(positionDirection.equals( "r")){
                position [0] = row;
                position [1] = col + 1;
     
            }
            else if (positionDirection.equals("u")){
                position[0] = row - 1;
                position[1] = col;
            }
            else if (positionDirection.equals("d")){
                position[0] = row + 1;
                position [1] = col;
            }
            else {
                //correct choice is set to false user inputs again until correct choice is inputted
                boolean correctChoice =false;
                while(!correctChoice){
                System.out.println("Wrong option. Try again.");
                positionDirection = scnr.nextLine();
                positionDirection = positionDirection.toLowerCase();
                    if (positionDirection.equals("l")){
                        correctChoice = true;
                        position [0] = row;
                        position [1] = col - 1;
                    }
                    else if (positionDirection.equals("r")) {
                        correctChoice = true;
                        position [0] = row;
                        position [1] = col + 1;
                    }
                    else if (positionDirection.equals("u")){
                        correctChoice = true;
                        position[0] = row - 1;
                        position[1] = col;
                    }
                    else if (positionDirection.equals("d")){
                        correctChoice = true;
                        position[0] = row + 1;
                        position [1] = col;
                    }
                }   
            } 

  
            // checks if user is in bounds with the isBounds method and if its not in bounds position stays the same
            isBounds = isBounds(dungeon, position[0], position[1]);
            if(!isBounds){
                isBounds = false;
                position[0] = row;
                position[1] = col;
                System.out.println("Invalid move, please try again.");
                //if position is true set isBounds variable to true so the previous code stops running.
            }else{
                isBounds = true;
            }
        }

        //DO NOT MODIFY CODE BELOW THIS
        
        return position;
        
    }
    //Method that determines if user in bounds 
    public static boolean isBounds(int [] [] dungeon, int row, int col){
        if (row < 0 || row >= dungeon.length){
            return false;
        }
        if (col < 0 || col >= dungeon[row].length){
            return false;
        }
        return true;
    }
    //Method when user enters a monster room the options are printec
    public static void facingMonsters(){
        System.out.println("What would you like to do?");
        System.out.println("a) Do nothing");
        System.out.println("b) Hit the enemy");
        System.out.println("c) Run away");
       
    }
    //Method where it is determined whether user input a b or c
    public static boolean correctOptions(String option1){
        if ((option1.equals("a")) || (option1.equals("b")) || (option1.equals("c"))){
            return true;
        }
        return false;

    }


    // Your methods END HERE



    // DO NOT change anything below this comment.

    /*
     * Create a random dungeon represented by a 2D int array (int[][]).
     * In the resulting 2D array:
     *   0 represents an empty room.
     *   1 represents a room with the shield.
     *   2represents a room with the sword.
     *   3 represents a room with the dragon.
     */
    public static int[][] generateRandomDungeon() {
        // Create dungeon
        int[][] dungeon = new int[NUM_ROWS][NUM_COLUMNS];

        // Get random coordinates
        int[][] locations = getRandomCoordinates();

        // Set shield location
        int[] shieldLocation = locations[0];
        dungeon[shieldLocation[0]][shieldLocation[1]] = ROOM_TYPE_SHIELD;

        // Set sword location
        int[] swordLocation = locations[1];
        dungeon[swordLocation[0]][swordLocation[1]] = ROOM_TYPE_SWORD;

        // Set dragon location
        int[] dragonLocation = locations[2];
        dungeon[dragonLocation[0]][dragonLocation[1]] = ROOM_TYPE_DRAGON;

        return dungeon;
    }

    /*
     * The following method returns a an array of random coordinates.
     * Each coordinate is represented by an array of length 2.
     *
     * In the resulting array:
     *   The first coordinate is the location of the the shield.
     *   The second coordinate is the location of the the sword.
     *   The third coordinate is the location of the dragon.
     * 
     * NOTE: This method requires that the minimum size for the dungeon must be 4x4.
     */
    private static int[][] getRandomCoordinates() {
        int numToolsToObtain = 2;
        int numDragons = 1;

        if (NUM_COLUMNS < 4 || NUM_ROWS < 4) {
            System.out.println("Minimum size for the dungeon must be 4x4");
            return null;
        }

        int[][] monstersLocation = new int[numToolsToObtain + numDragons][2];
        Random rand = new Random();

        for (int i = 0; i < numToolsToObtain + numDragons; i++) {
            int row = rand.nextInt(NUM_ROWS);
            int column = rand.nextInt(NUM_COLUMNS);
            if ((row == 0 && column == 0) || (i != 0 && isCoordinateDuplicate(i + 1, row, column, monstersLocation))) {
                int columnDuplicatedValue = column;
                while (column == columnDuplicatedValue || (i != 0 && isCoordinateDuplicate(i + 1, row, column, monstersLocation))) {
                    column = rand.nextInt(NUM_COLUMNS);
                }
            }
            monstersLocation[i][0] = row;
            monstersLocation[i][1] = column;
        }
        return monstersLocation;
    }

    /*
     * Returns true if a monster is already placed in the current cell (row, column), and false otherwise.
     */
    private static boolean isCoordinateDuplicate(int monsters, int row, int column, int[][] monstersLocation) {
        for (int i = 0; i < monsters; i++) {
            if (monstersLocation[i][0] == row && monstersLocation[i][1] == column) {
                return true;
            }
        }
        return false;
    }
}
