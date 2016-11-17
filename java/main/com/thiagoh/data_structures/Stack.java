package com.thiagoh.data_structures;

public class Stack {

	private Node head;
	private int length;

	public Stack() {
		length = 0;
	}

	public class Node {

		private Object value;
		private Node next;

		public Node(Object v) {
			value = v;
		}
	}

	public void push(Object value) {

		if (head == null) {
			head = new Node(value);
		} else {

			Node newHead = new Node(value);
			newHead.next = head;
			head = newHead;
		}
		length++;
	}

	public Object peek() {
		if (head != null) {
			return head.value;
		}

		return null;
	}

	public Object pop() {

		if (head == null) {
			return null;
		} else {

			Node poped = head;
			head = head.next;
			length--;
			return poped.value;
		}
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int size() {
		return length;
	}
}
