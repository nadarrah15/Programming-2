
public class RangeGenerator extends AbstractGenerator{

	private int min, max;	//min is the start of the range being generated and max is the end of the range.
	
	/**
	 * Creates a generator that returns values within a user specified range
	 * 
	 * @param min start of the range (the minimum value that can be returned)
	 * @param max end of the range (the maximum value that can be returned)
	 */
	public RangeGenerator(int min, int max){
		this.min = min;
		this.max = max;
		set(min);
	}
	
	/**
	 * User needs a wake-up to remember not all default constructors are created equally. Have fun traversing this behemoth of a range. (Mental note: Find a better word than behemoth. Pay attention in class, Dr. Yarnell might spew a fancy south carolina word for behemoth.)
	 */
	public RangeGenerator(){
		this(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * returns the next vaule of the range. If the current value is the max, it is reset to the min
	 */
	@Override
	public int next() {
		int i = get();
		
		if(i != max){
			i++;
			set(i);
		}
		else
			reset();
		
		return i;
	}

	@Override
	public void reset() {
		set(min);
	}
}
