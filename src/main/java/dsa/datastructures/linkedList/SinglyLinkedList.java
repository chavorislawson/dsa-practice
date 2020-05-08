package dsa.datastructures.linkedList;

public class SinglyLinkedList {

	private Node head;
	private int nodeCount;

	public SinglyLinkedList() {
		this.head = null;
	}

	public SinglyLinkedList(Node head) {
		this.head = head;
	}

	/**
	 * Adds a new node to the front of the SinglyLinkedList
	 * 
	 * @param node
	 */
	public void pushFront(Node node) {
		node.setNext(head);
		head = node;
		nodeCount++;
	}

	/**
	 * Returns the data of the first node in the SinglyLinkedList
	 * 
	 * @return head.data
	 */
	public int topFront() {
		return head.getData();
	}

	/**
	 * Removes the first node in the SinglyLinkedList
	 * 
	 * @return head's value
	 */
	public Node popFront() {
		if (head == null) {
			nodeCount--;
			return null;
		}
		Node poppedNode = head;
		head = head.getNext();
		poppedNode.setNext(null);

		nodeCount--;
		return poppedNode;
	}

	/**
	 * Adds a node to the end of the SinglyLinkedList
	 * 
	 * I Don't think this is actually possible
	 * @param back
	 */
	// public void pushBack(Node back) {
	// 	// if (head == null) {
	// 	// 	head = back;
	// 	// 	nodeCount++;
	// 	// } else {

	// 		Node temp = head;
	// 		while (temp != null) {
	// 			temp = temp.getNext();
	// 		}
	// 		head = back;
	// 		nodeCount++;
	// 	//}
	// }

	/**
	 * Removes a node from the end of the SinglyLinkedList
	 * 
	 * I don't think this is possible
	 * @return
	 */
	// public Node popBack() {
	// 	if (head == null || head.getNext() == null) {
	// 		return null;
	// 	}
	// 	Node temp = head;
	// 	while (temp != null) {
	// 		temp = temp.getNext();
	// 	}
	// 	temp = null;
	// 	nodeCount--;
	// 	return head;
	// }

	public void printList() {

		Node temp = head;
		System.out.print("HEAD -> ");
		while (temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
		System.out.println("null");
	}

	public void getCount(){
		System.out.println(nodeCount);
	}
}
