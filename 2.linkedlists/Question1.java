// write code to remove duplicates from an unsorted linked list
// follow up - how would you solve this problem if a temporary buffer is not allowed?

public class Question1 {

	public static void main(String[] args) {

		Question1 util = new Question1();

		LinkedList ll = new LinkedList();
			ll.add(1);
			ll.add(2);
			ll.add(1);
			ll.add(1);
			ll.add(3);
			ll.add(0);
			ll.add(0);
			ll.add(5);
			ll.add(3);
			ll.add(1);

		ll.print();

		util.removeDuplicates(ll);

		ll.print();
	}

	// O(n^2) solution, 2 pointers, for each node, run the other pointer from that node to the end, removing duplicates of node on first pointer
	// slow... but doesn't require temporary buffer
	// this is relatively confusing to implement
	public void removeDuplicates(LinkedList ll) {
		Node n1 = ll.head();

		if (n1 == null || n1.next() == null) {
			System.out.println("LinkedList is either empty or only has 1 element");
			return;
		}

		Node n2 = n1;

		// so many corner cases i had to deal with. holy $#@!

		do {
			do {
				if (n2.next().value() == n1.value()) {
					Node last = n2;
					n2 = n2.next();
					while (n2 != null && n2.value() == n1.value()) {
						n2 = n2.next();
					}
					last.setNext(n2);
				}
				else {
					n2 = n2.next();
				}
			} while(n2 != null && n2.next() != null);
			n1 = n1.next();
			n2 = n1;
		} while (n1.next() != null);
	}
}