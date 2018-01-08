package com.thiagoh.data_structures;

public class List {

	private Object[] values;
	private int capacity;
	private int length;

	public List(int initialCapacity) {
		this.length = 0;
		this.capacity = initialCapacity;
		this.values = new Object[initialCapacity];
	}

	public int size() {
		return length;
	}

	public List clone() {
		List list = new List(length);
		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
		return list;
	}

	public Object get(int index) {

		if (index >= length || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return values[index];
	}

	public List add(Object value) {

		if (value == null) {
			return this;
		}

		if (length + 1 >= capacity) {
			int newCapacity = capacity * 2;
			Object[] newValues = new Object[newCapacity];
			System.arraycopy(values, 0, newValues, 0, length);
			values = newValues;
			capacity = newCapacity;
		}

		values[length] = value;
		length++;

		return this;
	}

	public List set(int index, Object value) {

		if (index < 0 || index >= length) {
			throw new ArrayIndexOutOfBoundsException();
		}

		values[index] = value;

		return this;
	}
}
