

import java.util.Scanner;

public class TicTacToe {

	// Entry point of java program
	public static void main(String[] args) {

		// Create an empty tic tac toe board.
		// Empty spaces have '_'.
		char[][] board = {
			{'_', '_', '_'},
			{'_', '_', '_'},
			{'_', '_', '_'}
		};

		// Begin game.
		playGame(board);
	}

	public static void playGame(char[][] board) {

		// For reading user input.
		Scanner scnr = new Scanner(System.in);

		// Used to keep track of whose turn it is.
		// 'X' plays on even numbered turns, 'O' plays on odd numbered turns.
		int turn = 0;

		// Continue playing forever
		while (true) {

			// Display current state of board
			printBoard(board);

			// Given the current turn number, get the current player (either 'X' or 'O')
			char player = getPlayer(turn);

			System.out.println(player + ", make your move!");

			// Read position that user wants to place their piece
			System.out.println("Enter i position:");
			int i = scnr.nextInt();

			System.out.println("Enter j position:");
			int j = scnr.nextInt();

			// Make a move
			boolean successfulMove = makeMove(board, player, i, j);

			if (successfulMove) {
				// If move as successful, go to next player's turn
				turn++;
			} else {
				// Otherwise, print error
				System.out.println("Can't put a piece there. Try again!");
			}
		}
	}

	// Write a method that will display a board represented by a char[][].
	// Example output if each player has taken a turn:
	// _ _ X
	// _ O _
	// _ _ _
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		// COMPLETE THIS METHOD
	}

	// Given a board, a player, and a position (i, j), try to place a piece at that position.
	// If the move was successfully made, return true. Otherwise, return false.
	public static boolean makeMove(char[][] board, char player, int i, int j) {
		// COMPLETE THIS METHOD
	
		//out of bounds
		if (i < 0 || i >= board.length){
			return false;
		}
		if (j < 0 || j >= board[i].length){
			return false;
		}
		//already filled with x or an o
		if (board[i][j] == 'X' || board[i][j]== 'o'){
			return false;
		}
		board[i][j]= player;

		return true;
	}

	// Given a current turn number, return the player whose turn it is.
	// 'X' plays on even turns.
	// 'O' plays on odd turns.
	public static char getPlayer(int turn) {
		if (turn % 2 == 0){
			//Even
			return 'X';
		}
		else {
			//odd
			return 'o';
		}
		// COMPLETE THIS METHOD

		//return '1';
	}

}
