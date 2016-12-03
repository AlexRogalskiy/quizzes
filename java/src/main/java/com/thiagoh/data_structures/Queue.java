package com.thiagoh.data_structures;

public class Queue {

	public int size;
	public Node front;
	public Node rear;

	public Queue enqueue(Object value) {
		
		if (front == null) {
			front = new Node(value);
			rear = front;
			++size;

		} else {

			Node newNode = new Node(value);
			rear.next = newNode;
			rear = newNode;
			++size;
		}

		return this;
	}

	public Object dequeue() {
		
		if (front == null) {
			return null;
		} else {
			
			Node retNode = front;
			front = front.next;
			
			if (rear == retNode) {
				rear = null;
			}
			--size;
			return retNode;
		}
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			return this == obj;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
}
