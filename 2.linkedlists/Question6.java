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
		int badNodeIndex = 14;
		Node head = new Node(0);
		Node previous = head;
		Node badNode = null;

		for (int x = 1; x < 20; x++) {
			Node node = new Node(x);
			previous.setNext(node);
			previous = node;
			if (x == badNodeIndex) {
				badNode = node;
			}
		}

		// get tail
		Node tail = head;
		while (tail.next() != null) {
			tail = tail.next();
		}

		tail.setNext(badNode);

		Question6 util = new Question6();

		Node x = util.findBadNode(head);

		System.out.println("The bad node was -> " + x.value());
	}

	public Node findBadNode(Node head) {
		Node s = head.next();
		Node f = head.next().next();

		while (s.value() != f.value()) {
			System.out.println("\t> " + s.value() + " " + f.value() + " <");
			s = s.next();
			f = f.next().next();
		}

		// given a looped linked list of unlooped length K and looped length L
		// by the time the slow node has walked K steps and is at the bad node,
		// the fast node has walked 2K steps and is K mod L steps into the loop
		// the fast node is L - (K mod L) steps behind the slow node
		// the fast node catches up 1 step every turn
		// when the nodes meet, they are L - (K mod L) steps into the node (away from the bad node looking back)
		// the nodes are K mod L steps away from the bad looking forward
		// we move one node to the beginning of the linked list - it requires K steps to reach the bad node
		// the other node, still in the loop, still K mod L steps away from the bad node, will walk K steps and reach the bad node
		// the nodes will meet at the bad node
		// at this point, return the node

		s = head;
		while (s.value() != f.value()) {
			System.out.println("\t> " + s.value() + " " + f.value() + " <");
			s = s.next();
			f = f.next();
		}

		return s;
	}

	// this is an iffy algorithm. hacky. but it still works, i think
	// public void findBadNode(Node head) {
	// 	Node b = head;
	// 	Node t = head;

	// 	Map<String, Integer> log = new HashMap<String, Integer>();

	// 	// they start on the same node..
	// 	int collisionCounter = -1;

	// 	// really, the exit for collisionCounter should be at 3, but i don't like the number 3
	// 	while (collisionCounter < 4) {
	// 		String key = "" + b.value() + t.value();
	// 		if (! log.containsKey(key)) {
	// 			log.put(key, 1);
	// 		}
	// 		else {
	// 			log.put(key, log.get(key) + 1);
	// 		}
	// 		if (b.value() == t.value()) {
	// 			collisionCounter++;
	// 		}
	// 		b = b.next();
	// 		t = t.next().next();
	// 	}

	// 	Set<Character> singulars = new HashSet<Character>();
	// 	Set<Character> repetitions = new HashSet<Character>();

	// 	for (String key : log.keySet()) {
	// 		String[] nodes = key.split("");
	// 		if (log.get(key) > 1) {
	// 			for (String n : nodes) {
	// 				repetitions.add(n.charAt(0));
	// 			}
	// 		}
	// 		else {
	// 			for (String n : nodes) {
	// 				singulars.add(n.charAt(0));
	// 			}
	// 		}
	// 	}

	// 	singulars.retainAll(repetitions);

	// 	Iterator<Character> chars = singulars.iterator();

	// 	while (chars.hasNext()) {
	// 		System.out.println(chars.next());
	// 	}

	// }
}