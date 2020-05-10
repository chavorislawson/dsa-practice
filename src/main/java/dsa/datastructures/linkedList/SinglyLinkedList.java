package dsa.datastructures.linkedList;

/**
 * The class <code>SinglyLinkedList</code>
 * 
 * <p>implements:
 * 
 * <p>nodeCount() - returns size of SinglyLinkedList 
 * <p>printList() 
 * <p>pushFront()
 * <p>topFront() 
 * <p>popFront() 
 * <p>pushBack() 
 * <p>topBack() 
 * <p>popBack() 
 * <p>isEmpty() 
 * <p>valueAt(index) - returns the value at nth index starting from 0 insert(index, value)
 * <p>remove(index) 
 * <p>valueFromEnd(index) - returns value at index evaluated 
 * <p>reverse() - reverse the SinglyLinkedList 
 * <p>removeValue(value) - removes first index with this value
 * 
 * @author Chavoris Lawson
 */
public class SinglyLinkedList {

	private Node head;
	private int nodeCount;

	public SinglyLinkedList(Node head) {
		this.head = head;
	}

	public SinglyLinkedList(){

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

	/**
	 * finds the middle index of the SinglyLinkedList
	 * 
	 * @return
	 */
	public int findMiddle(){
		if(isEmpty()){
			return -1;
		} else if(getNodeCount()<=2){
			return 0;
		}
		Node slow = head;
		Node fast = slow;
		int count=0;

		while(fast.getNext()!=null && fast.getNext().getNext()!=null){
			++count;
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return count;
	}

	/**
	 * evaluates if SinglyLinkedList is empty. +
	 * 
	 * @return
	 */
	public boolean isEmpty(){
		return head == null ? true : false;
	}

	/**
	 * adds a new node to the front of the SinglyLinkedList +
	 * 
	 * @param node
	 */
	public void pushFront(Node node) {
		node.setNext(head);
		head = node;
		nodeCount++;
	}

	/**
	 * returns the data of the first node in the SinglyLinkedList +
	 * 
	 * @return head.data
	 */
	public int topFront() {
		return head.getData();
	}

	/**
	 * removes the first node in the SinglyLinkedList +
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
	 * adds a node to the end of the SinglyLinkedList +
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
	public Node remove(int index){
		if(index==1){
			return head==null ? head : head.getNext(); 
		}
		Node curr = head;
		Node prev = head;

		while(curr.getNext()!=null){
			--index;
			if(index==0){
				prev.setNext(curr.getNext());
				curr = null;
			}
			prev=curr;
			curr=curr.getNext();
		}
		return head;
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
