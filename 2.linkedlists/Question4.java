// write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x

// given: 2 -> 6 -> 8 -> 1 -> 5 -> 4 -> 7 -> 8 -> 1
// x = 4
// output: 2 -> 1 -> 1 -> 4 -> 6 -> 8 -> 5 -> 7 -> 8
// x = 1
// output: 1 -> 1 -> 2 -> 4 -> 6 -> 8 -> 5 -> 7 -> 8
// x = 8
// output: 2 -> 6 -> 1 -> 5 -> 4 -> 7 -> 1 -> 8 -> 8

public class Question4 {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList(2, 6, 8, 1, 5, 4, 7, 8, 1);
		ll.print();

		Question4 util = new Question4();
		LinkedList output = util.vet(Integer.parseInt(args[0]), ll);

		output.print();
	}

	public LinkedList vet(int value, LinkedList ll) {
		LinkedList lesser = new LinkedList();
		LinkedList greater = new LinkedList();

		Node n = ll.head();

		while (n != null) {
			if (n.value() < value) {
				lesser.add(n.value());
			}
			else {
				greater.add(n.value());
			}
			n = n.next();
		}

		n = lesser.head();

		while (n.next() != null) {
			n = n.next();
		}

		n.setNext(greater.head());

		return lesser;
	}
}