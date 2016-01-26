public class LinkedList {

	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public LinkedList(int... values) {
		this.head = null;
		for (int x : values) {
			this.add(x);
		}
	}

	public void add(int value) {
		if (this.head == null) {
			this.head = new Node(value);
		}
		else {
			Node nodey = new Node(value);
			Node tail = this.tail();
			tail.setNext(nodey);
		}
	}

	public Node head() {
		return this.head;
	}

	public Node tail() {
		if (this.head == null) {
			return null;
		}
		else {
			Node node = this.head;
			while (node.next() != null) {
				node = node.next();
			}
			return node;
		}
	}

	public void print() {
		if (this.head == null) {
			System.out.println("LinkedList is empty");
			return;
		}
		else {
			Node node = this.head;
			System.out.print("(HEAD) " + node.value());
			while (node.next() != null) {
				node = node.next();
				System.out.print(" -> " + node.value());
			}
			System.out.print("\n");
		}
	}

	public int length() {
		if (this.head == null) {
			return 0;
		}
		else {
			int length = 0;
			Node node = this.head;
			while (node != null) {
				length++;
				node = node.next();
			}
			return length;
		}
	}
}