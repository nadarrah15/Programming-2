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
		return current < s.length() - 1;
	}

	@Override
	public Object next() {
		if(current < s.length() - 1){
			current++;
			
			return s.substring(0, s.length() - current);
		}
		else{
			throw new NoSuchElementException("No more elements remain");
		}
	}
}
