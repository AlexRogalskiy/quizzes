package com.thiagoh.cci.c2;

import java.util.Optional;

import com.thiagoh.data_structures.HashMap;
import com.thiagoh.data_structures.LinkedList;
import com.thiagoh.data_structures.LinkedList.Node;

public class Q2_1 {

	public static LinkedList removeDuplicates(LinkedList ll) {

		if (ll == null || ll.head() == null || ll.head().next == null) {
			return ll;
		}

		HashMap map = new HashMap();
		Node node = ll.head();
		Node prev = null;

		while (node != null) {

			int c = (int) Optional.ofNullable(map.get(node.value)).orElse(0);

			if (c == 0) {
				map.set(node.value, ++c);
				prev = node;
				node = node.next;
			} else {
				prev.next = node.next;
				node = node.next;
			}
		}

		return ll;
	}

	public static LinkedList removeDuplicatesWithoutHash(LinkedList ll) {

		if (ll == null || ll.head() == null || ll.head().next == null) {
			return ll;
		}

		Node node = ll.head();

		while (node != null) {

			Node prev = node;
			Node nodeAhead = node.next;

			while (nodeAhead != null) {
				if (node.value.equals(nodeAhead.value)) {
					prev.next = nodeAhead.next;
				} else {
					prev = nodeAhead;
				}
				nodeAhead = nodeAhead.next;
			}

			node = node.next;
		}

		return ll;
	}
}
