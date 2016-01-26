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

public class Question5 {

	public static void main(String[] args) {
		LinkedList value1 = new LinkedList(7, 1, 6);
		LinkedList value2 = new LinkedList(5, 9, 2);

		Question5 util = new Question5();

		System.out.println("Adding: " + util.getNumber(value1.head()) + " + " + util.getNumber(value2.head()));

		LinkedList answer = util.add(value1, value2);

		System.out.println("Answer: " + util.getNumber(answer.head()));

		System.out.println("REVERSED");

		value1 = new LinkedList(6, 1, 7);
		value2 = new LinkedList(2, 9, 5);

		answer = util.add2(value1, value2);

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

	// assume all numbers will be only 3 digits long
	public LinkedList add(LinkedList value1, LinkedList value2) {
		Node n1 = value1.head();
		Node n2 = value2.head();

		LinkedList answer = new LinkedList();

		int carryover = 0;
		while (n1 != null && n2 != null) {
			int answerDigit = n1.value() + n2.value() + carryover;
			if (answerDigit > 9) {
				answer.add(answerDigit % 10);
				carryover = 1;
			}
			else {
				answer.add(answerDigit);
				carryover = 0;
			}
			n1 = n1.next();
			n2 = n2.next();
		}

		return answer;
	}

	// assume all numbers are 3 digits again
	public LinkedList add2(LinkedList value1, LinkedList value2) {
		LinkedList answer = new LinkedList();
		addr(value1.head(), value2.head(), answer);
		return answer;
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
				answer.add(answerDigit % 10);
				return 1;
			}
			else {
				answer.add(answerDigit);
				return 0;
			}
		}
	}
}















