package com.thiagoh.cci.c2;

import com.thiagoh.data_structures.LinkedList;
import com.thiagoh.data_structures.LinkedList.Node;

public class Q2_2 {

	public static LinkedList.Node findKthLast(LinkedList ll, int kth) {

		if (kth < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (ll == null || ll.head() == null) {
			return null;
		}

		Node p = ll.head();
		Node pDelayed = ll.head();

		while (p != null) {
			if (kth < 0) {
				pDelayed = pDelayed.next;
			}
			p = p.next;
			kth--;
		}

		if (kth >= 0) {
			throw new IndexOutOfBoundsException();
		}

		return pDelayed;
	}

}
