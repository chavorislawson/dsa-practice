package dsa.algorithms;

public class ArrayHelp {
	// static int size;
	// public ArrayHelp(int size){
	// this.size = size;
	// }
	public static void main(String[] args) {
		int[] a = new int[10];
		printArr(a);
		// add(8,a);
		System.out.println(add(10, a)); // this produces an array out of bounds exception for 10, but the method doesn't
										// even update the array.
		printArr(a);
		System.out.println(add(a, 9));
		printArr(a);
		System.out.println(add(a, 11));
		printArr(a);
		// double grossPay =0.0, regularPay, hWhole, hFraction;
		// double overTimePay=0.0, regPay =0.0, vacationPay=0.0;
	}

	// stack implementation of array
	// would need a count variable to track when using integer arrays, can't check
	// for nulls.
	public static boolean add(int a, int[] b) {

		if (b[b.length - 1] == 0) {
			b[b.length - 1] = a;
			return true;
		}

		return false;
	}

	// sorts in ascending order
	// would need a count variable to track when using integer arrays, can't check
	// for nulls.
	public static boolean add(int b[], int a) {
		if (b[b.length - 1] == 0) {
			b[b.length - 1] = a;
			for (int i = b.length - 1; i > 0; i--) {
				if (b[i - 1] < b[i]) {
					int temp = b[i - 1];
					b[i - 1] = b[i];
					b[i] = temp;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	// finds number to remove
	public static void remove(int a) {

	}

	// removes number at index
	// public static void remove(int i){}
	// insertionSort
	public static void iSort() {
	}

	public static void printArr(int a[]) {
		for (int i : a) {
			if (i < a.length - 1)
				System.out.print(a[i] + ",");
			else {
				System.out.print(a[i]);
			}
		}
	}
}