package com.thiagoh.data_structures;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class HashMapTest {

	private static String[] RANDOM_VALUES = new String[100];

	@BeforeClass
	private static void fillRandomValues() {

		for (int i = 0; i < RANDOM_VALUES.length; i++) {
			RANDOM_VALUES[i] = RandomStringUtils.random(10);
		}
	}

	@Test
	public void set() {

		HashMap hashMap = new HashMap();

		hashMap.set("name", "thiago");
		hashMap.set("lastName", "souza");

		Assert.assertEquals(hashMap.size(), 2);
	}

	@Test
	public void get() {

		HashMap hashMap = new HashMap();

		Assert.assertNull(hashMap.get(""));
		Assert.assertNull(hashMap.get(" "));
		Assert.assertNull(hashMap.get("non-existant-key"));
		Assert.assertNull(hashMap.get("name"), "thiago");
		Assert.assertNull(hashMap.get("lastName"), "souza");

		hashMap.set("name", "thiago");
		hashMap.set("lastName", "souza");

		Assert.assertNull(hashMap.get(""));
		Assert.assertNull(hashMap.get(" "));
		Assert.assertNull(hashMap.get("non-existant-key"));
		Assert.assertEquals(hashMap.get("name"), "thiago");
		Assert.assertEquals(hashMap.get("lastName"), "souza");
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

		HashMap hashMap = new HashMap();
		List list = new List(n);

		for (int i = 0; i < n; i++) {

			String key = RANDOM_VALUES[RandomUtils.nextInt(0, 100)];
			String value = key + "_value";

			hashMap.set(key, value);
			list.add(key);
		}

		for (int i = 0; i < n; i++) {

			String key = (String) list.get(i);
			Assert.assertEquals(hashMap.get(key), key + "_value");
		}
	}
}
