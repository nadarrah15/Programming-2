
public class startstop {
	
	//Instance variables recording what the time is when the stop watch starts, the total time,
	//and a boolean to keep track and see if the watch is running
	private long startTime, totalTime = 0;
	
	//The purpose of having a call() function over a start() and stop() function is that the user could
	//use the start() function twice without calling a stop()
	public void start(){
		startTime = System.nanoTime();
	}
	
	public void stop(){
		totalTime += System.nanoTime() - startTime;
	}
	
	public long getTime(){
		return totalTime;
	}
	
	public void reset(){
		totalTime = 0;
	}
}
