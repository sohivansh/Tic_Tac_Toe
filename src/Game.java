import java.util.Scanner; 
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] board = 
			{{'.','.','.','.','.','.','.'},
			 {'|',' ','|',' ','|',' ','|'},
			 {'.','.','.','.','.','.','.'},
			 {'|',' ','|',' ','|',' ','|'},
			 {'.','.','.','.','.','.','.'},
			 {'|',' ','|',' ','|',' ','|'},
			 {'.','.','.','.','.','.','.'}};
		printBoard(board);
		Scanner input = new Scanner(System.in);
		boolean haveWon = false; 
		int turnCounter = 1;
			while(!haveWon) {
				System.out.print("Enter 1 - 9 number acc to position  ");
				int Index = input.nextInt();
				
				char currentTurn = 'X';
				if(checkMark(board,Index) == ' ') {
					if(turnCounter % 2 == 0) {
						currentTurn = 'O';
						turnCounter++;
					}
					else{
						currentTurn = 'X';
						turnCounter++;
					}
					placeMark(board,Index,currentTurn);
					printBoard(board);
				}
				else {
					System.out.println("Invalid mark");
				}
				haveWon = checkWin(board,currentTurn);
				if(haveWon) {
					System.out.println(currentTurn + " has won");
				}
				if(turnCounter == 10 && !haveWon) {
					System.out.println("Tie");
					System.exit(0);
				}

			}
			
		
		
	}
	public static boolean checkWin(char[][] board, char player) {
		//row check
		for(int row = 1; row <= 5; row += 2) {
			if(board[row][1] == player && board[row][3] == player && board[row][5] == player) {
				return true;
			}
		}
		
		//col check
		for(int col = 1; col <= 5; col += 2) {
			if(board[1][col] == player && board[3][col] == player && board[5][col] == player) {
				return true;
			}
		}
		
		//diagonal check
		if((board[1][1] == player && board[3][3] == player && board[5][5] == player)||(board[5][1] == player && board[3][3] == player && board[1][5] == player)) {
			return true;
		}
		return false;
	}
	public static void printBoard(char [][] array) {
		for(char [] row : array) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void placeMark(char[][]board,int Index, char C) {
		switch(Index) {
		 case 1:
			 board[1][1] = C;
			 break;
		 case 2:
			 board[1][3] = C;
			 break;
		 case 3:
			 board[1][5] = C;
			 break;
		 case 4:
			 board[3][1] = C;
			 break;
		 case 5:
			 board[3][3] = C;
			 break;
		 case 6:
			 board[3][5] = C;
			 break;
		 case 7:
			 board[5][1] = C;
			 break;
		 case 8:
			 board[5][3] = C;
			 break;
		 case 9:
			 board[5][5] = C;
			 break;
			 
		}
	}
	public static char checkMark(char[][]board,int Index) {
		char C = ' ';
		switch(Index) {
		 case 1:
			C = board[1][1];
			 break;
		 case 2:
			C = board[1][3];
			 break;
		 case 3:
			 C = board[1][5];
			 break;
		 case 4:
			 C = board[3][1];
			 break;
		 case 5:
			 C = board[3][3];
			 break;
		 case 6:
			 C = board[3][5];
			 break;
		 case 7:
			 C = board[5][1];
			 break;
		 case 8:
			 C = board[5][3];
			 break;
		 case 9:
			 C = board[5][5];
			 break;
		 default:
			 C = ' ';
			 break;
			 
		}
		return C;
		
		
	}

}
