import java.util.Random;

public class Main {

	static String[] randomArray(int N){
		String[] array = new String[N];
		Random gen = new Random();
		for(int i = 0; i < N; i++){
			array[i] = generateString(gen.nextInt(100) + 1);
		}
		
		return array;
	}
	
	public static String generateString(int length){
	    char[] text = new char[length];
	    Random gen = new Random();
	    
	    for (int i = 0; i < length; i++){
	        text[i] = "abcdefghijklmnopqrstuvwxyz".charAt(gen.nextInt(26));
	    }
	    return new String(text);
	}


	
	public static void main(String[] args) {
		Stopwatch watch = new Stopwatch();
		
		
		String[] a = randomArray(10);
		//start
		watch.call();
		int count = 0;
		for (int i = 0; i < a.length; i++)
		    for (int j = i + 1; j < a.length; j++)
		        if (a[i].equals(a[j]))
		            count++;
		//stop
		watch.call();
		
		System.out.println("Array Size: " + a.length +" Time: " + watch.getTime() + " ms Pairs: " + count);
		for(int i = 0; i < a.length; i++){
			
		}
		watch.reset();
		
		a = randomArray(100);
		//start
		watch.call();
		count = 0;
		for (int i = 0; i < a.length; i++)
		    for (int j = i + 1; j < a.length; j++)
		        if (a[i].equals(a[j]))
		            count++;
		//stop
		watch.call();
		
		System.out.println("Array Size: " + a.length +" Time: " + watch.getTime() + " ms Pairs: " + count);
		watch.reset();
		
		a = randomArray(1000);
		//start
		watch.call();
		count = 0;
		for (int i = 0; i < a.length; i++)
		    for (int j = i + 1; j < a.length; j++)
		        if (a[i].equals(a[j]))
		            count++;
		//stop
		watch.call();
		
		System.out.println("Array Size: " + a.length +" Time: " + watch.getTime() + " ms Pairs: " + count);
		watch.reset();
		
		a = randomArray(10000);
		//start
		watch.call();
		count = 0;
		for (int i = 0; i < a.length; i++)
		    for (int j = i + 1; j < a.length; j++)
		        if (a[i].equals(a[j]))
		            count++;
		//stop
		watch.call();
		
		System.out.println("Array Size: " + a.length +" Time: " + watch.getTime() + " ms Pairs: " + count);
		watch.reset();
	}

}
