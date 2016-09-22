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
				System.out.println(">>>Player 1's turn:");
				playerTurn = false;
			}
			else{
				System.out.println(">>>Player 2's turn:");
				playerTurn = true;
			}
			
			boolean move = game.move(reader.nextInt());
			while(!move){
				System.out.println(">>>Piece not moved, try again:");
				move = game.move(reader.nextInt());
			}
			
			System.out.println(game.toString());
			win = game.checkWin();
		}
		if(playerTurn == true) System.out.println("!!! Player 2 Wins !!!");
		else System.out.println("!!! Player 1 Wins !!!");
	}

}
