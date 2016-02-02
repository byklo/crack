public class Queue<T> {
	
	private Node<T> head;
	private Node<T> tail;

	public Queue<T>() {
		head = null;
		tail = null;
	}

	public void enqueue(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null) {
			head = node;
			tail = head;
		}
		else {
			tail.setNext(node);
			tail = tail.next();
		}
	}

	public T dequeue() {
		if (head != null) {
			T data = head.value();
			head = head.next();
			return data;
		}
		return null;
	}
}