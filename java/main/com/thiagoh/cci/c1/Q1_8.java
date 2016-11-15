package com.thiagoh.cci.c1;

public class Q1_7 {

	public static void zero(int[][] a, int M, int N) {
		if (a == null || a.length <= 0 || M <= 0 || N <= 0) {
			return;
		}
		boolean[] cols = new boolean[M];
		boolean[] rows = new boolean[N];
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (a[y][x] == 0) {
					cols[x] = true;
					rows[y] = true;
				}
			}
		}
		for (int i = 0; i < cols.length; i++) {
			if(cols[i])
			setColToZero(a, i);
		}
		for (int i = 0; i < rows.length; i++) {
			if(rows[i])
			setRowToZero(a, i);
		}
	}

	private static void setRowToZero(int[][] a, int i) {
		for (int j = 0; j < a[i].length; j++) {
			a[i][j] = 0;
		}
	}

	private static void setColToZero(int[][] a, int i) {
		for (int j = 0; j < a.length; j++) {
			a[j][i] = 0;
		}
	}
}
