package com.thiagoh.data_structures;

public class LinkedList {

	private int size;
	private Node head;

	public Node head() {
		return head;
	}

	public Object get(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node cur = head;

		for (int i = 0; i < index && cur != null; i++, cur = cur.next) {
			;
		}

		if (cur == null) {
			return null;
		}
		return cur.value;
	}

	public LinkedList add(Object value) {

		if (head == null) {
			head = new Node(value);
			++size;

		} else {

			Node node = head;

			while (node.next != null) {
				node = node.next;
			}

			node.next = new Node(value);
			++size;
		}
		
		return this;
	}

	public boolean remove(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		if (value.equals(head.value)) {
			head = head.next;
			--size;
			return true;
		}

		Node node = head;

		while (node.next != null) {
			if (value.equals(node.next.value)) {
				node.next = node.next.next;
				--size;
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public boolean contains(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		Node node = head;

		while (node != null) {
			if (value.equals(node.value)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static class Node {

		public Object value;
		public Node next;

		public Node(Object value) {
			this.value = value;
		}
	}
}
