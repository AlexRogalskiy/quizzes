package com.thiagoh.cci.c1;

public class Map {

	Object[] _map;
	int ix;

	public Map() {
		ix = 0;
		_map = new Object[10];
	}

	private Object[][] getArr(Object id) {
		if (id == null) {
			return null;
		}

		int h = id.hashCode();
		Object[][] arr = null;
		for (int i = 0; i < ix; i++) {
			Object[] o = (Object[]) _map[i];
			if ((int) o[0] == h) {
				arr = (Object[][]) o[1];
			}
		}

		return arr;
	}

	public Object get(Object id) {

		Object[][] arr = getArr(id);

		if (arr == null) {
			return null;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0].equals(id)) {
				return arr[i][1];
			}
		}

		return null;
	}

	public void put(Object id, Object v) {

		if (id == null) {
			return;
		}
		Object[][] arr = getArr(id);

		if (arr == null) {
			if (ix >= _map.length) {
				// resize _map
			}
			arr = new Object[10][];
			_map[ix++] = new Object[] { id.hashCode(), arr };
		}

		int arrI = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null || arr[i][0].equals(id)) {
				arrI = i;
				break;
			}
		}
		arr[arrI] = new Object[] { id, v };
	}
}
