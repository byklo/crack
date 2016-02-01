// implement a function to check if a linked list is a palindrome

public class Question7 {
	
	public static void main(String[] args) {

		LinkedList palindrome = new LinkedList(5, 1, 2, 2, 4, 5, 5, 4, 2, 2, 1, 5);

		Question7 util = new Question7();

		palindrome.print();
		System.out.println("The above linked list " + (util.isPalindrome(palindrome.head()) ? "is" : "is not") + " a palindrome!");
	}

	public boolean isPalindrome(Node head) {
		Node result = this.check(head, head.next());
		if (result != null && result.value() == head.value()) {
			return true;
		}
		else {
			return false;
		}
	}

	public Node check(Node head, Node node) {
		if (node.next() == null) {
			if (head.value() == node.value()) {
				return head.next();
			}
			else {
				return null;
			}
		}
		else {
			Node compare = check(head, node.next());
			if (compare != null && compare.value() == node.value()) {
				return compare.next();
			}
			else {
				return null;
			}
		}
	}
}