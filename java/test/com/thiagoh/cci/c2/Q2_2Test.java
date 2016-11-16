package com.thiagoh.cci.c2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.LinkedList;

@Test
public class Q2_2Test {

	@Test
	public void remove_duplicates() {

		Assert.assertNull(Q2_2.findKthLast(null, 0));
		Assert.assertNull(Q2_2.findKthLast(new LinkedList(), 0));

		try {
			Assert.assertNull(Q2_2.findKthLast(new LinkedList(), -1));
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IndexOutOfBoundsException);
		}

		LinkedList ll1 = parse("A,B,C,D,E,F,G");
		Assert.assertEquals(Q2_2.findKthLast(ll1, 0).value, "G");
		Assert.assertEquals(Q2_2.findKthLast(ll1, 1).value, "F");
		Assert.assertEquals(Q2_2.findKthLast(ll1, 2).value, "E");
		Assert.assertEquals(Q2_2.findKthLast(ll1, ll1.size() - 1).value, "A");

		try {
			Assert.assertEquals(Q2_2.findKthLast(ll1, ll1.size()).value, "A");
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}

	public static LinkedList parse(String s) {

		String[] nodes = s.split(",");
		LinkedList ll = new LinkedList();

		for (String v : nodes) {
			ll.add(v);
		}

		return ll;
	}
}
