package com.thiagoh.cci.c4;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.GraphSearch.Node;

@Test
public class Q4_1Test {

	@Test
	public void hasPath() {

		// subgraph 1
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);

		node1.children = new Node[] { node2, node4 };
		node4.children = new Node[] { node3 };
		node3.children = new Node[] { node5, node6 };
		node6.children = new Node[] { node7, node8, node9 };

		// subgraph 2
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		
		Assert.assertTrue(Q4_1.hasPath(node1, node2));
		Assert.assertTrue(Q4_1.hasPath(node1, node3));
		Assert.assertTrue(Q4_1.hasPath(node1, node4));
		Assert.assertTrue(Q4_1.hasPath(node1, node5));
		Assert.assertTrue(Q4_1.hasPath(node1, node6));
		Assert.assertTrue(Q4_1.hasPath(node1, node7));
		Assert.assertTrue(Q4_1.hasPath(node1, node8));
		Assert.assertTrue(Q4_1.hasPath(node1, node9));
		
		Assert.assertFalse(Q4_1.hasPath(node1, node10));
		Assert.assertFalse(Q4_1.hasPath(node1, node11));
		Assert.assertFalse(Q4_1.hasPath(node1, node12));
		Assert.assertFalse(Q4_1.hasPath(node1, node13));
	}
}
