package com.thiagoh.data_structures;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class ListTest {

	private static String[] RANDOM_VALUES = new String[100];

	@BeforeClass
	private static void fillRandomValues() {

		for (int i = 0; i < RANDOM_VALUES.length; i++) {
			RANDOM_VALUES[i] = RandomStringUtils.random(10);
		}
	}

	@Test
	public void add() {

		List list = new List(10);

		list.add("val 1");
		list.add(2);
		Assert.assertEquals(list.size(), 2);

		list.add(2);
		Assert.assertEquals(list.size(), 3);
	}

	@Test
	public void get() {

		List list = new List(10);

		list.add("val 1");
		list.add(2);
		list.add(3.4);

		Assert.assertEquals(list.get(1), 2);
		Assert.assertEquals(list.get(2), 3.4);
		Assert.assertEquals(list.get(0), "val 1");
	}

	@Test
	public void get_1000() {
		get_n(1000);
	}

	@Test
	public void get_10000() {
		get_n(10000);
	}

	@Test
	public void get_100000() {
		get_n(100000);
	}

	@Test
	public void get_1000000() {
		get_n(1000000);
	}

	private void get_n(int n) {

		List list = new List(Math.min(10, n / 10));
		Object[] objects = new Object[n];

		for (int i = 0; i < n; i++) {
			String value = RANDOM_VALUES[RandomUtils.nextInt(0, 100)];
			list.add(value);
			objects[i] = value;
		}

		for (int i = 0; i < n; i++) {
			Assert.assertEquals(list.get(i), objects[i]);
		}
	}

	@Test
	public void get_thrown_exception() {

		List list = new List(10);

		list.add("val 1");
		list.add(2);
		list.add(3.4);

		Assert.assertEquals(list.get(1), 2);
		Assert.assertEquals(list.get(2), 3.4);
		Assert.assertEquals(list.get(0), "val 1");

		try {

			list.get(-1);
			Assert.fail("Should throw an ArrayIndexOutOfBoundsException");

		} catch (Exception e) {
			Assert.assertTrue(e instanceof ArrayIndexOutOfBoundsException);
		}

		try {

			list.get(-2);
			Assert.fail("Should throw an ArrayIndexOutOfBoundsException");

		} catch (Exception e) {
			Assert.assertTrue(e instanceof ArrayIndexOutOfBoundsException);
		}

		try {

			list.get(-10);
			Assert.fail("Should throw an ArrayIndexOutOfBoundsException");

		} catch (Exception e) {
			Assert.assertTrue(e instanceof ArrayIndexOutOfBoundsException);
		}

		try {

			list.get(list.size());
			Assert.fail("Should throw an ArrayIndexOutOfBoundsException");

		} catch (Exception e) {
			Assert.assertTrue(e instanceof ArrayIndexOutOfBoundsException);
		}

		try {

			list.get(10);
			Assert.fail("Should throw an ArrayIndexOutOfBoundsException");

		} catch (Exception e) {
			Assert.assertTrue(e instanceof ArrayIndexOutOfBoundsException);
		}
	}

}
