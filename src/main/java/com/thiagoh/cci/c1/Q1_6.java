package com.thiagoh.cci.c1;

public class Q1_6 {

	public static void rotateLeft(int[][] a) {
		if (a == null || a.length < 2) {
			return;
		}
		int W = a.length - 1;
		for (int D = 0; D < Math.floor(a.length / 2.0); D++) {
			for (int x = 0; x + D < W - D; x++) {
				int l1 = a[D + x][D] ;
				int l2 = a[W - D][x + D] ;
				int l3 = a[W - x - D][W - D] ;
				int l4 = a[D][W - x - D] ;
				a[D + x][D] = l2; // l1 <- l2
				a[W - D][x + D] = l3; // l2 <- l3
				a[W - x - D][W - D] = l4; // l3 <- l4
				a[D][W - x - D] = l1; // l4 <- l1
			}
		}
	}
	
	public static void rotateRight(int[][] a) {
		if (a == null || a.length < 2) {
			return;
		}
		int W = a.length - 1;
		for (int D = 0; D < Math.floor(a.length / 2.0); D++) {
			for (int x = 0; x + D < W - D; x++) {
				int l1 = a[D + x][D] ;
				int l2 = a[W - D][x + D] ;
				int l3 = a[W - x - D][W - D] ;
				int l4 = a[D][W - x - D] ;
				a[D + x][D] = l4; //l1 <- l4
				a[W - D][x + D] = l1; // l2 <- l1
				a[W - x - D][W - D] = l2; // l3 <- l2
				a[D][W - x - D] = l3; // l4 <- l3
			}
		}
	}
}
