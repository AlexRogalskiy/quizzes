package com.thiagoh.cci.c4;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.Tree;

@Test
public class Q4_2Test {

	@Test
	public void minimumHeightTree() {

		// visually tested by https://www.cs.usfca.edu/~galles/visualization/BST.html
		{
			int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			Tree tree = Q4_2.minimumHeightTree(arr);
			Assert.assertEquals(tree.height(), 3);
		}

		{
			int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			Tree tree = Q4_2.minimumHeightTree(arr);
			Assert.assertEquals(tree.height(), 3);
		}

		{
			int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
			Tree tree = Q4_2.minimumHeightTree(arr);
			Assert.assertEquals(tree.height(), 3);
		}

		{
			int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
			Tree tree = Q4_2.minimumHeightTree(arr);
			Assert.assertEquals(tree.height(), 4);
		}

		{
			int[] arr = new int[] { 4, 67, 80, 110, 131, 178, 222, 340, 350, 351, 352, 400, 402, 404, 450, 460, 480,
					501, 502, 555, 558, 780, 889, 900, 901 };
			Tree tree = Q4_2.minimumHeightTree(arr);
			Assert.assertEquals(tree.height(), 4);
		}
	}
}
