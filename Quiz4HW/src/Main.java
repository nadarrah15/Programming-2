import java.util.Random;

import structure5.Vector;

public class Main {

	// sort array[start]... array[finish-1]
	public static void otherSort(int[] array, int start, int finish) {
		if (finish - start <= 1)
			return;

		int mid = (finish + start) / 2;
		otherSort(array, start, mid);
		otherSort(array, mid, finish);

		// shuffle the two halves together: The first loop repeatedly picks the
		// smaller
		// of the two entries at the "top" of either pile, copying them into a
		// temp array.
		// then, we copy over any entries left in one of the piles

		// positions in left and right subsection, respectively
		int i = start;
		int j = mid;

		int[] temp = new int[finish - start];
		int pos = 0;

		while (i < mid && j < finish) {
			if (array[i] < array[j]) {
				temp[pos] = array[i];
				i++;
			} else {
				temp[pos] = array[j];
				j++;
			}
			pos++;
		}

		// only one of the following two loops will ever execute.
		while (i < mid) {
			temp[pos] = array[i];
			pos++;
			i++;
		}

		// there's an optimization available here... can you see what it is?
		while (j < finish) {
			temp[pos] = array[j];
			pos++;
			j++;
		}

		// copy the elements from temp back to array
		for (int k = start; k < finish; ++k) {
			array[k] = temp[k - start];
		}

		// merge step done; O(n) time -- each element gets copied twice.
	}

	public static void otherSort(int[] array) {
		otherSort(array, 0, array.length);
	}

	// runs O(n*sqrt(n))
	public static Vector<Vector<Integer>> factTableSqrt(int n)
	// pre: n > 0
	// post: returns a table of factors of values 1 through n
	{
		Vector<Vector<Integer>> table = new Vector<Vector<Integer>>();
		for (int i = 1; i <= n; i++) {
			Vector<Integer> factors = new Vector<Integer>();
			// 1 and n will always be included
			factors.add(1);
			for (int f = 2; f * f <= i; f++) {
				if ((i % f) == 0) {
					// as to not add duplicates
					if (!factors.contains(f))
						factors.add(f);
					if (!factors.contains(i / f))
						factors.add(i / f);
				}
			}

			// we dont want to add i in twice, its already added in
			// at line 14 if i = 1
			if (i != 1)
				factors.add(i);
			table.add(factors);
		}
		return table;
	}

	// runs O(n * ln(n))
	// runs like a seive, no calculations involved
	public static Vector<Vector<Integer>> factTableLogN(int n)
	// pre: n > 0
	// post: returns a table of factors of values 1 through n
	{
		Vector<Vector<Integer>> table = new Vector<Vector<Integer>>();

		for (int i = 0; i < n; i++)
			table.add(new Vector<Integer>());

		for (int i = 1; i <= n; i++) {
			for (int f = i; f <= n; f += i) {
				table.get(f - 1).add(i);
			}
		}
		return table;
	}

	public static void main(String[] args) {
		// for some reason, factTableSqrt(100) runs the fastest for me out of
		// all of these entries
		for (int i = 10; i <= 100000; i *= 10) {
			long startTime = System.currentTimeMillis();
			factTableSqrt(i);
			long endTime = System.currentTimeMillis();
			System.out.println("O(n * sqrt(n)): n = " + i + " Time: " + (endTime - startTime) + "ms");
		}

		// runs faster than O(n * sqrt(n)) as expected
		for (int i = 10; i <= 100000; i *= 10) {
			long startTime = System.currentTimeMillis();
			factTableLogN(i);
			long endTime = System.currentTimeMillis();
			System.out.println("O(n * ln(n)): n = " + i + " Time: " + (endTime - startTime) + "ms");
		}
		
		Random gen = new Random();
		for(int i = 10; i <= 100000; i *= 10){
			int[] a = new int[i];
			for(int j = 0; j < i; j++){
				a[j] = gen.nextInt();
			}
			long startTime = System.currentTimeMillis();
			otherSort(a);
			long endTime = System.currentTimeMillis();
			System.out.println("Sort for array " + i + " long. Time: " + (endTime - startTime) + "ms");
		}
	}
}
