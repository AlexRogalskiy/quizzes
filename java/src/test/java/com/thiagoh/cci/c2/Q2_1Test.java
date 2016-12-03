package com.thiagoh.cci.c2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.LinkedList;
import com.thiagoh.data_structures.LinkedList.Node;

@Test
public class Q2_1Test {

	@Test
	public void remove_duplicates() {

		Assert.assertNull(Q2_1.removeDuplicates(null));
		Assert.assertEquals(print(Q2_1.removeDuplicates(parse(""))), "");

		Assert.assertEquals(print(Q2_1.removeDuplicates(parse("A,B,C,D,E,F,G"))), "A,B,C,D,E,F,G");
		
		Assert.assertEquals(print(Q2_1.removeDuplicates(parse("A,B,C,D,E,F,A,B,G"))), "A,B,C,D,E,F,G");

		Assert.assertEquals(print(Q2_1.removeDuplicates(parse("G,A,B,C,D,E,F,A,B,G"))), "G,A,B,C,D,E,F");

		Assert.assertEquals(print(Q2_1.removeDuplicates(parse("A,A,A,A,A"))), "A");

		Assert.assertEquals(print(Q2_1.removeDuplicates(parse("A,A,A,A,A,B"))), "A,B");
		
		Assert.assertEquals(print(Q2_1.removeDuplicates(parse("CC,C,A,A,A,A,A,B"))), "CC,C,A,B");
	}
	
	@Test
	public void remove_duplicates_without_hash() {
		
		Assert.assertNull(Q2_1.removeDuplicatesWithoutHash(null));
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse(""))), "");
		
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse("A,B,C,D,E,F,G"))), "A,B,C,D,E,F,G");
		
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse("A,B,C,D,E,F,A,B,G"))), "A,B,C,D,E,F,G");
		
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse("G,A,B,C,D,E,F,A,B,G"))), "G,A,B,C,D,E,F");
		
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse("A,A,A"))), "A");
		
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse("A,A,A,A,A"))), "A");
		
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse("A,A,A,A,A,B"))), "A,B");
		
		Assert.assertEquals(print(Q2_1.removeDuplicatesWithoutHash(parse("CC,C,A,A,A,A,A,B"))), "CC,C,A,B");
		
	}

	public static String print(LinkedList ll) {

		StringBuilder sb = new StringBuilder();
		Node node = ll.head();

		while (node != null) {
			sb.append(node.value).append(",");
			node = node.next;
		}

		String s = sb.toString();

		s = s.endsWith(",") ? s.substring(0, s.length() - 1) : s;

		return s;
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
