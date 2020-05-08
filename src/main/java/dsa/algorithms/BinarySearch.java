package dsa.algorithms;

public class BinarySearch {

	public static boolean binarySearch(int n, int A[]) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			System.out.println(mid);
			System.out.println(A[mid]);
			if (A[mid] == n) {
				return true;
			} else if (A[mid] < n) {
				low = mid + 1;
			} else if (A[mid] > n) {
				high = mid - 1;
			}
		}
		return false;
	}

	public static void printArray(int a[]) {
		for (int i : a) {
			System.out.println(a[i]);
		}
	}
}