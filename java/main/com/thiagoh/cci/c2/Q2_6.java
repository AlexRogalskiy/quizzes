package com.thiagoh.cci.c2;

import com.thiagoh.data_structures.LinkedList;

public class Q2_6 {

	public static boolean isPalindrome(LinkedList ll) {

		if (ll == null || ll.head() == null) {
			return false;
		}

		LinkedList.Node p = ll.head();
		LinkedList.Node pDelayed = ll.head();
		boolean advance = true;
		int size = ll.size();
		char[] s = new char[size];
		int ix = 0;

		while (pDelayed != null && ix >= 0) {

			if (p == null) {
				// pDelayed in the middle

				if (s[ix--] != (char) pDelayed.value) {
					return false;
				} else {
					pDelayed = pDelayed.next;
				}

			} else {

				p = p.next;

				if ((advance = !advance)) {
					s[ix++] = (char) pDelayed.value;
					pDelayed = pDelayed.next;
				}
				if (p == null) {
					ix--;

					if ((size & 1) == 1) { // odd string
						pDelayed = pDelayed.next;
					}
				}
			}
		}

		return true;
	}
}
