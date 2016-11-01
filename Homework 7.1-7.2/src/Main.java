
public class Main {
	
	public static void main(String[] args){
		RandomIntGenerator a = new RandomIntGenerator();
		PowerTwoGenerator b = new PowerTwoGenerator();
		RangeGenerator c = new RangeGenerator(0, 10);
		printGen(a);
		resetGenerator(a);
		printGen(a);
		printGen(b);
		resetGenerator(b);
		printGen(b);
		printGen(c);
		resetGenerator(c);
		printGen(c);
	}
	
	public static void printGen(Generator gen){
		for(int i = 0; i < 10; i++){
			System.out.println(gen.next());
		}
		System.out.println();
	}
	
	public static void resetGenerator(Generator gen){
		gen.reset();
	}
}
