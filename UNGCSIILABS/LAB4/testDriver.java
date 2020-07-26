
public class testDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myLinkedList list = new myLinkedList();
		list.addFirst(5);
		list.addLast(8);
		list.addLast(12);
		list.addLast(15);
		list.print();
		list.addFirst(3);
		list.print();
		if (list.search(5))
			System.out.println("find item 5.");
		if (!list.search(13))
			System.out.println("Cannot find item 13.");
		System.out.println("After perform two remove first:");
		list.removeFirst();
		list.removeFirst();
		list.print();
		System.out.println("After perform three remove last:");
		list.removeLast();
		list.removeLast();
		list.removeLast();
		list.print();
	}

}
