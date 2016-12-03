package com.thiagoh.cci.c2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.LinkedList;
import com.thiagoh.data_structures.LinkedList.Node;

@Test
public class Q2_7Test {

	@Test
	public void converge() {

		Assert.assertNull(Q2_7.converge(null, null));

		{
			LinkedList ll1 = new LinkedList().add(1).add(2);
			LinkedList ll2 = new LinkedList().add(3).add(4);
			Assert.assertNull(Q2_7.converge(ll1, ll2));
		}

		{
			LinkedList ll1 = new LinkedList().add(1).add(2).add(1).add(2);
			LinkedList ll2 = new LinkedList().add(3).add(4).add(3).add(4).add(3).add(4).add(3).add(4);
			
			Assert.assertNull(Q2_7.converge(ll1, ll2));
		}

		{
			LinkedList ll1 = new LinkedList().add(1).add(2).add(1).add(2);
			LinkedList ll2 = new LinkedList().add(3).add(4).add(3).add(4).add(3).add(4).add(3).add(4);
			LinkedList ll3 = new LinkedList().add(10).add(20).add(30).add(40);

			addAtEnd(ll1, ll3);
			addAtEnd(ll2, ll3);

			Assert.assertEquals(Q2_7.converge(ll1, ll2), ll3.head());Assert.assertEquals(Q2_7.converge(ll1, ll3), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll3, ll2), ll3.head());
		}

		{
			LinkedList ll1 = new LinkedList().add(1);
			LinkedList ll2 = new LinkedList().add(3).add(4).add(null).add(4).add(3).add(4).add(3).add(4);
			LinkedList ll3 = new LinkedList().add(10).add(20).add(30).add(40);

			addAtEnd(ll1, ll3);
			addAtEnd(ll2, ll3);

			Assert.assertEquals(Q2_7.converge(ll1, ll2), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll1, ll3), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll3, ll2), ll3.head());
		}

		{
			LinkedList ll1 = new LinkedList().add(null);
			LinkedList ll2 = new LinkedList().add(3).add(4).add(null).add(4).add(3).add(4).add(3).add(4);
			LinkedList ll3 = new LinkedList().add(10);

			addAtEnd(ll1, ll3);
			addAtEnd(ll2, ll3);

			Assert.assertEquals(Q2_7.converge(ll1, ll2), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll1, ll3), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll3, ll2), ll3.head());
		}

		{
			LinkedList ll1 = new LinkedList().add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1);
			LinkedList ll2 = new LinkedList().add(1);
			LinkedList ll3 = new LinkedList().add(10);

			addAtEnd(ll1, ll3);
			addAtEnd(ll2, ll3);

			Assert.assertEquals(Q2_7.converge(ll1, ll2), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll1, ll3), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll3, ll2), ll3.head());
		}

		{
			LinkedList ll1 = new LinkedList().add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1).add(1);
			LinkedList ll2 = new LinkedList().add(1);
			LinkedList ll3 = new LinkedList().add(null);

			addAtEnd(ll1, ll3);
			addAtEnd(ll2, ll3);

			Assert.assertEquals(Q2_7.converge(ll1, ll2), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll1, ll3), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll3, ll2), ll3.head());
		}

		{
			LinkedList ll1 = new LinkedList().add(null).add(null).add(null).add(null).add(null).add(null).add(null).add(null).add(null).add(null).add(null);
			LinkedList ll2 = new LinkedList().add(null);
			LinkedList ll3 = new LinkedList().add(1);

			addAtEnd(ll1, ll3);
			addAtEnd(ll2, ll3);

			Assert.assertEquals(Q2_7.converge(ll1, ll2), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll1, ll3), ll3.head());
			Assert.assertEquals(Q2_7.converge(ll3, ll2), ll3.head());

		}
	}

	private void addAtEnd(LinkedList ll1, LinkedList ll2) {
		Node node = ll1.head();

		while (node.next != null) {
			node = node.next;
		}

		node.next = ll2.head();
	}

	public static LinkedList parse(String s) {

		String[] nodes = s.split(",");
		LinkedList ll = new LinkedList();

		for (String v : nodes) {
			ll.add(v.charAt(0));
		}

		return ll;
	}
}
