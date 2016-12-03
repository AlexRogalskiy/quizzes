package com.thiagoh.cci.c2;

import java.util.concurrent.atomic.AtomicInteger;

import com.thiagoh.data_structures.HashMap;
import com.thiagoh.data_structures.LinkedList;
import com.thiagoh.data_structures.LinkedList.Node;

public class Q2_8 {

	public static LinkedList.Node findLoopWithHashMap(LinkedList ll1) {

		if (ll1 == null || ll1.head() == null) {
			return null;
		}

		HashMap map = new HashMap();
		Node head = ll1.head();
		Node node = head.next;

		if (node == head) {
			return node;
		}

		while (head != node && node != null) {

			AtomicInteger c = (AtomicInteger) map.get(node);

			if (c == null) {
				c = new AtomicInteger(0);
				map.set(node, c);
			}

			c.incrementAndGet();

			if (c.get() > 1) {
				return node;
			}

			node = node.next;
		}

		return null;
	}

	public static LinkedList.Node findLoopWithPointers(LinkedList ll1) {

		if (ll1 == null || ll1.head() == null) {
			return null;
		}

		Node head = ll1.head();
		Node p1 = ll1.head();
		Node p2 = p1;

		Node pColision = null;
		// Floyd's algorithm for cycle detection
		while (pColision == null && p2 != null && p2.next != null) {

			p1 = p1.next;
			p2 = p2.next.next;

			if (p1 == p2) {
				pColision = p1;
			}

			if (p1 == head) {
				return p1;
			}
		}

		if (p2 == null || p2.next == null) {
			return null;
		}

		p1 = head;
		p2 = pColision;

		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}
}
