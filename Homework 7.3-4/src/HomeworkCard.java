
public class HomeworkCard extends AbstractCard{

	//returns the value where each number counts as 10 * number and suit counts as 4 - suit
	public int value(){
		int value;
		int suit;
		if(face() == ACE)
			value = KING + 1;
		else
			value = face();
		
		suit = suit();
		
		return 10 * value + (4 - suit);
	}
	
	@Override
	public int compareTo(Object other) {
		Card obj = (HomeworkCard) other;
		return this.value() - obj.value();
	}

}
