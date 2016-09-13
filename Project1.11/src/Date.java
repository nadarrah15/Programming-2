import java.util.*;

public class Date {
	
	private int month, day, year;
	
	//constructor takes month, day, year in that order and throws
	// an exception if the day is not in the month
	public Date(int month, int day, int year)throws Exception{
		this.month = month;
		this.day = day;
		this.year = year;
		check();
	}
	
	//Default constructor, has no date
	@SuppressWarnings("null") 
	public Date(){
		month = (Integer) null;
		day = (Integer) null;
		year = (Integer) null;
	}
	
	//makes the date a random date
	public void random(){
		Random gen = new Random();
		month = gen.nextInt(12) + 1;
		day = gen.nextInt(31) + 1;
		year = gen.nextInt(200);
		while(true){
			try{
				check();
				break;
			} catch(Exception e){
				day = gen.nextInt(31) + 1;
			}
		}
	}
	
	//Calculates and returns the day that the day falls on
	//during the week starting with 0 = Saturday
	public int dayOfTheWeek(){
		int leapYears = year / 4;
		int monthAdjustment = 0;
		if(month == 1 || month == 10) monthAdjustment = 1;
		else if(month == 2 || month == 3 || month == 11) monthAdjustment = 4;
		else if(month == 5) monthAdjustment = 2;
		else if(month == 6) monthAdjustment = 5;
		else if(month == 8) monthAdjustment = 3;
		else if(month == 9 || month == 12) monthAdjustment = 6;
		return (leapYears + monthAdjustment + day + year) % 7;
	}
	
	//returns the date as a string
	public String toString(){
		return "" + month + "-" + day + "-" + year;
	}
	
	//checks the constructors to make sure that the date is
	//valid and throws an Exception if not
	private void check() throws Exception{
		if(day > 31) throw new Exception("Too many days");
		else if(month == 2 && day > 29 && year % 4 == 0) throw new Exception("Too many days");
		else if(month == 2 && day > 28) throw new Exception("Too many days");
		else if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) throw new Exception("Too many days");
	}
}
