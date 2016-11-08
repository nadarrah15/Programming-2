import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringIterator implements Iterator{

	private String s;
	private int current;
	
	public StringIterator(String s){
		this.s = s;
		current = 0;
	}
	
	@Override
	public boolean hasNext() {
		return current < s.length();
	}

	@Override
	public Object next() {
		if(current < s.length()){
			String res = s.substring(0, s.length() - current);
			current++;
			
			return res;
		}
		else{
			throw new NoSuchElementException("No more elements remain");
		}
	}
}
