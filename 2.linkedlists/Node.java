public class Node {

	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public void appendToTail(int data) {
		Node n = new Node(data);
		Node tail = this;
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		tail.setNext(n);
	}

	public Node getNext() {
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
