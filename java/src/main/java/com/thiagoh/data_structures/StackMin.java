package com.thiagoh.data_structures;

import java.util.Comparator;

public class StackMin extends Stack {

	private Stack min;
	private Comparator comparator;

	public StackMin(Comparator c) {
		min = new Stack();
		comparator = c;
	}

	public void push(Object value) {

		if (value != null) {
			Object peek = min.peek();
			
			if (peek != null) {
				int comparation = comparator.compare(value, peek);

				if (comparation < 0) {
					min.push(value);
				}
			} else {
				min.push(value);
			}
		}

		super.push(value);
	}

	public Object pop() {

		Object peek = super.peek();
		Object value = min.peek();

		if (value != null) {

			int comparation = comparator.compare(value, peek);

			if (comparation == 0) {
				min.pop();
			}
		}

		return super.pop();
	}

	public Object min() {
		return min.peek();
	}
}
