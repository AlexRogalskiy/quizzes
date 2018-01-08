package com.thiagoh.cci.c4;

import com.thiagoh.data_structures.List;
import com.thiagoh.data_structures.Tree;
import com.thiagoh.data_structures.Tree.Node;

public class Q4_9 {

	public static int[][] getAllPossibleArrays(Tree tree) {

		if (tree == null || tree.root == null) {
			return null;
		}

		List listOfLists = new List(10);
		List list = new List(10).add(tree.root.value);
		listOfLists.add(list);

		getAllPossibleArrays(tree.root, listOfLists);

		int[][] arr = new int[listOfLists.size()][];

		for (int i = 0; i < listOfLists.size(); i++) {

			List innerList = (List) listOfLists.get(i);
			arr[i] = new int[innerList.size()];

			for (int j = 0; j < innerList.size(); j++) {
				arr[i][j] = (int) innerList.get(j);
			}
		}

		return arr;
	}

	private static List getAllPossibleArrays(Node node, List listOfLists) {

		int len = listOfLists.size();

		for (int i = 0; i < len; i++) {

			List list = (List) listOfLists.get(i);
			List clone = null;

			if (node.right != null && node.left != null) {
				clone = list.clone();
			}
			
			if (node.left != null) {
				list.add(node.left.value);
			}
			if (node.right != null) {
				list.add(node.right.value);
			}

			if (node.right != null && node.left != null) {

				listOfLists.add(clone);

				clone.add(node.right.value);
				clone.add(node.left.value);
			}
		}

		if (node.left != null) {
			getAllPossibleArrays(node.left, listOfLists);
		}

		if (node.right != null) {
			getAllPossibleArrays(node.right, listOfLists);
		}

		return listOfLists;
	}

}
