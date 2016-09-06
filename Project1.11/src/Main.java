
public class Main {

	public static void main(String[] args)throws Exception {
		Date randomDate = new Date();
		randomDate.random();
		int dayOfTheWeek = randomDate.dayOfTheWeek();
		if(dayOfTheWeek == 0) System.out.print(randomDate.toString() + " is on a Saturday");
		else if(dayOfTheWeek == 1) System.out.print(randomDate.toString() + " is on a Sunday");
		else if(dayOfTheWeek == 2) System.out.print(randomDate.toString() + " is on a Monday");
		else if(dayOfTheWeek == 3) System.out.print(randomDate.toString() + " is on a Tuesday");
		else if(dayOfTheWeek == 4) System.out.print(randomDate.toString() + " is on a Wednesday");
		else if(dayOfTheWeek == 5) System.out.print(randomDate.toString() + " is on a Thursday");
		else if(dayOfTheWeek == 6) System.out.print(randomDate.toString() + " is on a Friday");
	}

}
