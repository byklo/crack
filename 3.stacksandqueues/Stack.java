public class Stack<T> {

	private Node<T> top;

	public Stack<T>() {
		top = null;
	}

	public Node<T> top() {
		return top;
	}

	public T pop() {
		if (top != null) {
			T data = top.value();
			top = top.next();
			return data;
		}
		return null;
	}

	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.setNext(top);
		top = node;
	}

	public T peek() {
		if (top != null) {
			return top.value();
		}
		return null;
	}
}