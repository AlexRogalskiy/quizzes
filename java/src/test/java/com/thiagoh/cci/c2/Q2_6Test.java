package com.thiagoh.cci.c2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.data_structures.LinkedList;

@Test
public class Q2_6Test {

	@Test
	public void isPalindrome() {

		Assert.assertFalse(Q2_6.isPalindrome(null));
		
		Assert.assertTrue(Q2_6.isPalindrome(parse("A")));
		Assert.assertTrue(Q2_6.isPalindrome(parse("A,B,A")));
		Assert.assertTrue(Q2_6.isPalindrome(parse("A,B,B,A")));
		Assert.assertTrue(Q2_6.isPalindrome(parse("A,B,C,D,D,C,B,A")));
		Assert.assertTrue(Q2_6.isPalindrome(parse("A,D,B,B,D,A")));
		Assert.assertTrue(Q2_6.isPalindrome(parse("A,B,C,C,B,A,A,B,C,C,B,A")));
		
		Assert.assertFalse(Q2_6.isPalindrome(parse("A,B,B,A,C")));
		Assert.assertFalse(Q2_6.isPalindrome(parse("A,B,C,D,E,F,G")));
		Assert.assertFalse(Q2_6.isPalindrome(parse("A,B,C,C,B,A,1,0,2,A,B,C,C,B,A")));
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
