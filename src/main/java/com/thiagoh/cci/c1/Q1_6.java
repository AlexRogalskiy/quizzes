package com.thiagoh.cci.c1;

public class Q1_6 {

	public static void rotate(int[][] a) {
		if (a == null || a.length < 2) {
			return;
		}
		int W = a.length - 1;
		for (int D = 0; D < Math.floor(a.length / 2.0); D++) {
			for (int x = 0; x + D < W - D; x++) {
				int tmp = a[D + x][D];
				a[D + x][D] = a[W - D][x + D];
				a[W - D][x + D] = a[W - x - D][W - D];
				a[W - x - D][W - D] = a[D][W - x - D];
				a[D][W - x - D] = tmp;
			}
		}
	}
}
