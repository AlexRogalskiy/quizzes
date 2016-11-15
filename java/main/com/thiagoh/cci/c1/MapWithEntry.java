package com.thiagoh.cci.c1;

public class MapWithEntry {

	Object[] _map;
	int ix;

	public MapWithEntry() {
		ix = 0;
		_map = new Object[10];
	}

	private Entry[] getEntries(Object id) {
		if (id == null) {
			return null;
		}

		int h = id.hashCode();
		Entry[] arr = null;
		for (int i = 0; i < ix; i++) {
			Object[] o = (Object[]) _map[i];
			if ((int) o[0] == h) {
				arr = (Entry[]) o[1];
			}
		}

		return arr;
	}

	public Object get(Object id) {

		Entry[] entries = getEntries(id);

		if (entries == null) {
			return null;
		}

		for (int i = 0; i < entries.length; i++) {
			if (entries[i].id.equals(id)) {
				return entries[i].value;
			}
		}

		return null;
	}

	public void put(Object id, Object v) {

		if (id == null) {
			return;
		}
		Entry[] entries = getEntries(id);
		if (entries == null) {
			if (ix >= _map.length) {
				// resize _map
			}
			entries = new Entry[10];
			_map[ix++] = new Object[] { id.hashCode(), entries };
		}

		int arrI = 0;
		for (int i = 0; i < entries.length; i++) {
			if (entries[i] == null || entries[i].id.equals(id)) {
				arrI = i;
				break;
			}
		}
		
		entries[arrI] = new Entry(id, v);
	}

	public static class Entry {

		private Object id;
		private Object value;

		public Entry(Object id, Object value) {
			this.id = id;
			this.value = value;
		}
	}
}
