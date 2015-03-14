package com.thiagoh.cci.c1;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Q1_1Test {

	@Test
	public void testUnique() {

		Assert.assertTrue(Q1_1.unique(null));
		Assert.assertTrue(Q1_1.unique("a"));
		Assert.assertTrue(Q1_1.unique("b"));
		Assert.assertTrue(Q1_1.unique("ab"));

		Assert.assertFalse(Q1_1.unique("aa"));
		Assert.assertFalse(Q1_1.unique("bb"));
		Assert.assertFalse(Q1_1.unique("aba"));

		String s = "qwertyuiopasdfghjklzxcvbnm";
		Assert.assertTrue(Q1_1.unique(s));
		Assert.assertFalse(Q1_1.unique(s + s));
		Assert.assertFalse(Q1_1.unique(s + "a"));

	}
}
