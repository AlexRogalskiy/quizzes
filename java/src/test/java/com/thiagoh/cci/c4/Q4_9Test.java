package com.thiagoh.cci.c4;

import java.util.Arrays;
import java.util.Comparator;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import com.thiagoh.data_structures.Tree;

@Test
public class Q4_9Test {

	@Test
	public void getAllPossibleArrays() {

		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});

			tree.add(5);
			tree.add(3);
			tree.add(8);
			tree.add(2);
			tree.add(4);
			tree.add(7);
			tree.add(10);

			int[][] allPossibleArrays = Q4_9.getAllPossibleArrays(tree);

			for (int i = 0; i < allPossibleArrays.length; i++) {
				System.out.println(Arrays.toString(allPossibleArrays[i]));
			}

			Assert.assertEquals(allPossibleArrays.length, 8);

			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 3, 8, 2, 4, 7, 10 }));
			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 8, 3, 2, 4, 7, 10 }));
			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 3, 8, 4, 2, 7, 10 }));
			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 8, 3, 4, 2, 7, 10 }));
			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 3, 8, 2, 4, 10, 7 }));
			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 8, 3, 2, 4, 10, 7 }));
			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 3, 8, 4, 2, 10, 7 }));
			Assert.assertTrue(contains(allPossibleArrays, new int[] { 5, 8, 3, 4, 2, 10, 7 }));
		}
	}

	private boolean contains(int[][] allPossibleArrays, int[] is) {

		for (int i = 0; i < allPossibleArrays.length; i++) {

			int[] cur = allPossibleArrays[i];
			boolean found = true;
			for (int j = 0; j < is.length && found; j++) {
				if (cur[j] != is[j]) {
					found = false;
				}
			}
			if (found) {
				return true;
			}
		}

		return false;
	}

}
