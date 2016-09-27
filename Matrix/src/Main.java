
public class Main {
	
	public static void main(String[] args){
		Matrix matrix = new Matrix(10, 5);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 5; j++){
				matrix.set(i,  j, i * 10 + j);
			}
		}
		
		System.out.println(matrix);
		
		Matrix transpose = matrix.transpose();
		System.out.println(transpose);
	}
}
