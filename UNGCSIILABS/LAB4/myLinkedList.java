import org.graalvm.compiler.nodes.PiArrayNode.Placeholder;

public class myLinkedList {
	public intNode head; // always refer to the first node, otherwise, refers to null
	public int size;// tracking the number of nodes in the list

	public myLinkedList() {
		// constructor, initialize the data field
		this.head = null;
		size = 0;
	}

	public boolean isEmpty() {
		// check if the list is empty or not
		// two choices
		// 1.check if head refers to null
		// 2.check if size is 0
		if (head == null) {
			return true;
		} else {
			return false;
		}

	}

	public void addFirst(int newItem) {
		/*
		 * pack newItem into a node and add it to the front of the list, after
		 * insertion, head should refer to this node
		 */
		// pack newItem into node;
		intNode newNode = new intNode(newItem);
		// if list is empty
		if (isEmpty() == true) {
			// make head refer to newNode
			head = newNode;
			//increase size
			size++;
			return; //finished
		}
		//if list is not empty
		newNode.setNext(head); // set newNode.next field refers to current head
		head = newNode; // update head to refer to new node
		size++; // increase size
	}

	public void addLast(int newItem) {
		/*
		 * pack newItem into a node and add it to the end of the list, after insertion
		 */
		// pack newItem into newNode
		intNode newNode = new intNode(newItem);
		intNode current = head; // make current refer to head
		// if list is empty, addFirst() or update head reference
		if (isEmpty() == true) {
			addFirst(newItem);
		} else { // else if list not empty
			while (current.getNext() != null) { // while (current != last node or NULL 
				current = current.getNext(); // move to the next node
			}
			current.setNext(newNode);// set current node.next field refer to newNode
		}
		size++; //increase size
	}

	public int removeFirst() {
		/*
		 * remove the first node (make the second node become the first node and head
		 * refers to it) and return the removed item
		 */
		// def variable = -1
		int placeHolder = -1;
		// if(list is not empty)
		if (isEmpty() == false) {
			// update variable to item/data stored at head
			placeHolder = head.getItem(); 
			// if (list contains only 1 node) update head
			if (size == 1) {
				// head points to null
				head = null;
			} else {// else (contains more than 1 node)
				// rm first node (head refers to head.next)
				head = head.getNext();
			}
			size--; //decrement size
		}
		// else
		// return variable
		return placeHolder;
	}

	public int removeLast() {
		/*
		 * remove the last node (make the second to the last be the new last if exists)
		 * and return the removed item
		 */
		// def variable = -1
		int placeHolder = -1;
		// if(list not emtpty)
		if (isEmpty() == false) {
			// if list contains one node
			if (size == 1) {
				// update variable to the item stored at head
				placeHolder = head.getItem();
				//then remove item
				removeFirst();
			} else {
				// current refers to head
				intNode current = head;
				while (current.getNext().getNext() != null) { // while current does not refer to second to last node
					current = current.getNext(); // move to the next node
				}
				// update variable to item stored at current
				placeHolder = current.getNext().getItem(); // grab data from current.getNext()
				// current next field refers to null
				current.setNext(null); // set the next item in curren to null since it is last
			}
			size--; // decrement size
		}
		return placeHolder;
	}

	public boolean search(int target) {
		// search for a target in the list, return true for yes and false for no
		// make current refer to head
		intNode current = head;
		while (current != null) {// while current refers to a node on the list
			if (current.getItem() == target) { // if current.getItem == target return true
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	public void print() {
		intNode curr = head;
		while (curr != null) {
			System.out.print(curr.getItem() + "->");
			curr = curr.getNext();
		}

		System.out.println();
	}

}
