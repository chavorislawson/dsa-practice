package dsa.datastructures.arrays;

/**
 * Implementation of automatically resizing array
 */
public class Array {
	private int capacity;
	private int arr[];
	private int size;

	//int *iptr;

	public Array() {
		this.capacity = 2;
		this.arr = new int[capacity];
		this.size = 0;
	}

	public Array(int capacity) {
		this.capacity = 2;
		this.arr = new int[capacity];
		this.size = 0;
	}

	/*
	 * Basic Array Operations
	 * 
	 * Op.		where			Time complexity
	 * 
	 * get 		w/index
	 * get 		w/o index
	 * add 		at beginning
	 * add 		at end
	 * insert 	any index
	 * remove	w/index
	 * remove	at end
	 * 
	 * 
	 */

	public void add(){

	}

	
	// Basic Array Operations
	public void pop() {// if 1/4 of capacity resize to half
		if (size > 0) {
			arr[size - 1] = 0;
			size--;
			if (size == (capacity / 4)) { // <=
				resize();
			}
			System.out.println("popping");
			printArr();
		} else {
			System.out.println("Not popping");
		}
	}

	// public static boolean pop(Object a[]) {
	// if(a.length>0) {
	// a[a.length-1]=null;
	// return true;
	// }
	//
	// return false;
	// }
	public void push(int n) {
		if (size == capacity) {
			resize();
			arr[size] = n;
		} else {
			arr[size] = n;
		}
		size++;
		System.out.println("pushing");
		printArr();
	}

	// public static boolean push(Object a[]) {
	//
	// return false;
	// }
	public void insert(int index, int n) {
		if (size == capacity) {
			resize();
		}
		if (index <= size) {
			for (int i = size - 1; i >= index; i--) {
				arr[i + 1] = arr[i];
			}
			arr[index] = n;
			size++;
			System.out.println("inserting");
			printArr();
		}
		System.out.println("not inserting");
	}

	public int remove(int index) {
		if (size > 0) {
			arr[index - 1] = 0;
			for (int i = index - 1; i < size; i++) {
				arr[i] = arr[i + 1];
			}
			size--;
			System.out.println("removing");
			printArr();
			if (size == (capacity / 4)) {
				resize();
			}
			return index;
		}
		System.out.println(" not removing");
		return -1;
	}

	public int size() {
		System.out.println("Size: " + size);
		return size;
	}

	public int capacity() {
		System.out.println("Capacity: " + capacity);
		return capacity;
	}

	public void resize() {
		if (size == capacity) {
			int a[] = new int[2 * capacity];
			for (int i = 0; i < size; i++) {
				a[i] = arr[i];
			}
			arr = a;
			System.out.println("resizing bigger");
			capacity *= 2;
			capacity();
		} else {
			int a[] = new int[capacity / 2];
			for (int i = 0; i < size; i++) {
				a[i] = arr[i];
			}
			arr = a;
			System.out.println("resizing smaller");
			capacity /= 2;
			capacity();
		}
	}

	public void printArr() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// public static Object[] resize() {}
	public int at(int index) {
		if (index < size) {
			return arr[index];
		}
		return -1;
	}

	public boolean isEmpty() {
		return size < 1;
	}

	public int find(int value) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
