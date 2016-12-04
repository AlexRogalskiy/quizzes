package com.thiagoh.data_structures;

public class GraphSearch {

	private static class NodeWrapper {
		Node node;
		boolean visited;

		public static GraphSearch.NodeWrapper wrap(Node node) {

			GraphSearch.NodeWrapper w = new NodeWrapper();
			w.node = node;
			w.visited = true;

			return w;
		}
	}
	
	public static interface Visitor {
		public void visit(Node node);
	}

	public static class Node {

		public int value;
		public Node[] children;

		public Node(int v) {
			this.value = v;
		}
	}

	public static void bfs(Node root, Visitor visitor) {

		Queue q = new Queue();

		q.enqueue(root);

		while (!q.isEmpty()) {

			NodeWrapper wrapper = NodeWrapper.wrap((Node) q.dequeue());
			visitor.visit(wrapper.node);
			wrapper.visited = true;

			if (wrapper.node.children != null) {

				for (Node child : wrapper.node.children) {
					q.enqueue(child);
				}
			}
		}
	}
}

