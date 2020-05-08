package dsa.datastructures.arrays;

public class MultiDimensionalArray {

	int rowCap;
	int colCap;
	int arr[][];
	int rowSize = 0;
	int colsize = 0;

	public MultiDimensionalArray() {
		this.rowCap = 2;
		this.colCap = 2;
		this.arr = new int[rowCap][colCap];
	}

	public MultiDimensionalArray(int rowCap) {
		this.rowCap = rowCap;
		this.colCap = 2;
		this.arr = new int[rowCap][colCap];
	}

	public MultiDimensionalArray(int rowCap, int colCap) {
		this.rowCap = rowCap;
		this.colCap = colCap;
		this.arr = new int[rowCap][colCap];
	}
}
