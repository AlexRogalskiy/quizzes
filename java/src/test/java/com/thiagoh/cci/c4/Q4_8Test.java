package com.thiagoh.cci.c4;

import java.util.Comparator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.Tree;
import com.thiagoh.data_structures.Tree.Node;

@Test
public class Q4_8Test {

	@Test
	public void checkBalanced() {

		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});

			Node n50 = tree.add(50);
			Node n30 = tree.add(30);
			Node n70 = tree.add(70);
			Node n10 = tree.add(10);
			Node n60 = tree.add(60);
			Node n80 = tree.add(80);
			Node n90 = tree.add(90);
			Node n16 = tree.add(16);
			Node n20 = tree.new Node(20); // not in the tree

			Assert.assertEquals(Q4_8.findCommonAncestor(tree, n60, n90), n70);
			Assert.assertEquals(Q4_8.findCommonAncestor(tree, n60, n80), n70);
			Assert.assertEquals(Q4_8.findCommonAncestor(tree, n16, n90), n50);
			Assert.assertEquals(Q4_8.findCommonAncestor(tree, n16, n10), n30);
			Assert.assertEquals(Q4_8.findCommonAncestor(tree, n30, n10), n50);
			
			Assert.assertNull(Q4_8.findCommonAncestor(tree, n30, n20));
			Assert.assertNull(Q4_8.findCommonAncestor(tree, n10, n20));
			Assert.assertNull(Q4_8.findCommonAncestor(tree, n50, n20));
		}
	}
	

}
