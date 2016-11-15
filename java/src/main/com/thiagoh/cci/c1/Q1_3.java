package com.thiagoh.cci.c1;

public class Q1_3 {

	public static char[] removeDuplicates(char[] a) {
		if (a == null || a.length <= 1) {
			return a;
		}
		int p = 1;
		int n = 1;
		while (n < a.length) {
			boolean b = false;
			for (int i = 0; i < p && !b; i++)
				if (a[n] == a[i])
					b = true;
			if (!b) {
				a[p++] = a[n];
			}
			n++;
		}
		while (p < a.length)
			a[p++] = '\0';
		return a;
	}

	public static char[] removeDuplicates2(char[] s) {
		if (s == null || s.length <= 1) {
			return s;
		}
		return s;
	}
}
