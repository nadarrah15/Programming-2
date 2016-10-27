import java.util.Arrays;

public class Main {

	static boolean search(int N, int[] array){
		int mid = (array.length - 1) / 2;
		if(array[mid] == N) return true;
		//if the array length is 1 and the previous check was false,
		//then the value is not within the array
		else if(array.length == 1) return false;
		else if(array[mid] > N){
			//if it is mid rather than mid + 1, it is possible to
			//return an empty array which will throw an error
			//copyOfRange(0, mid + 1) will return an array containing index 0 through mid
			int[] newArray = Arrays.copyOfRange(array, 0, mid + 1);
			return search(N, newArray);
		}
		//only situation left is if array[mid] < N
		else {
			int[] newArray = Arrays.copyOfRange(array, mid + 1, array.length);
			return search(N, newArray);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		System.out.print(search(-1, array));
	}

}
