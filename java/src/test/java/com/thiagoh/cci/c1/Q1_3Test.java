package com.thiagoh.cci.c1;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Q1_3Test {

	@Test
	public void testRemoveDuplicates() {

		Assert.assertEquals(Q1_3.removeDuplicates(null), null);
		Assert.assertEquals(Q1_3.removeDuplicates("".toCharArray()), "".toCharArray());
		Assert.assertEquals(Q1_3.removeDuplicates("a".toCharArray()), "a".toCharArray());
		Assert.assertEquals(Q1_3.removeDuplicates("aa".toCharArray()), "a\0".toCharArray());
		Assert.assertEquals(Q1_3.removeDuplicates("aaa".toCharArray()), "a\0\0".toCharArray());
		Assert.assertEquals(Q1_3.removeDuplicates("aaac".toCharArray()), "ac\0\0".toCharArray());
		Assert.assertEquals(Q1_3.removeDuplicates("aaaccc".toCharArray()), "ac\0\0\0\0".toCharArray());
		Assert.assertEquals(Q1_3.removeDuplicates("1aaaccc".toCharArray()), "1ac\0\0\0\0".toCharArray());

		String s = "qwertyuiopasdfghjklzxcvbnm";

		Assert.assertEquals(Q1_3.removeDuplicates(s.toCharArray()), s.toCharArray());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
			sb.append('\0');

		Assert.assertEquals(Q1_3.removeDuplicates((s + s).toCharArray()), (s + sb.toString()).toCharArray());
	}
}
