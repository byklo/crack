public class Node {

	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public Node next() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int value() {
		return this.data;
	}

	public void set(int data) {
		this.data = data;
	}
}