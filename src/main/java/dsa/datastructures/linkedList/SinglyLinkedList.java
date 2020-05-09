package dsa.datastructures.linkedList;

/**
 * The class SinglyLinkedList
 * 
 * implements:
 * 
 * nodeCount() - returns size of SinglyLinkedList 
 * printList() 
 * pushFront()
 * topFront() 
 * popFront() 
 * pushBack() 
 * topBack() 
 * popBack() 
 * isEmpty() 
 * valueAt(index) - returns the value at nth index starting from 0 insert(index, value)
 * remove(index) 
 * valueFromEnd(index) - returns value at index evaluated 
 * reverse() - reverse the SinglyLinkedList 
 * removeValue(value) - removes first index with this value
 */
public class SinglyLinkedList {

	private Node head;
	private int nodeCount;
	private Node tail;
	boolean hasTail;
	boolean speedy;

	public SinglyLinkedList(Node head) {
		this.head = head;
	}

	public SinglyLinkedList(boolean wantTail) {
		this.hasTail = wantTail;
	}

	/**
	 * returns value at specified index
	 * 
	 * @param index
	 * @return
	 */
	public int valueAt(int index){
		if(nodeCount<index+1){
			return -1;
		}
		int count = index;
		Node temp = head;

		while(count>0){
			--count;
			temp = temp.getNext();
		}
		return temp.getData();
	}

	public int valueFromEnd(int index){
		if(isEmpty()){
			return 0;
		}
		return getCount()-valueAt(index);
	}

	/**
	 * Evaluates if SinglyLinkedList is empty.
	 * @return
	 */
	public boolean isEmpty(){
		return head == null ? true : false;
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
	 * I think this is only possible with tail feature.
	 * 
	 * @param back
	 */
	public void pushBack(Node back) {
		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(back);
		nodeCount++;
	}

	/**
	 * returns value at end of SinglyLinkedList
	 */
	public int topBack() {
		Node temp = head;
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		return temp.getNext().getData();

	}

	/**
	 * Removes a node from the end of the SinglyLinkedList
	 * 
	 * I think this is only possible with tail feature
	 * 
	 * @return
	 */
	public Node popBack() {
		if (head == null || head.getNext() == null) {
			return null;
		}
		Node temp = head;

		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		nodeCount--;
		return head;
	}

	/**
	 * removed node at specified index
	 * 
	 * @param index
	 * @return
	 */
	public boolean remove(int index){
		if(nodeCount<index+1){
			return false;
		}

		int count = index-1;
		Node temp = head;

		while(count>0){
			--count;
			temp=temp.getNext();
		}
		Node removedNode = temp.getNext();
		temp.setNext(temp.getNext().getNext());
		removedNode = null;
		return true;

	}

	/**
	 * prints out values within SinglyLinkedList
	 */
	public void printList() {
		Node temp = head;

		System.out.print("HEAD -> ");
		while (temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
		System.out.println("null");
	}

	public int getCount() {
		return nodeCount;
	}
}
