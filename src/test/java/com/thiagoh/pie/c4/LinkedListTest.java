package com.thiagoh.pie.c4;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class LinkedListTest {

	@Test
	public void testAdd() {

		LinkedList ll = new LinkedList();

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
	public void testDelete(){

		LinkedList ll = new LinkedList();

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
	public void testContains(){

		LinkedList ll = new LinkedList();

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

}
