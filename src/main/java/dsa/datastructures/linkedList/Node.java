package dsa.datastructures.linkedList;

public class Node {
	public int data;
	public Node next;

	/*
	 * Don't do this. It doesn't make sense to add a new node with no data in it 
	 */
	// public Node() {
	// 	this.data = 0;
	// 	this.next = null;
	// }

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return this.data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
