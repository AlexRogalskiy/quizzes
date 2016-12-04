package com.thiagoh.cci.c4;

import com.thiagoh.data_structures.GraphSearch;
import com.thiagoh.data_structures.GraphSearch.Node;
import com.thiagoh.data_structures.GraphSearch.Visitor;

public class Q4_1 {

	public static boolean hasPath(final Node n1, final Node n2) {

		class VisitorImpl implements Visitor {

			boolean found = false;

			public void visit(Node node) {

				if (node.value == n2.value) {
					found = true;
					System.out.println("Found " + n1.value + "/" + n2.value);
				}
			}
		}

		VisitorImpl visitor = new VisitorImpl();

		GraphSearch.bfs(n1, visitor);

		return visitor.found;
	}
}
