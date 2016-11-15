package com.thiagoh.data_structures;

import java.util.Iterator;

public class DoubleLinkedList {

	private int size;
	private Node head;
	
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

	public void add(Object value) {

		if (head == null) {
			Node newNode = new Node(value);
			newNode.prev = newNode;
			newNode.next = newNode;
			head = newNode;
			++size;
			return;
		}

		Node newNode = new Node(value);
		newNode.prev = head.prev;
		newNode.next = head;

		head.prev.next = newNode;
		head.prev = newNode;

		++size;
	}

	public boolean remove(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		Node node = head;

		do {

			if (value.equals(node.next.value)) {
				Node next = node.next.next;
				next.prev = node;
				node.next = next;
				--size;
				return true;
			}

			node = node.next;
		} while (node != head);

		return false;
	}

	public boolean contains(Object value) {

		if (value == null || size == 0) {
			return false;
		}

		Node node = head;

		do {

			if (value.equals(node.value)) {
				return true;
			}
			node = node.next;

		} while (node != head);

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
			return (last == null && head != null) || last != head;
		}

		@Override
		public Object next() {

			Object v = null;

			if (last == null) {
				v = head.value;
				last = head;
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
