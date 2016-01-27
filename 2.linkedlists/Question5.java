// you have two numbers represented by a linked list, where each node contains a single digit
// the digits are stored in reverse order, such that the 1's digit is at the head of the list
// write a function that adds the two numbers and returns the sum as a linked list

// example
// ( 7 -> 1 -> 6 ) + ( 5 -> 9 -> 2 ) == 617 + 295
// ( 2 -> 1 -> 9 ) == 912

// follow up
// suppose the digits are stored in forward order
// ( 6 -> 1 -> 7 ) + ( 2 -> 9 -> 5 ) == 617 + 295
// ( 9 -> 1 -> 2 ) == 912

// CANNOT ASSUME VALUES ALL HAVE 3 DIGITS

public class Question5 {

	public static void main(String[] args) {
		LinkedList value1 = new LinkedList(7, 1, 9);
		LinkedList value2 = new LinkedList(5, 9);

		Question5 util = new Question5();

		System.out.println("Adding: " + util.getNumber(value1.head()) + " + " + util.getNumber(value2.head()));

		LinkedList answer = util.add(value1, value2);

		System.out.println("Answer: " + util.getNumber(answer.head()));

		System.out.println("REVERSED");

		value1 = new LinkedList(9, 1, 7);
		value2 = new LinkedList(9, 5);

		answer = util.reverseAdd(value1, value2);

		answer.print();
	}

	public String getNumber(Node n) {
		if (n == null) {
			return "";
		}
		else {
			return getNumber(n.next()) + n.value();
		}
	}

	public LinkedList add(LinkedList value1, LinkedList value2) {
		Node n1 = value1.head();
		Node n2 = value2.head();

		LinkedList answer = new LinkedList();

		int carryover = 0;
		while (n1 != null || n2 != null) {
			int val1 = n1 == null ? 0 : n1.value();
			int val2 = n2 == null ? 0 : n2.value();
			int answerDigit = val1 + val2 + carryover;
			if (answerDigit > 9) {
				answer.add(answerDigit % 10);
				carryover = 1;
			}
			else {
				answer.add(answerDigit);
				carryover = 0;
			}
			if (n1 != null) { n1 = n1.next(); }
			if (n2 != null) { n2 = n2.next(); }
		}

		if (carryover > 0) {
			answer.add(carryover);
		}

		return answer;
	}


	// you could pad the smaller numbers with 0's
	// but that sounds hacky
	// but i think it's the only way

	public LinkedList reverseAdd(LinkedList value1, LinkedList value2) {
		LinkedList answer = new LinkedList();

		int length1 = value1.length();
		int length2 = value2.length();

		if (length1 > length2) {
			this.pad(value2, length1 - length2);
		}
		else if (length2 > length1) {
			this.pad(value1, length2 - length1);
		}

		if (addr(value1.head(), value2.head(), answer) > 0) {
			this.pad(answer, 1);
			answer.head().set(1);
		}

		return answer;
	}

	public void pad(LinkedList ll, int padAmount) {
		for (int i = 0; i < padAmount; i++) {
			ll.add(0);
			this.unshift(ll.head(), 0);
		}
	}

	public void unshift(Node n, int value) {
		if (n.next() == null) {
			n.set(value);
			return;
		}
		else {
			unshift(n.next(), n.value());
			n.set(value);
			return;
		}
	}

	public int addr(Node node1, Node node2, LinkedList answer) {
		if (node1.next() == null && node2.next() == null) {
			int answerDigit = node1.value() + node2.value();
			if (answerDigit > 9) {
				answer.add(answerDigit % 10);
				return 1;
			}
			else {
				answer.add(answerDigit);
				return 0;
			}
		}
		else {
			int answerDigit = node1.value() + node2.value() + addr(node1.next(), node2.next(), answer);
			if (answerDigit > 9) {
				this.pad(answer, 1);
				answer.head().set(answerDigit % 10);
				return 1;
			}
			else {
				this.pad(answer, 1);
				answer.head().set(answerDigit);
				return 0;
			}
		}
	}
}















