package com.thiagoh.cci.c4;

import java.util.Comparator;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import com.thiagoh.data_structures.HashMap;
import com.thiagoh.data_structures.List;
import com.thiagoh.data_structures.Tree;
import com.thiagoh.data_structures.Tree.Node;

@Test
public class Q4_3Test {

	@Test
	public void getNodesByHeight() {

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
			tree.add(9);
			tree.add(8);
			tree.add(2);
			tree.add(4);
			tree.add(1);

			HashMap nodesByHeight = Q4_3.getNodesByHeight(tree);

			assertEquals((List) nodesByHeight.get(0), new List(10).add(6));
			assertEquals((List) nodesByHeight.get(1), new List(10).add(5).add(7));
			assertEquals((List) nodesByHeight.get(2), new List(10).add(3).add(9));
			assertEquals((List) nodesByHeight.get(3), new List(10).add(2).add(4).add(8));
			assertEquals((List) nodesByHeight.get(4), new List(10).add(1));
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
			tree.add(9);
			tree.add(8);
			tree.add(2);
			tree.add(4);
			tree.add(1);
			
			tree.add(89);
			tree.add(10);
			tree.add(12);
			tree.add(13);
			tree.add(14);
			tree.add(20);
			tree.add(16);
			tree.add(22);
			tree.add(23);
			

			HashMap nodesByHeight = Q4_3.getNodesByHeight(tree);

			assertEquals((List) nodesByHeight.get(0), new List(10).add(6));
			assertEquals((List) nodesByHeight.get(1), new List(10).add(5).add(7));
			assertEquals((List) nodesByHeight.get(2), new List(10).add(3).add(9));
			assertEquals((List) nodesByHeight.get(3), new List(10).add(2).add(4).add(8).add(89));
			assertEquals((List) nodesByHeight.get(4), new List(10).add(1).add(10));
			assertEquals((List) nodesByHeight.get(7), new List(10).add(14));
			assertEquals((List) nodesByHeight.get(9), new List(10).add(16).add(22));

		}
	}

	private void assertEquals(List list1, List list2) {

		Assert.assertTrue(list1 != null);
		Assert.assertTrue(list2 != null);
		Assert.assertEquals(list1.size(), list2.size());

		int[] arr1 = new int[list1.size()];
		int[] arr2 = new int[list2.size()];
		for (int i = 0; i < list1.size(); i++) {
			arr1[i] = (int) ((Node) list1.get(i)).value;
			arr2[i] = (int) list2.get(i);
		}

		ArrayAsserts.assertArrayEquals(arr1, arr2);
	}

}
