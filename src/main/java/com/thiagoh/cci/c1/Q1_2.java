package com.thiagoh.cci.c1;

public class Q1_2 {

	public static String reverse(String s) {
		if (s == null) {
			return null;
		}
		if (s.length() <= 2) {
			return s;
		}
		char[] a = s.toCharArray();
		int p1 = 0;
		int p2 = a.length - 2;
		char c = 0;
		while (p1 < p2) {
			c = a[p1];
			a[p1++] = a[p2];
			a[p2--] = c;
		}
		return new String(a);
	}
}
