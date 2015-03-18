package com.thiagoh.cci.c1;

public class Q1_6 {

	public static void rotate(int[][] a) {
		if (a == null || a.length < 2) {
			return;
		}
		int D = 0;
		double N = a.length;
		int W = (int) (N - 1);
		while (D < Math.floor(N / 2.0)) {
			int x = 0;
			while (x + D < W - D) {
				int tmp = a[D + x][D];
				a[D + x][D] = a[W - D][x + D];
				a[W - D][x + D] = a[W - x - D][W - D];
				a[W - x - D][W - D] = a[D][W - x - D];
				a[D][W - x - D] = tmp;
				x++;
			}
			D++;
		}
	}
}
