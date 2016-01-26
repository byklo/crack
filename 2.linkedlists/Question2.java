// implement an algorithm to find the kth to last element of a singly linked list

// 4 -> 3 -> 9 -> 5 -> 8 -> 1 -> 5 -> NULL
// kth to last
// 6	5	 4	  3	   2	1

public class Question2 {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
			ll.add(4);
			ll.add(3);
			ll.add(9);
			ll.add(5);
			ll.add(8);
			ll.add(1);
			ll.add(5);

		ll.print();

		Question2 util = new Question2();

		int k = Integer.parseInt(args[0]);

		Node kthFromLast = util.getElementFromLast(k, ll);

		System.out.println("The " + k + "th element from the last element is " + kthFromLast.value());

		util.getElementFromLast2(k, ll.head());

		Node kthFromLast2 = util.getElementFromLast4(k, ll);

		System.out.println("The " + k + "th element from the last element as found by fancy iteration is " + kthFromLast2.value());
	}

	// brute force algorithm
	public Node getElementFromLast(int k, LinkedList ll) {
		int length = 0;
		Node n = ll.head();

		while (n != null) {
			length++;
			n = n.next();
		}

		n = ll.head();

		int index = length - k;
		int counter = 1;

		while (counter < index) {
			counter++;
			n = n.next();
		}

		return n;
	}

	// try recursion
	public int getElementFromLast2(int k, Node n) {
		if (n == null) {
			return 0;
		}
		else {
			int counter = getElementFromLast2(k, n.next());
			if (counter == k) {
				System.out.println("The " + k + "th element from the last element as found by recursion is " + n.value());
			}
			return counter + 1;
		}
	}

	// fancy(actually no) iterative
	public Node getElementFromLast4(int k, LinkedList ll) {
		Node n1 = ll.head();
		Node n2 = n1;

		for (int i = 0; i < k; i++) {
			n2 = n2.next();
		}

		while (n2.next() != null) {
			n2 = n2.next();
			n1 = n1.next();
		}

		return n1;
	}
}
























