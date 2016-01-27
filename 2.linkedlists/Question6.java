// given a circular linked list, implement an algorithm which returns the node at the beginning of the loop

// definition

// circular linked list: a (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list

// example

// input: A -> B -> C -> D -> E -> C [the same C earlier]

// output: C

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Question6 {
	
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);

		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
		e.setNext(c);

		Question6 util = new Question6();

		util.findBadNode(a);

		// Character x = util.findBadNode(a);

		// System.out.println("The bad node was -> " + x);
	}

	// assume all nodes have unique values
	public void findBadNode(Node head) {
		Node b = head;
		Node t = head;

		Map<String, Integer> log = new HashMap<String, Integer>();

		// they start on the same node..
		int collisionCounter = -1;

		// really, the exit for collisionCounter should be at 3, but i don't like the number 3
		while (collisionCounter < 4) {
			String key = "" + b.value() + t.value();
			if (! log.containsKey(key)) {
				log.put(key, 1);
			}
			else {
				log.put(key, log.get(key) + 1);
			}
			if (b.value() == t.value()) {
				collisionCounter++;
			}
			b = b.next();
			t = t.next().next();
		}

		Set<Character> singulars = new HashSet<Character>();
		Set<Character> repetitions = new HashSet<Character>();

		for (String key : log.keySet()) {
			String[] nodes = key.split("");
			if (log.get(key) > 1) {
				for (String n : nodes) {
					repetitions.add(n.charAt(0));
				}
			}
			else {
				for (String n : nodes) {
					singulars.add(n.charAt(0));
				}
			}
		}

		singulars.retainAll(repetitions);

		Iterator<Character> chars = singulars.iterator();

		while (chars.hasNext()) {
			System.out.println(chars.next());
		}

	}
}