package com.thiagoh.data_structures;

import java.util.Comparator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TreeTest {

	@Test
	public void test_add() {

		Tree tree = new Tree(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		});

		tree.add(10);
		tree.add(5);
		tree.add(18);
		Assert.assertEquals(tree.size(), 3);
		tree.add(3);
		Assert.assertEquals(tree.size(), 4);
		tree.add(6);
		tree.add(12);
		tree.add(13);
		Assert.assertEquals(tree.size(), 7);
	}

	@Test
	public void test_remove() {

		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1.intValue() - o2.intValue();
				}
			});

			tree.add(10);
			tree.add(5);
			tree.add(18);
			tree.add(3);
			tree.add(6);
			tree.add(12);
			tree.add(13);

			Assert.assertFalse(tree.remove(19));
			Assert.assertFalse(tree.remove(1));
			Assert.assertTrue(tree.remove(5));
			Assert.assertEquals(tree.size(), 6);
			Assert.assertFalse(tree.remove(4));
			Assert.assertTrue(tree.remove(10));
			Assert.assertEquals(tree.size(), 5);
		}

		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1.intValue() - o2.intValue();
				}
			});

			tree.add(10);
			tree.add(5);
			tree.add(18);
			tree.add(3);
			tree.add(6);
			tree.add(12);
			tree.add(13);

			Assert.assertTrue(tree.remove(10));
			Assert.assertEquals(tree.size(), 6);
		}

		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1.intValue() - o2.intValue();
				}
			});

			tree.add(10);
			tree.add(5);
			tree.add(18);
			tree.add(3);
			tree.add(6);
			tree.add(6);
			tree.add(12);
			tree.add(10);
			tree.add(13);

			Assert.assertTrue(tree.remove(10));
			Assert.assertEquals(tree.size(), 8);
			Assert.assertTrue(tree.remove(10));
			Assert.assertEquals(tree.size(), 7);
			Assert.assertFalse(tree.remove(10));
			Assert.assertEquals(tree.size(), 7);
		}

		{
			Tree tree = new Tree(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1.intValue() - o2.intValue();
				}
			});

			tree.add(16);
			tree.add(5);
			tree.add(18);
			tree.add(3);
			tree.add(6);
			tree.add(6);
			tree.add(7);
			tree.add(6);
			tree.add(6);
			tree.add(12);
			tree.add(2);
			tree.add(10);
			tree.add(13);

			int size = tree.size();

			Assert.assertFalse(tree.remove(14));
			Assert.assertFalse(tree.remove(15));
			Assert.assertFalse(tree.remove(14));
			Assert.assertFalse(tree.remove(11));
			Assert.assertTrue(tree.remove(10));
			Assert.assertEquals(tree.size(), --size);
			Assert.assertFalse(tree.remove(10));
			Assert.assertEquals(tree.size(), size);
			Assert.assertFalse(tree.remove(10));
			Assert.assertEquals(tree.size(), size);
			Assert.assertTrue(tree.remove(6));
			Assert.assertEquals(tree.size(), --size);
			Assert.assertTrue(tree.remove(13));
			Assert.assertEquals(tree.size(), --size);
			Assert.assertFalse(tree.remove(10));
			Assert.assertEquals(tree.size(), size);
			Assert.assertTrue(tree.remove(7));
			Assert.assertEquals(tree.size(), --size);
		}
	}
}
