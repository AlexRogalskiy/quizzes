package com.thiagoh.data_structures;

import java.util.Iterator;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class DoubleLinkedListTest {
	private static String[] RANDOM_VALUES = new String[100];

	@BeforeClass
	private static void fillRandomValues() {

		for (int i = 0; i < RANDOM_VALUES.length; i++) {
			RANDOM_VALUES[i] = RandomStringUtils.random(10);
		}
	}

	@Test
	public void test_add() {

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
	public void test_get() {

		DoubleLinkedList ll = new DoubleLinkedList();

		ll.add(null);
		ll.add(123);
		ll.add("abc");

		Assert.assertEquals(ll.get(1), 123);
		Assert.assertNull(ll.get(0));
		Assert.assertEquals(ll.get(2), "abc");

		int loopCount = (2 << 12);
		for (int i = 3; i < loopCount; i++) {

			String nextInt = RANDOM_VALUES[i % RANDOM_VALUES.length];
			ll.add(nextInt);
			Assert.assertEquals(ll.get(i), nextInt);
		}
	}

	@Test
	public void test_delete() {

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
	public void test_contains() {

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
	public void test_iterate() {

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
