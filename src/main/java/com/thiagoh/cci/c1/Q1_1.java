package com.thiagoh.cci.c1;

public class Q1_1 {

	public static boolean unique(String s) {

		if (s == null) {
			return true;
		}

		boolean[] b = new boolean[100];
		int aPos = (int) 'a';

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int p = ((int) c) - aPos;
			if (b[p])
				return false;
			b[p] = true;
		}
		return true;
	}
}
