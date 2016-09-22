import structure5.AbstractSet;
import structure5.SetVector;

public class Main {

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		AbstractSet set = allPrimes(9);
		
		//Since AbstractSet is an abstract class, it is meant to be a parent
		//and therefore wont instantiate using an AbstractSet() constructor
		//AbstractSet abSet = new AbstractSet();
		
		//Since SetVector is a subclass of AbstractSet, an AbstractSet object can
		//be instantiated using the SetVector() constructor
		AbstractSet vecSet = new SetVector();
		
		SetVector vec = new SetVector();
		
		for(int i = 0; i <= 10; i++){
			vec.add(i);
		}
		
		//Since the method takes an AbstractSet object and SetVector is a subclass of 
		//AbstractSet, then the method can take SetVector
		abstractMethod(vec);
		
		//clone() returns type object
		Object clone = vec.clone();
		System.out.println(clone);
		
		System.out.println(vec.contains(1));
	}
	
	//a method that takes an abstract class as its parameter
	@SuppressWarnings("rawtypes")
	static void abstractMethod(AbstractSet set){
		System.out.println(set);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static AbstractSet allPrimes(int N) {
		AbstractSet set = new SetVector();
		
		for (int i = 2; i <= N / 2; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) set.add(i);
			}
		}

		return set;
	}
}
