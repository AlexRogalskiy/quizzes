package com.thiagoh.data_structures;

public class HashMap {

	private List[] table;
	private int tableSize;
	private int length;

	private static class TableData {

		private Object key;
		private Object value;
	}

	public HashMap() {
		length = 0;
		tableSize = 10;
		table = new List[tableSize];
	}

	public int size() {
		return length;
	}

	public List keys() {

		List keys = new List(size());

		for (int i = 0; i < table.length; i++) {
			List list = table[i];
			if (list != null) {
				for (int j = 0; j < list.size(); j++) {
					TableData tableData = (TableData) list.get(j);
					keys.add(tableData.key);
				}
			}
		}

		return keys;
	}

	public void set(Object key, Object value) {
		if (key == null) {
			throw new IllegalArgumentException();
		}

		if (length > tableSize * 10) {
			// increase table capacity
			increaseTableCapacity();
		}

		int ix = get_ix(key, tableSize);

		TableData tableData = new TableData();
		tableData.key = key;
		tableData.value = value;

		List list = table[ix];

		if (list == null) {
			list = new List(10);
			table[ix] = list;
		}

		for (int i = 0; i < list.size(); i++) {

			TableData _tableData = (TableData) list.get(i);

			if (_tableData.key.equals(key)) {
				list.set(i, tableData);
				return;
			}
		}

		list.add(tableData);
		length++;
	}

	private void increaseTableCapacity() {

		int newTableSize = tableSize * 10;

		System.out.println("Increased capacity to " + newTableSize);

		List[] newTable = new List[newTableSize];
		for (List list : table) {
			for (int i = 0; i < list.size(); i++) {
				TableData tableData = (TableData) list.get(i);
				int ix = get_ix(tableData.key, newTableSize);
				List _innerList = newTable[ix];
				if (_innerList == null) {
					_innerList = new List(10);
					newTable[ix] = _innerList;
				}
				_innerList.add(tableData);
			}
		}
		table = newTable;
		tableSize = newTableSize;
	}

	public Object get(Object key) {

		if (key == null) {
			throw new IllegalArgumentException();
		}

		int ix = get_ix(key, tableSize);

		List list = table[ix];

		if (list == null) {
			return null;
		}

		for (int i = 0; i < list.size(); i++) {

			TableData tableData = (TableData) list.get(i);

			if (tableData.key.equals(key)) {
				return tableData.value;
			}
		}

		return null;
	}

	private int get_ix(Object key, int tableSize) {
		int hashCode = key.hashCode();
		int ix = Math.abs(hashCode % tableSize);
		return ix;

	}
}
