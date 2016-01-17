public class LinkedListTest {

	public static void main(String[] args) {
		Node first = new Node(0);

		for (int i = 1; i <= 128; i *= 2) {
			first.appendToTail(i);
		}

		Node n = first;

		while (n.getNext() != null) {
			System.out.println(n.value());
			n = n.getNext();
		}
		// last node
		System.out.println(n.value());

	}
}
