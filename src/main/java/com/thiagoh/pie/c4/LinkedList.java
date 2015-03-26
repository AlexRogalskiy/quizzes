package com.thiagoh.pie.c4;

public class LinkedList {

	private int size;
	private Node first;

	public void add(Object value) {

		if (first == null) {
			first = new Node(value);
			++size;
			return;
		}

		Node node = first;

		while (node.next != null) {
			node = node.next;
		}

		node.next = new Node(value);
		++size;
	}

	public boolean remove(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		if (value.equals(first.value)) {
			first = first.next;
			--size;
			return true;
		}

		Node node = first;

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

		Node node = first;

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

	private class Node {

		private Object value;
		private Node next;

		public Node(Object value) {
			this.value = value;
		}
	}
}
