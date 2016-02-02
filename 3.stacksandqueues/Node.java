public class Node<T> {

	private T data;
	private Node next;

	public Node<T>(T data) {
		this.data = data;
		this.next = null;
	}

	public Node next() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public T value() {
		return this.data;
	}

	public void set(T data) {
		this.data = data;
	}
}