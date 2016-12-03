package com.thiagoh.cci.c1;

import java.util.Arrays;

import org.testng.annotations.Test;

@Test
public class Q1_8Test {

	@Test
	public void testRemoveDuplicates() {

		int[][] arr = { { 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1 } };

		print(arr);
		Q1_8.zero(arr, 6, 5);
		print(arr);
	}

	private void print(int[][] arr) {

		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < arr.length; y++) {
			sb.append(Arrays.toString(arr[y])).append("\n");
		}
		System.out.println(sb.toString());
	}
}
