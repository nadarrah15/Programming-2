import java.util.Random;

public class RandomIntGenerator extends AbstractGenerator {

	private Random gen = new Random();		//our random number generator
	private long seed;						//the seed for the generator. Will give consistent numbers
	private int max;
	
	/**
	 * Constructs a RandomIntGenerator with a random seed and a bound to the return values. The initial value will be the first value by the specified seed. Once reset, the same values will be given
	 * 
	 * @param max
	 */
	public RandomIntGenerator(int max){
		this.max = max;
		seed = System.nanoTime();
		reset();
	}
	
	/**
	 * Constructs a RandomIntGenerator with a random seed and no bound. The initial value will be the first value by the specified seed. Once reset, the same values will be given
	 */
	public RandomIntGenerator(){
		this(Integer.MAX_VALUE);
	}
	
	/**
	 * Gets the next random integer and sets it to the current value
	 */
	@Override
	public int next() {
		int i = gen.nextInt(max);
		set(i);
		return i;
	}

	/**
	 * resets the generator to start return the same sequence of values returned before
	 */
	@Override
	public void reset() {
		gen.setSeed(seed);
		set(gen.nextInt(max));
	}
}
