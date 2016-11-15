package com.thiagoh.cci.c1;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Q1_6Test {

	@Test
	public void solution() {

		Assert.assertNull(Q1_6.compress(null));
		Assert.assertEquals(Q1_6.compress(""), "");
		Assert.assertEquals(Q1_6.compress("s"), "s1");
		
		Assert.assertEquals(Q1_6.compress("ss"), "s2");
		Assert.assertEquals(Q1_6.compress("sss"), "s3");
		Assert.assertEquals(Q1_6.compress("ssss"), "s4");
		
		Assert.assertEquals(Q1_6.compress("aabcccccaaa"), "a2b1c5a3");
		Assert.assertEquals(Q1_6.compress("aaabbcccccaaabcdbb"), "a3b2c5a3b1c1d1b2");
	}
}
