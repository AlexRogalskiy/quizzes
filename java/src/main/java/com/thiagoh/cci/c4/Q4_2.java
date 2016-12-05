package com.thiagoh.cci.c4;

import java.util.Comparator;

import com.thiagoh.data_structures.Tree;

public class Q4_2 {

	public static Tree minimumHeightTree(int[] arr) {

		Tree tree = new Tree(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		return minimumHeightTree(arr, 0, arr.length - 1, tree);
	}

	private static Tree minimumHeightTree(int[] arr, int left, int right, Tree tree) {

		if (right - left <= 1) {
			tree.add(arr[left]);
			if (right > left) {
				tree.add(arr[right]);
			}
			return tree;
		}

		int mid = (int) Math.floor((right + left) / 2.0);
		tree.add(arr[mid]);

		minimumHeightTree(arr, left, mid - 1, tree);
		minimumHeightTree(arr, mid + 1, right, tree);

		return tree;
	}
}
