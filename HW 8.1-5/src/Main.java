import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<String>();
		
		System.out.println("Input 0 to end input");
		
		while(true){
			String input = r.nextLine();
			
			if(input.equals("0"))
				break;
			
			a.add(input);
		}
		
		for(String word: a){
			if(word.length() < 5)
				System.out.println(word);
		}
		
		System.out.print("\nInput a string: ");
		String input = r.nextLine();
		StringIterator stringIter = new StringIterator(input);
		
		while(stringIter.hasNext())
			System.out.println(stringIter.next());
	}

}
