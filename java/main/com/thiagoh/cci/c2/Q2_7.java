package com.thiagoh.cci.c2;

import com.thiagoh.data_structures.LinkedList;
import com.thiagoh.data_structures.LinkedList.Node;

public class Q2_7 {

	public static LinkedList.Node converge(LinkedList ll1, LinkedList ll2) {

		if (ll1 == null || ll1.head() == null || ll2 == null || ll2.head() == null) {
			return null;
		}

		int s1 = 0;
		int s2 = 0;
		Node n1 = ll1.head();
		Node n2 = ll2.head();

		for (; n1 != null; s1++, n1 = n1.next) {
		}
		for (; n2 != null; s2++, n2 = n2.next) {
		}
		n1 = ll1.head();
		n2 = ll2.head();

		if (s1 > s2) {
			for (; s1 > s2; s1--, n1 = n1.next) {
			}

		} else if (s2 > s1) {
			for (; s2 > s1; s2--, n2 = n2.next) {
			}
		}

		while (n1 != null) {

			if (n1 == n2) {
				return n1;
			}

			n1 = n1.next;
			n2 = n2.next;
		}

		return null;
	}
}
