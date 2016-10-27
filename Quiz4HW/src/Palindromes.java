import java.util.Scanner;

public class Palindromes {
	
	//assumes user types no spaces. if user does type in spaces, then the method does not work correctly.
	//we will not check for spaces and assume the user understands the rules. if the user breaks the rules, the
	//method will still run.
	//
	//Runs T(N) = T(N - 2) + C since we shave off 2 letters each time. T(1) and T(2) are constants.
	//We can deduce that this runs O(n).
	public static boolean isPalindrome(String s){
		//we are not case sensitive
		s = s.toLowerCase();
		
		//base case for odd lengthed strings
		if(s.length() == 1) 
			return true;
		
		//base case for even lengthed strings
		else if(s.length() == 2){
			if(s.charAt(0) == s.charAt(1))
				return true;
			else 
				return false;
		}
		
		else if(s.charAt(0) == s.charAt(s.length() - 1))
			return isPalindrome(s.substring(1, s.length() - 1));
		
		//only situation left is if s.charAt(0) != s.charAt(s.length - 1)
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		String s = reader.nextLine();
		//for testing purposes. if the user types -1, the program stops
		while(!s.equals("-1")){
			if(isPalindrome(s))
				System.out.println(s + " is a palindrome");
			else
				System.out.println(s + " is not a palindrome");
			
			s = reader.nextLine();
		}
	}

}
