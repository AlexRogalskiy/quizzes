package com.thiagoh.cci.c3;

import com.thiagoh.data_structures.Stack;

public class Q3_5 {

	public static void sortStack(Stack s1) {

		Stack s2 = new Stack();
		Integer min = null;
		Integer lastMin = null;

		while (!s1.isEmpty()) {

			min = null;

			while (!s1.isEmpty()) {

				int cur = ((Integer) s1.pop()).intValue();

				if (min == null || cur < min) {
					min = cur;
				}

				s2.push(cur);
			}

			int cur = ((Integer) s2.peek()).intValue();

			while (lastMin == null || cur > lastMin) {

				if (cur != min) {
					s1.push(cur);
				}

				s2.pop();

				if (s2.isEmpty()) {
					break;
				}

				cur = ((Integer) s2.peek()).intValue();
			}

			s2.push(min);
			lastMin = min;
		}

		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
}
