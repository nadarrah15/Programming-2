
public class UnoCard extends AbstractCard{

	public static final int RED = 0;
	public static final int BLUE = 1;
	public static final int YELLOW = 2;
	public static final int GREEN = 3;
	public static final int BLACK = 4;
	public static final int SKIP = 10;
	public static final int REVERSE = 11;
	public static final int DRAWTWO = 12;
	public static final int WILD = 49;
	public static final int DRAWFOUR = 50;
	
	public UnoCard(int num, int suit){
		set(num * 4);
	}
	
	public int suit(){
		if(cardIndex <= 48)
			return cardIndex / 4;
		else
			return 4;
	}
	
	@Override
	public int compareTo(Object other) {
		return 0;
	}

}
