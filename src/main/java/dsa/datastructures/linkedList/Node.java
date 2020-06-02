package dsa.datastructures.linkedList;

public class Node {
	public int data;
	public Node next;
	public Node prev;

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node(int data, Node next, Node prev){
		this.data = data;
		this.next = next;
		this.prev = prev;
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
