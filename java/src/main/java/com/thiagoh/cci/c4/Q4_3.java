package com.thiagoh.cci.c4;

import com.thiagoh.data_structures.HashMap;
import com.thiagoh.data_structures.List;
import com.thiagoh.data_structures.Tree;
import com.thiagoh.data_structures.Tree.Node;

public class Q4_3 {

	public static HashMap getNodesByHeight(Tree tree) {

		if (tree == null || tree.root == null) {
			return null;
		}

		HashMap map = new HashMap();

		Node node = tree.root;

		return getNodesByHeight(node, map, 0);
	}

	private static HashMap getNodesByHeight(Node node, HashMap map, int height) {

		List list = (List) map.get(height);

		if (list == null) {
			list = new List(10);
			map.set(height, list);
		}

		list.add(node);

		if (node.left != null) {
			getNodesByHeight(node.left, map, height + 1);
		}

		if (node.right != null) {
			getNodesByHeight(node.right, map, height + 1);
		}

		return map;
	}
}
