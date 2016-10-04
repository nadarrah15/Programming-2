
import java.util.List;

public interface Matrix <E> {
	
	/**
	 * a matrix factory
	 * @param i
	 * @param j
	 * @return
	 */
	public static <T> Matrix<T> getMatrix(int i, int j) {
		return new FlatMatrix<T>(i, j);
	}
	/**
	 * return the object in row i, column j
	 * 
	 * precondition: 0 <= i < height() and 0 <= j < width()
	 * 
	 * @param i row #
	 * @param j column #
	 */
	E get(int i, int j);

	/**
	 * change the object in row i, column j
	 * 
	 * precondition: 0 <= i < height() and 0 <= j < width()
	 * 
	 * @param i row #
	 * @param j column #
	 */
	void set(int i, int j, E elem);
	
	int width();

	int height();
	
	void resize(int N, int M);
	
	void addRow(int i);
	
	void addCol(int j);
	
	List<E> removeRow(int i);
	
	List<E> removeCol(int j);
}
