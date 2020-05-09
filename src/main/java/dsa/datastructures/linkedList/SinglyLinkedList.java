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
	 * returns value at specified index +
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

	/**
	 * returns index value from end of SinglyLinkedList
	 * 
	 * @param index
	 * @return
	 */
	public int valueFromEnd(int index){
		return isEmpty()||nodeCount<index+1 ? -1 : getNodeCount()-index+1;
	}

	public int findMiddle(){
		if(isEmpty()){
			return -1;
		} else if(getNodeCount()<=2){
			return 0;
		}
		Node slow = head;
		Node fast = slow.getNext().getNext();
		int count=0;

		while(fast.getNext()!=null){
			++count;
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return count;
	}

	/**
	 * Evaluates if SinglyLinkedList is empty. +
	 * 
	 * @return
	 */
	public boolean isEmpty(){
		return head == null ? true : false;
	}

	/**
	 * Adds a new node to the front of the SinglyLinkedList +
	 * 
	 * @param node
	 */
	public void pushFront(Node node) {
		node.setNext(head);
		head = node;
		nodeCount++;
	}

	/**
	 * Returns the data of the first node in the SinglyLinkedList +
	 * 
	 * @return head.data
	 */
	public int topFront() {
		return head.getData();
	}

	/**
	 * Removes the first node in the SinglyLinkedList +
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
	 * Adds a node to the end of the SinglyLinkedList +
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
	 * returns value at end of SinglyLinkedList +
	 */
	public int topBack() {
		Node temp = head;
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		return temp.getNext().getData();

	}

	/**
	 * removes a node from the end of the SinglyLinkedList +
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
	 * removes node at specified index +
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
		temp.setNext(removedNode.getNext());
		removedNode.setNext(null);
		removedNode = null;
		return true;

	}
	
	/**
	 * removes node with first occurrence of specified value +
	 * 
	 * @param value
	 * @return
	 */
	public boolean removeValue(int value){
		if(isEmpty()){
			return false;
		}
		Node temp = head;
		if(temp.getData()==value){
			popFront();
			return true;
		}
		while(temp.getNext()!=null){
			if(temp.getNext().getData()==value){
				Node removedNode = temp.getNext();
				temp.setNext(removedNode.getNext());
				removedNode.setNext(null);
				removedNode=null;
				return true;
			}
			temp=temp.getNext();
		}
		return false;
	}

	/**
	 * reverses the SinglyLinkedList +
	 * 
	 * @return
	 */
	public Node reverse(){
		if(isEmpty()){
			return head;
		}
		Node curr = head;
		Node newHead = curr.getNext();

		while(curr.getNext().getNext()!=null){
			curr.setNext(newHead.getNext());
			newHead.setNext(head);
			head = newHead;
			newHead = curr.getNext();
		}
		newHead = curr.getNext();
		curr.setNext(null);
		newHead.setNext(head);
		head = newHead;
		return head;
	}

	/**
	 * prints out values within SinglyLinkedList +
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

	/**
	 * returns number of nodes in SinglyLinkedList +
	 * 
	 * @return
	 */
	public int getNodeCount() {
		return nodeCount;
	}
}
