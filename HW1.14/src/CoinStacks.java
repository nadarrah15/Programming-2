import java.util.*;

public class CoinStacks {
	
	private ArrayList<Coin> coinArray = new ArrayList<Coin>();
	
	public CoinStacks(Coin c, int square, int position) throws Exception{
		c.setPosition(square, position);
		coinArray.add(c);
	}
	
	public boolean isValid(){
		for(int i = 0; i < coinArray.size(); i++){
			for(int j = i; j < coinArray.size(); j++){
				if(coinArray.get(i).comparePosition(coinArray.get(j)))
					return false;
			}
		}
		
		return true;
	}
}
