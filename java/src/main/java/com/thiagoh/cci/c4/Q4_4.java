package com.thiagoh.cci.c4;

import com.thiagoh.data_structures.Tree;
import com.thiagoh.data_structures.Tree.Node;

public class Q4_4 {

	public static boolean checkBalanced(Tree tree) {

		if (tree == null || tree.root == null) {
			return false;
		}

		return checkBalanced(tree.root);
	}

	private static boolean checkBalanced(Node node) {

		int leftHeight = 0, rightHeight = 0;
		boolean leftBalanced = true, rightBalanced = true;

		if (node.left != null) {
			leftHeight = 1 + node.left.height();
		}

		if (node.right != null) {
			rightHeight = 1 + node.right.height();
		}

		if (Math.abs(rightHeight - leftHeight) > 1) {
			return false;
		}

		if (node.left != null) {
			leftBalanced = checkBalanced(node.left);
		}
		if (node.right != null) {
			rightBalanced = checkBalanced(node.right);
		}

		return leftBalanced && rightBalanced;
	}

}
