package dsa.algorithms;

public class SortingAlgorithms {

	/**
	 * <p>
	 * selection sort on an array of integers
	 * 
	 * <p>
	 * They say it improves the performance over bubble sort by gathering the
	 * smaller numbers to the front of the array, but it just seems like a reverse
	 * bubble sort to me
	 * 
	 * <p>
	 * O(n^2) Time
	 * 
	 * <p>
	 * O(1) Space
	 * 
	 * @param a
	 * @return
	 */
	public int[] selectionSort(int[] a) {
		if (a.length <= 1) {
			return a;
		}
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[j + 1] < a[i]) {
					temp = a[i];
					a[i] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

	/**
	 * <p>
	 * bubble sort on an array of integers
	 * 
	 * <p>
	 * O(n^2) time O(1) space
	 * 
	 * @param c
	 * @return
	 */
	public int[] bubbleSort(int[] c) {
		if (c == null || c.length <= 1) {
			return c;
		}
		int b = c.length - 1;
		int temp = 0;

		for (int i = b; i >= 0; i--) {
			for (int j = 0; j < b; j++) {
				if (c[j] > c[j + 1]) {
					temp = c[j];
					c[j] = c[j + 1];
					c[j + 1] = temp;
				}
			}
		}
		return c;

	}

	public int[] insertionSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			int c = a[i];
			int p = i - 1;
			while (a[p] > c) {
				a[p + 1] = a[p];
				p = p - 1;
			}
			a[p + 1] = c;
		}
		return a;
	}

	// public static int[] linearSearch(int a[], int v){
	// for(int i: a){
	// if(v==a[i]){
	// return a[i];
	// }
	// }
	// return null;
	// }

	public static void printArray(int[][] b) {
		if (b == null) {
			System.out.println(b);
		} else if (b.length <= 0) {
			System.out.println("empty");
		} else {
			int r = b.length - 1;
			int c = b[0].length - 1;
			for (int i = 0; i <= r; i++) {
				for (int j = 0; j <= c; j++) {
					System.out.print(b[i][j]);

				}
				System.out.println();
			}
		}
	}

	public static void printArray(int[] c) {
		if (c == null) {
			System.out.println(c);
		} else {
			for (int i : c) {
				System.out.print(i);
			}

		}
	}
}