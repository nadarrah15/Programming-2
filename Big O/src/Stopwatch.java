
public class Stopwatch {

	// Instance variables recording what the time is when the stop watch starts,
	// the total time,
	// and a boolean to keep track and see if the watch is running
	private long startTime, totalTime = 0;
	private boolean isRunning = false;

	// The purpose of having a call() function over a start() and stop()
	// function is that the user could
	// use the start() function twice without calling a stop()
	public void call() {
		//start()
		if (!(isRunning)) {
			startTime = System.nanoTime();
			isRunning = true;
		} 
		//stop()
		else if (isRunning) {
			totalTime += System.nanoTime() - startTime;
			isRunning = false;
		}
	}

	public long getTime() {
		return totalTime;
	}

	public boolean isRunning() {
		if (isRunning)
			return true;
		else
			return false;
	}

	public void reset() {
		totalTime = 0;
	}
}
