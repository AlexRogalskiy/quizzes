package com.thiagoh.data_structures;

import java.util.Comparator;

public class Tree {

	private int length;
	private Node root;
	private Comparator comparator;

	public Tree(Comparator c) {
		length = 0;
		comparator = c;
	}

	public int size() {
		return length;
	}

	public void print() {
		if (root != null) {
			root.print();
		}
	}

	public int height() {
		return root.height();
	}

	@Override
	public String toString() {
		return String.valueOf(root);
	}

	public void add(Object v) {
		if (root == null) {
			root = new Node(v);
		} else {
			root.add(v);
		}
		length++;
	}

	public boolean remove(Object v) {
		if (root != null && root.remove(v)) {
			length--;
			return true;
		}

		return false;
	}

	public class Node {
		public Node left;
		public Node right;
		public Object value;

		public Node(Object value) {
			this.value = value;
		}

		public void print() {

			System.out.println(value);
			if (left != null) {
				left.print();
			}
			if (right != null) {
				right.print();
			}
		}

		public int height() {

			int height = 0;
			int leftHeight = 0;
			int rightHeight = 0;

			if (left != null) {
				leftHeight = left.height();
				height = 1;
			}

			if (right != null) {
				rightHeight = right.height();
				height = 1;
			}

			return height + Math.max(leftHeight, rightHeight);
		}

		@Override
		public String toString() {
			return "[" + print(left) + "<-" + String.valueOf(value) + "->" + print(right) + "]";
		}

		private String print(Node node) {

			if (node == null) {
				return "null";
			}

			return String.valueOf(node.value);
		}

		public Node[] minimum() {

			Node parent = null;
			Node node = this;

			while (node.left != null) {
				parent = node;
				node = node.left;
			}

			return new Node[] { parent, node };
		}

		public Node[] maximum() {

			Node parent = null;
			Node node = this;

			while (node.right != null) {
				parent = node;
				node = node.right;
			}

			return new Node[] { parent, node };
		}

		public void add(Object v) {
			Node node = this;
			int comparation = comparator.compare(node.value, v);

			if (comparation >= 0) {
				// left

				if (node.left == null) {
					node.left = new Node(v);
				} else {
					node.left.add(v);
				}

			} else {
				// right

				if (node.right == null) {
					node.right = new Node(v);
				} else {
					node.right.add(v);
				}
			}
		}

		private Node[] find(Object v) {
			Node node = this;
			Node parent = null;
			int comparation;

			do {

				comparation = comparator.compare(node.value, v);

				if (comparation > 0) {
					// left

					if (node.left == null) {
						return null;
					} else {
						parent = node;
						node = node.left;
					}

				} else if (comparation < 0) {
					// right

					if (node.right == null) {
						return null;
					} else {
						parent = node;
						node = node.right;
					}
				}

			} while (comparation != 0);

			return new Node[] { parent, node };
		}

		public boolean remove(Object v) {

			Node[] nodes = find(v);

			if (nodes == null) {
				return false;
			}

			Node parent = nodes[0];
			Node node = nodes[1];

			if (node.left != null) {
				// find the maximum from left side

				Node[] maximum = node.left.maximum();
				Node parentMax = maximum[0];
				Node max = maximum[1];

				node.value = max.value;

				if (parentMax != null) {
					parentMax.right = max.left;
				}

			} else if (node.right != null) {
				// find the minimum from right side

				Node[] minimum = node.right.minimum();
				Node parentMin = minimum[0];
				Node min = minimum[1];

				node.value = min.value;

				if (parentMin != null) {
					parentMin.left = min.right;
				}
			} else {
				// node with no child

				if (parent.left == node) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			return true;
		}
	}
}
