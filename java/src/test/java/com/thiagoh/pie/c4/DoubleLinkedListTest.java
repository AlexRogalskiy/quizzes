package com.thiagoh.pie.c4;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DoubleLinkedListTest {

	@Test
	public void testAdd() {

		DoubleLinkedList ll = new DoubleLinkedList();

		ll.add(null);
		ll.add(123);
		Assert.assertEquals(true, ll.contains(123));
		Assert.assertEquals(false, ll.contains(1234));

		ll.add("abc");
		Assert.assertEquals(true, ll.contains("abc"));
		Assert.assertEquals(false, ll.contains("abv"));

		ll.add(401928);
		Assert.assertEquals(true, ll.contains(401928));
		Assert.assertEquals(false, ll.contains(401929));

		ll.add(Integer.MAX_VALUE);
		Assert.assertEquals(true, ll.contains(Integer.MAX_VALUE));
		Assert.assertEquals(false, ll.contains(Integer.MIN_VALUE));

		ll.add(Long.MIN_VALUE);
		Assert.assertEquals(true, ll.contains(Long.MIN_VALUE));
		Assert.assertEquals(false, ll.contains(Long.MAX_VALUE));
	}

	@Test
	public void testDelete() {

		DoubleLinkedList ll = new DoubleLinkedList();

		ll.add(123);
		ll.add("abc");
		ll.add(401928);
		ll.add(Integer.MAX_VALUE);
		ll.add(Long.MIN_VALUE);

		Assert.assertEquals(true, ll.contains(123));
		Assert.assertEquals(true, ll.contains("abc"));
		Assert.assertEquals(true, ll.contains(401928));
		Assert.assertEquals(true, ll.contains(Integer.MAX_VALUE));
		Assert.assertEquals(true, ll.contains(Long.MIN_VALUE));

		ll.remove(123);
		ll.remove("abc");
		ll.remove(401928);
		ll.remove(Integer.MAX_VALUE);
		ll.remove(Long.MIN_VALUE);

		Assert.assertEquals(false, ll.contains(123));
		Assert.assertEquals(false, ll.contains("abc"));
		Assert.assertEquals(false, ll.contains(401928));
		Assert.assertEquals(false, ll.contains(Integer.MAX_VALUE));
		Assert.assertEquals(false, ll.contains(Long.MIN_VALUE));
	}

	@Test
	public void testContains() {

		DoubleLinkedList ll = new DoubleLinkedList();

		ll.add(123);
		ll.add("abc");
		ll.add(401928);
		ll.add(Integer.MAX_VALUE);
		ll.add(Long.MIN_VALUE);

		Assert.assertEquals(true, ll.contains(123));
		Assert.assertEquals(true, ll.contains("abc"));
		Assert.assertEquals(true, ll.contains(401928));
		Assert.assertEquals(true, ll.contains(Integer.MAX_VALUE));
		Assert.assertEquals(true, ll.contains(Long.MIN_VALUE));

		Assert.assertEquals(false, ll.contains(1234));
		Assert.assertEquals(false, ll.contains("abv"));
		Assert.assertEquals(false, ll.contains(401929));
		Assert.assertEquals(false, ll.contains(Integer.MIN_VALUE));
		Assert.assertEquals(false, ll.contains(Long.MAX_VALUE));
	}

	@Test
	public void testIterate() {

		DoubleLinkedList ll = new DoubleLinkedList();

		ll.add(123);
		ll.add("abc");
		ll.add(401928);
		ll.add(Integer.MAX_VALUE);
		ll.add(Long.MIN_VALUE);

		Iterator<Object> iter = ll.iterator();

		Assert.assertEquals(123, iter.next());
		Assert.assertEquals("abc", iter.next());
		Assert.assertEquals(401928, iter.next());
		Assert.assertEquals(Integer.MAX_VALUE, iter.next());
		Assert.assertEquals(Long.MIN_VALUE, iter.next());
	}
}
