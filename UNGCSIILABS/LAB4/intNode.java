
public class intNode {
	private int item;
	private intNode next;

	public intNode(int item) {
		super();
		this.item = item;
		next = null;
	}

	public intNode(int item, intNode n) {
		super();
		this.item = item;
		this.next = n;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public intNode getNext() {
		return next;
	}

	public void setNext(intNode next) {
		this.next = next;
	}





}
