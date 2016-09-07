
public class Main {

	public static void main(String[] args) {
		Stopwatch stopWatch = new Stopwatch();
		
		stopWatch.call();
		for(int i = 0; i < 1000000; i++){
			for(int j = 0; j < 5000; j++){
				if(i == 99999) {
					stopWatch.call();
					System.out.print(stopWatch.getTime());
				}
			}
		}
	}
}
