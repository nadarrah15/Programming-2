import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalBoardException {
		Scanner reader = new Scanner(System.in);
		CoinStrip game = new CoinStrip();
		//two players, true is one false is two
		boolean playerTurn = true;
		System.out.println(game.toString());
		
		boolean win = game.checkWin();
		while(!win){
			if(playerTurn){ 
				System.out.print(">>>Player 1's turn: ");
				playerTurn = false;
			}
			else{
				System.out.print(">>>Player 2's turn: ");
				playerTurn = true;
			}
			boolean move = false;
			
			try{
				move = game.move(reader.nextInt());
			} catch(InputMismatchException e){
				System.out.println("Input must be an integer within the limits of the board");
				reader.nextLine();
			}
			
			while(!move){
				System.out.print(">>>Piece not moved, try again: ");
				try{
					move = game.move(reader.nextInt());
				} catch(InputMismatchException e){
					System.out.println("Input must be an integer within the limits of the board");
					reader.nextLine();
				}
			}
			
			System.out.println(game.toString());
			win = game.checkWin();
		}
		if(playerTurn == true) System.out.println("!!! Player 2 Wins !!!");
		else System.out.println("!!! Player 1 Wins !!!");
	}

}
