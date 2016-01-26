// implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node

// example

// input: the node c from the linked list a -> b -> c -> d -> e
// result: nothing is returned, but the new linked list looks like a -> b -> d -> e

public class Question3 {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList(5, 6, 3, 8, 9, 4, 1, 2, 5, 7);
		ll.print();

		Node givenNode = ll.head();

		for (int i = 1; i < (ll.length() / 2); i++) {
			givenNode = givenNode.next();
		}

		System.out.println("Given node -> " + givenNode.value());

		Question3 util = new Question3();
		util.vet(givenNode);

		ll.print();
	}

	public void vet(Node n) {
		while (n.next().next() != null) {
			n.set(n.next().value());
			n = n.next();
		}
		n.set(n.next().value());
		n.setNext(null);
	}
}