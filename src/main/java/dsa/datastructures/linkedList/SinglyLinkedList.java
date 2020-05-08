package dsa.datastructures.linkedList;

public class SinglyLinkedList {

	Node head;
	int data;
	int nodeCount;

	public SinglyLinkedList() {
		this.head = null;
		this.data = 0;
		this.nodeCount = 0;
	}

	public SinglyLinkedList(Node head) {
		this.head = head;
		this.data = head.data;
		this.nodeCount = 0;// Trying to figure this one out.
	}

	public Node pushFront(Node n) {
		n.next = head;
		head = n;
		printList();
		return head;
	}

	public int topFront() {
		return head.data;
	}

	public Node popFront() {
		if (head == null) {
			// printList();
			return null;
		}
		head = head.next;
		printList();
		System.out.println("popFront");
		return head;
	}

	public Node pushBack(Node back) {
		if (head == null) {
			head = back;
			printList();
			System.out.println("Why are you in here");
			return head;
		}
		if (head.next == null) {
			head.next = back;
			printList();
			System.out.println("Why are you here");
			return head;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next.next = back;
		printList();
		return head;
	}

	public Node popBack() {
		if (head == null || head.next == null) {
			// head = back;
			printList();
			return head;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		printList();
		return head;
	}

	public void printList() {
		if (head != null) {
			Node temp = head;
			while (temp.next != null) {
				System.out.print(temp.data + "->");//
				temp = temp.next;
			}
			System.out.print(temp.data);
			System.out.println();
		} else {
			System.out.println("Nothing to print");
		}
	}
}
