package com.thiagoh.cci.c2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.LinkedList;
import com.thiagoh.data_structures.LinkedList.Node;

@Test
public class Q2_8Test {

	@Test
	public void findLoopWithHashMap() {

		Assert.assertNull(Q2_8.findLoopWithHashMap(null));

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Node C = ll1.getNode(2);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = C;

			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), C);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Node E = ll1.getNode(4);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = E;

			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), E);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E");
			Node C = ll1.getNode(2);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = C;

			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), C);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;

			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B,C");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;

			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;

			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), last);
		}

		{
			LinkedList ll1 = parse("A");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;
			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;
			Assert.assertEquals(Q2_8.findLoopWithHashMap(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Assert.assertNull(Q2_8.findLoopWithHashMap(ll1));
		}
	}

	@Test
	public void findLoopWithPointers() {

		Assert.assertNull(Q2_8.findLoopWithPointers(null));

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L");
			Node D = ll1.getNode(3);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = D;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), D);
		}
		
		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S");
			Node O = ll1.getNode(13);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = O;
			
			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), O);
		}
		
		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J");
			Node E = ll1.getNode(4);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = E;
			
			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), E);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M");
			Node E = ll1.getNode(4);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = E;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), E);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Node D = ll1.getNode(3);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = D;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), D);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Node E = ll1.getNode(4);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = E;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), E);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E");
			Node C = ll1.getNode(2);
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = C;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), C);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B,C");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;

			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), last);
		}

		{
			LinkedList ll1 = parse("A");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;
			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Node last = ll1.getNode(ll1.size() - 1);
			last.next = last;
			Assert.assertEquals(Q2_8.findLoopWithPointers(ll1), last);
		}

		{
			LinkedList ll1 = parse("A,B,C,D,E,F,G,H,I,J,L,M,N,O,P,Q,R,S,T,U,V,X");
			Assert.assertNull(Q2_8.findLoopWithPointers(ll1));
		}
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
