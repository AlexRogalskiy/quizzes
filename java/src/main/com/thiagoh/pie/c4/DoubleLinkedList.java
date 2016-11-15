package com.thiagoh.pie.c4;

import java.util.Iterator;

public class DoubleLinkedList {

	private int size;
	private Node first;

	public void add(Object value) {

		if (first == null) {
			Node newNode = new Node(value);
			newNode.prev = newNode;
			newNode.next = newNode;
			first = newNode;
			++size;
			return;
		}

		Node newNode = new Node(value);
		newNode.prev = first.prev;
		newNode.next = first;

		first.prev.next = newNode;
		first.prev = newNode;

		++size;
	}

	public boolean remove(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		Node node = first;

		do {

			if (value.equals(node.next.value)) {
				Node next = node.next.next;
				next.prev = node;
				node.next = next;
				--size;
				return true;
			}

			node = node.next;
		} while (node != first);

		return false;
	}

	public boolean contains(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		Node node = first;

		do {

			if (value.equals(node.value)) {
				return true;
			}
			node = node.next;

		} while (node != first);

		return false;
	}

	public Iterator<Object> iterator() {
		return new Iter();
	}

	private class Iter implements Iterator<Object> {

		private Node last;

		public Iter() {
		}

		@Override
		public boolean hasNext() {
			return (last == null && first != null) || last != first;
		}

		@Override
		public Object next() {

			Object v = null;

			if (last == null) {
				v = first.value;
				last = first;
			} else {
				v = last.value;
			}

			last = last.next;

			return v;
		}

		@Override
		public void remove() {

		}

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
		private Node prev;

		public Node(Object value) {
			this.value = value;
		}
	}
}
