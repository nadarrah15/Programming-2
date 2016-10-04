import java.util.List;
import java.util.Vector;

public class FlatMatrix<E> implements Matrix<E> {
	private Vector<E> data;
	private int w;
	private int h;

	public FlatMatrix(int n, int m) {
		if (n <= 0 || m <= 0)
			throw new IllegalArgumentException();

		w = n;
		h = m;
		data = new Vector<E>(n * m);
		for(int i = 0; i < n * m; i++){
			data.add(null);
		}
	}

	/**
	 * 
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
	 * 
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
	 * 
	 * @return the width of the Matrix
	 */
	@Override
	public int width() {
		return w;
	}

	/**
	 * 
	 * @return the height of the Matrix
	 */
	@Override
	public int height() {
		return h;
	}

	/**
	 * 
	 * @param N amount of rows the Matrix is being resized to
	 * @param M amount of columns the matrix is being resized
	 * @throws IllegalArgumentException if the index is 0 or less
	 */
	@Override
	public void resize(int N, int M) {
		if (N < 0 || M < 0)
			throw new IllegalArgumentException();

		Vector<E> newData = new Vector<E>(N * M);
		for(int i = 0; i < N * M; i++){
			newData.add(null);
		}
		int iMin, jMin;
		if (N < height())
			iMin = N;
		else
			iMin = width();
		if (M < height())
			jMin = M;
		else
			jMin = height();

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
	 * precondition: 0 <= i <= height postcondition: data has size w*(h+1) with
	 * nulls from entry i*w....((i+1)*w - 1)
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

	@Override
	public void addCol(int j) {
		if(j < 0 || j > width()) throw new IllegalArgumentException();
		
		for(int i = height() - 1; i >= 0; i--){
			data.add(i * width() + j, null);
		}
		
		w++;
	}

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
