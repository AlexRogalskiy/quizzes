package com.thiagoh.cci.c4;

import com.thiagoh.data_structures.Tree;
import com.thiagoh.data_structures.Tree.Node;

public class Q4_8 {

	public static Node findCommonAncestor(Tree tree, Node n1, Node n2) {

		if (tree == null || tree.root == null) {
			return null;
		}

		return findCommonAncestor(tree.root, n1, n2);
	}

	private static Node findCommonAncestor(Node ancestor, Node n1, Node n2) {

		if (found(ancestor, n1) && found(ancestor, n2)) {

			Node c1 = findCommonAncestor(ancestor.left, n1, n2);
			Node c2 = findCommonAncestor(ancestor.right, n1, n2);

			if (c1 != null) {
				return c1;
			}

			if (c2 != null) {
				return c2;
			}

			return ancestor;
		}

		return null;
	}

	private static boolean found(Node ancestor, Node node) {

		if (ancestor == null) {
			return false;
		}
		if (ancestor.left == node) {
			return true;
		}
		if (ancestor.right == node) {
			return true;
		}
		boolean found = false;
		if (ancestor.left != null) {
			found = found(ancestor.left, node);
		}
		if (found) {
			return true;
		}
		if (ancestor.right != null) {
			found = found(ancestor.right, node);
		}
		return found;
	}

}
