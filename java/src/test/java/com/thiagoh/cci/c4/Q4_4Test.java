package com.thiagoh.cci.c4;

import java.util.Comparator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.Tree;

@Test
public class Q4_4Test {

	@Test
	public void checkBalanced() {
		
		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});
			
			Assert.assertFalse(Q4_4.checkBalanced(tree));
		}
		
		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});
			
			tree.add(6);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
		}
		
		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});
			
			tree.add(6);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			
			tree.add(8);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			
			tree.add(16);
			Assert.assertFalse(Q4_4.checkBalanced(tree));
		}

		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});

			tree.add(6);
			tree.add(5);
			tree.add(3);
			tree.add(7);

			Assert.assertTrue(Q4_4.checkBalanced(tree));
			
			tree.add(8);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			
			tree.add(16);
			Assert.assertFalse(Q4_4.checkBalanced(tree));
		}
		
		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});
			
			tree.add(50);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			tree.add(30);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			tree.add(70);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			tree.add(10);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			tree.add(60);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			tree.add(80);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			tree.add(90);
			Assert.assertTrue(Q4_4.checkBalanced(tree));
			tree.add(16);
			Assert.assertFalse(Q4_4.checkBalanced(tree));
		}
	}

}
