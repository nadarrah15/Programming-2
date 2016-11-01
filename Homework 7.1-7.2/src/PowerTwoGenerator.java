
public class PowerTwoGenerator extends AbstractGenerator {

	/**
	 * Creates a new PowerTwoGenerator where the initial value is 2^initial. The proceeding terms will all be the next powers of two so 2^(initial + 1), 2^(initial + 2),... etc.
	 * pre: initial >= 0
	 */
	public PowerTwoGenerator(int initial){
		if(initial < 0)
			throw new IllegalArgumentException("Parameter must be at least 0");
		
		current = (int) (Math.pow(2, initial));
	}
	
	/**
	 * Creates a PowerTwoGenerator that starts at 2^0
	 */
	public PowerTwoGenerator(){
		current = 1;
	}
	
	/**
	 * Sets the current value as the next power of two and returns it
	 */
	@Override
	public int next() {
		current *= 2;
		return current;
	}

	/**
	 * Starts the generator back at 2^0
	 */
	@Override
	public void reset() {
		current = 1;
	}
}
