import java.util.List;
import java.util.Vector;

public class FlatMatrix<E> implements Matrix<E> {
	
	/**
	 * Uses a single vector to store all data. index (i, j) is (i * width + j)
	 */
	private Vector<E> data;
	
	/**
	 * instance variable holds the width of the matrix
	 */
	private int w;
	
	/**
	 * instance variable holds the height of the matrix
	 */
	private int h;

	/**
	 * Creates a n*m Matrix that is represented by a single vector
	 * 
	 * pre: 0 < n, m
	 * @param n the height of the matrix
	 * @param m the width of the matrix
	 */
	public FlatMatrix(int n, int m) {
		if (n <= 0 || m <= 0)
			throw new IllegalArgumentException();

		w = m;
		h = n;
		data = new Vector<E>(n * m);
		for(int i = 0; i < n * m; i++){
			data.add(null);
		}
	}

	/**
	 * Retrieves data at an index
	 * 
	 * pre: 0 <= i, j < height, width
	 * @param i row index of the object being retrieved
	 * @param j column index of the object being retrieved
	 * @return an object at i, j
	 */
	@Override
	public E get(int i, int j) {
		if (i < 0 || i >= height() || j < 0 || j >= width())
			throw new IllegalArgumentException();

		int index = i * width() + j;

		return data.get(index);
	}

	/**
	 * Sets the value at an index
	 * 
	 * pre: 0 <= i, j < height, width
	 * post: data at i, j is changed
	 * @param i row of the object being set
	 * @param j column of the object being set
	 * @throws IllegalArgumentException if the index is out of bounds
	 */
	@Override
	public void set(int i, int j, E elem) {
		if (i < 0 || i >= height() || j < 0 || j >= width())
			throw new IllegalArgumentException();

		data.set(i * width() + j, elem);
	}

	/**
	 * Accessor to the width of the FlatMatrix
	 * 
	 * @return the width of the Matrix
	 */
	@Override
	public int width() {
		return w;
	}

	/**
	 * Accessor to the height of the FlatMatrix
	 * 
	 * @return the height of the Matrix
	 */
	@Override
	public int height() {
		return h;
	}

	/**
	 * Resizes a FlatMatrix
	 * 
	 * pre: 0 < N, M
	 * post: data set is N * M where new rows and/or columns have values null. Rows and columns may be removed
	 * @param N amount of rows the Matrix is being resized to
	 * @param M amount of columns the matrix is being resized
	 * @throws IllegalArgumentException if the index is 0 or less
	 */
	@Override
	public void resize(int N, int M) {
		if (N <= 0 || M <= 0)
			throw new IllegalArgumentException();

		Vector<E> newData = new Vector<E>(N * M);
		for(int i = 0; i < N * M; i++){
			newData.add(null);
		}
		int iMin = Math.min(N, w);
		int jMin = Math.min(M, h);

		for (int i = 0; i < iMin; i++) {
			for (int j = 0; j < jMin; j++) {
				newData.set(i * M + j, data.get(i * width() + j));
			}
		}

		w = N;
		h = M;
		data = newData;
	}

	/**
	 * create a new row i, shifting all existing rows numbered >= i down 1. The
	 * new row will contain all null's.
	 * 
	 * precondition: 0 <= i <= height 
	 * postcondition: data has size w*(h+1) with nulls from entry i*w....((i+1)*w - 1)
	 * @param i index of the row being added
	 */
	@Override
	public void addRow(int i) {
		if (i < 0 || i > height())
			throw new IllegalArgumentException();
		else if (i == height()) {
			// append one row to the end of the vector
			for (int j = 0; j < width(); j++) {
				data.add(null);
			}
		} else if (i != height()) {
			// move i...height-1 down, stick nulls in
			int index = i * width();
			for (int j = 0; j < width(); ++j)
				data.add(index, null);
		}
		// update height
		h++;

		assert (data.size() == w * h) : "Bad addRow";
	}
	
	/**
	 * Adds a column to the FlatMatrix
	 * 
	 * pre: 0 <= j <= width
	 * post: data has size (h + 1) * w and nulls entries 1*w + j... i*w + j
	 * @param j the index of the column being added
	 */
	@Override
	public void addCol(int j) {
		if(j < 0 || j > width()) throw new IllegalArgumentException();
		
		for(int i = height() - 1; i >= 0; i--){
			data.add(i * width() + j, null);
		}
		
		w++;
	}

	/**
	 * Removes a row from the FlatMatrix
	 * 
	 * pre: 0 <= i < height
	 * post:
	 * @param i the index of the row being removed
	 * @return List<E> the row being removed
	 */
	@Override
	public List<E> removeRow(int i) {
		if(i < 0 || i >= height()) throw new IllegalArgumentException();
		List<E> vec = new Vector<E>(width());
		for(int j = width() - 1; j >= 0; j--){
			vec.add(0, data.remove(i * width() + j));
		}
		h--;
		
		return vec;
	}

	/**
	 * Removes a column from the FlatMatrix. 
	 * 
	 * pre: 0 <= j < width
	 * post: data is size h * (w - 1)
	 * @param j the index of the column being removed
	 * @return List<E> the column being removed
	 */
	@Override
	public List<E> removeCol(int j) {
		if(j < 0 || j >= width()) throw new IllegalArgumentException();
		List<E> vec = new Vector<E>(height());
		for(int i = height() - 1; i >= 0; i--){
			vec.add(0, data.remove(i * width() + j));
		}
		w--;
		
		return vec;
	}

	/**
	 * Transposes the matrix such that the first row becomes the frist column etc.
	 * 
	 * @return FlatMatrix<E> is the transpose of this matrix
	 */
	public FlatMatrix<E> transpose(){
    	FlatMatrix<E> matrix = new FlatMatrix<E>(w, h);
    	for(int i = 0; i < h; i++){
    		for(int j = 0; j < w; j++){
    			matrix.set(j, i, get(i, j));
    		}
    	}
    	
    	return matrix;
    }
	
	/**
	 * Creates a string representation of the FlatMatrix
	 * 
	 * @return String a string representation of the FlatMatrix
	 */
	public String toString(){
		String str = "";
		for(int i = 0; i < height(); i++){
			str += "Row " + i + ": " + data.get(i * width());
			for(int j = 1; j < width(); j++){
				str += ", " + data.get(i * width() + j);
			}
			str += "\n";
		}
		
		return str;
	}
}
