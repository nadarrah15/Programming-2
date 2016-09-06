import java.util.*;

public class Date {
	
	private int month, day, year;
	
	public Date(int m, int d, int y){
		month = m;
		day = d;
		year = y;
	}
	
	//Constructor makes a random date to solve for
	//UPDATE: needs limit on days for months < 31 days
	public Date(){
		Random gen = new Random();
		month = gen.nextInt(12) + 1;
		day = gen.nextInt(31) + 1;
		year = gen.nextInt(200);
	}
	
	public int dayOfTheWeek(){
		int leapYears = year / 4;
		int monthAdjustment = 0;
		if(month == 1 || month == 10) monthAdjustment = 1;
		else if(month == 2 || month == 3 || month == 11) monthAdjustment = 4;
		else if(month == 5) monthAdjustment = 2;
		else if(month == 6) monthAdjustment = 5;
		else if(month == 8) monthAdjustment = 3;
	}
}
