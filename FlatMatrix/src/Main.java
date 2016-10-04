
public class Main {

	public static void main(String[] args) {
		FlatMatrix<Integer> matrix = new FlatMatrix<Integer>(10, 10);
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				matrix.set(i, j, i * 10 + j);
			}
		}
		
		System.out.println(matrix.toString() + "\n" + matrix.width() + " " + matrix.width());
		
		matrix.removeCol(9);
		matrix.removeRow(9);
		System.out.println(matrix.toString() + "\n" + matrix.width() + " " + matrix.width());
		
		matrix.addCol(9); 
		matrix.addRow(9);
		System.out.println(matrix.toString() + "\n" + matrix.width() + " " + matrix.width());
		
		System.out.println(matrix.get(0, 0) + " " + matrix.get(4, 5));
		
		matrix.resize(11, 11);
		System.out.println(matrix.toString() + "\n" + matrix.width() + " " + matrix.width());
	}
}
