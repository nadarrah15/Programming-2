import java.util.Random;

public class RandomIntGenerator extends AbstractGenerator {

	private Random gen = new Random();		//our random number generator
	private int seed;						//the seed for the generator. Will give consistent numbers
	
	/**
	 * Constructs a RandomIntGenerator with an initial seed. The initial value will be the first by the specified seed. Once reset, the same values will be given
	 * 
	 * @param initial user specified seed for the random generator. 
	 */
	public RandomIntGenerator(int initial){
		seed = initial;
		gen.setSeed(seed);
		current = gen.nextInt();
	}
	
	/**
	 * Constructs a RandomIntGenerator with the seed of 0
	 */
	public RandomIntGenerator(){
		seed = 0;
		gen.setSeed(seed);
		current = gen.nextInt();
	}
	
	/**
	 * Gets the next random integer and sets it to the current value
	 */
	@Override
	public int next() {
		current = gen.nextInt();
		return current;
	}

	/**
	 * resets the generator to start return the same sequence of values returned before
	 */
	@Override
	public void reset() {
		gen.setSeed(seed);
		current = gen.nextInt();
	}
}
