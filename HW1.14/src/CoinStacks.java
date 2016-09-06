import java.util.*;

public class CoinStacks {
	
	private int square;
	private ArrayList<Coin> coinArray = new ArrayList<Coin>();
	
	public CoinStacks(Coin c, int n, int p) throws Exception{
		c.setPosition(n, p);
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
