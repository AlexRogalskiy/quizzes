package com.thiagoh.cci.c1;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Q1_2Test {

	@Test
	public void testReverse() {

		Assert.assertEquals(Q1_2.reverse(null), null);
		Assert.assertEquals(Q1_2.reverse("" + '\0'), "" + '\0');
		Assert.assertEquals(Q1_2.reverse("a\0"), "a\0");
		Assert.assertEquals(Q1_2.reverse("ab\0"), "ba\0");
		Assert.assertEquals(Q1_2.reverse("aba" + '\0'), "aba" + '\0');
		Assert.assertEquals(Q1_2.reverse("abc" + '\0'), "cba" + '\0');
		Assert.assertEquals(Q1_2.reverse("abcd" + '\0'), "dcba" + '\0');
		Assert.assertEquals(Q1_2.reverse("aaaa" + '\0'), "aaaa" + '\0');
		Assert.assertEquals(Q1_2.reverse("aaaabbbb" + '\0'), "bbbbaaaa" + '\0');
		Assert.assertEquals(Q1_2.reverse("aaaacbbbb" + '\0'), "bbbbcaaaa" + '\0');
	}
}
