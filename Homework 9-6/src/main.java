import java.util.*;

public class main {

	public static void main(String[] args) {
		Random gen = new Random();
		int reducedAmount = 0;
		int notReducedAmount = 0;
		
		for(int i = 0; i < 100; i++){
			if(new Ratio(gen.nextInt(100000) + 1, gen.nextInt(100000) + 1).isReduced())
				reducedAmount++;
			else
				notReducedAmount++;
		}
		
		/* Some math,
		 *  reducedAmount/notReducedAmount = 6/x^2 where x is pi since we want to estimate pi
		 *  >cross multiply
		 *  6 * notReducedAmount = reducedAmount * x^2
		 *  6 * notReducedAmount / reducedAmount = x^2
		 */
		System.out.print(Math.sqrt((double) 6 * notReducedAmount / reducedAmount));
	}

}
