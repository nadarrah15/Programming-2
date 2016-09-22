import java.util.Random;
import structure.Vector;

/**
 * Rules of the game are to be inforced by another class, preferrably a Main, to allow variations of the game
 * 
 * @author Nathan
 *
 */
public class CoinStrip {
	
	/**
	 * Instance variable
	 * creates an integer Vector where 0 means empty and 1 is a coin
	 */
	private Vector board;
	/**
	 * used for the random constructor
	 */
	Random gen = new Random();
	/**
	 * retains the number of coins to help check the win condition 
	 */
	int numCoins = 0;
	
	/**
	 * Creates a 20 square board with a random amount of coins on the board
	 * @throws IllegalBoardException has to handle the place exception
	 */
	public CoinStrip() throws IllegalBoardException{
		board = new Vector(20);
		fill();
		for(int i = 0; i < 20; i++){
			int toPlace = gen.nextInt(2);
			if(toPlace == 0)
				place(i);
		}
	}
	
	/**
	 * creates a board with n coins where n = numCoins
	 * pre: numCoins < boardSize, boardSize > 0
	 * @throws IllegalBoardException if board is too small or too many coins
	 */
	public CoinStrip(int boardSize, int numCoins) throws IllegalBoardException{
		if(boardSize < 1) throw new IllegalBoardException("Board is too small");
		if(numCoins > boardSize) throw new IllegalBoardException("Too many coins on board");
		board = new Vector(boardSize);
		this.numCoins = numCoins;
		fill();
		for(int i = 0; i < numCoins; i++){
			place(i);
		}
	}
	
	/**
	 * method places a new coin on the board
	 * 
	 * @param pos indicates the psoition of the coin being placed
	 * @throws IllegalBoardException if more coins than board
	 */
	public void place(int pos) throws IllegalBoardException{
		if(numCoins > board.capacity()) throw new IllegalBoardException("Too many coins on board");
		board.set(pos, new Coin(true));
		numCoins++;
	}
	
	/**
	 * method checks if a coin is at a specified location
	 * 
	 * @param loc is the location on the board we are checking
	 * @return false if the location has a coin, else true
	 */
	public boolean isEmpty(int loc){
		Coin cell = (Coin) board.get(loc);
		return !(cell.getCoin());
	}
	
	/**
	 * Can only move coins forward
	 * 
	 * pre: 0 <= loc < board.capacity()
	 * @param loc is the location of the coin being moved.
	 * @return false if coin is in the way, the location being asked to move is empty
	 */
	
	public boolean move(int loc){
		if(isEmpty(loc) || loc <= 0 || !(isEmpty(loc - 1)) || loc >= board.capacity()) 
			return false;
		else {
			board.set(loc, new Coin(false));
			board.set(loc - 1, new Coin(true));
			return true;
		}
	}
	
	/**
	 * removes coin from position
	 * 
	 * pre: 0 <= loc < board.capacity()
	 * @param loc is the location we want to remove the coin from
	 * @return true if removed, false if conditions are not met
	 */
	public boolean remove(int loc){
		if(loc < 0 || loc >= board.capacity() || isEmpty(loc)) return false;
		else{
			board.set(loc, new Coin(false));
			numCoins--;
			return true;
		}
	}
	/**
	 * sees if the win condition has been met
	 * 
	 * @return true if all coins are in the first n locations where n = numCoins and false if there is a gapS
	 */
	public boolean checkWin(){
		boolean win = true;
		for(int i = 0; i < numCoins; i++){
			if(isEmpty(i))
				win = false;
		}
		return win;
	}
	
	private void fill(){
		for(int i = 0; i < board.capacity(); i++){
			board.set(i, new Coin(false));
		}
	}
	
	/**
	 * method returns a string version of the board 0 is a coin and [] is empty
	 * 
	 * @return returnString where 0 is a coin and [] is empty on the board
	 */
	public String toString(){
		String str = "|";
		String count = " ";
		int boardCount = 0;
		for(int i = 0; i < board.capacity(); i++){
			if(!(isEmpty(i))){
				str += "0|";
				if(boardCount == 10) boardCount = 0;
			}
			else{
				str += " |";
				if(boardCount == 10) boardCount = 0;
			}

			count += boardCount + " ";
			boardCount++;
		}
		str += "\n";
		String returnString = str + count;
		
		return returnString;
	}
	
}
