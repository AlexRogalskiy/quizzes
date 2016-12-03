package com.thiagoh.cci.c1;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Q1_4Test {

	@Test
	public void solution() {

		Assert.assertFalse(Q1_4.isPermutationOfPalindrome(null));
		Assert.assertFalse(Q1_4.isPermutationOfPalindrome(""));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("abcab"));
		Assert.assertFalse(Q1_4.isPermutationOfPalindrome("abcaab"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("abc ab"));
		Assert.assertFalse(Q1_4.isPermutationOfPalindrome("a bcaab"));

		Assert.assertFalse(Q1_4.isPermutationOfPalindrome("a bcaabaef"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("dddda"));
		Assert.assertFalse(Q1_4.isPermutationOfPalindrome("ddddab"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("ddddaa"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("ddddaa0"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("ddddaa00"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("soocoso"));

		/*
		 * Source
		 * http://www.ign.com/boards/threads/palindrome-database.183319196/
		 */
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("I man am Regal a german am I"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("Never Odd or even"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("If I had a hi fi"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("Madam Im adam"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("too hot to hoot"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("no lemons no melon"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("too bad I hid a boot"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("Lisa bonet ate no basil"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("warsaw was raw"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("was it a car or a cat I saw"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("Rise to vote sir"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("do geese see god"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("do nine men interpret nine men I nod"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("rats live on no evil star"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("wont lovers revolt now"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("race fast safe car"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("Pas a sap"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("ma is as selfless as i am"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("may a moody baby doom a yam"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("ah, satan sees natasha"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("no devil lived on"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("lonely tylenol"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("not a banana baton"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("no x in nixon"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("o stone be not so"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("o geronimo no minor ego"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("naomi i moan"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("a toyotas a toyota "));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("a dog a panic in a pagoda"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("oh no don ho"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("nurse i spy gypsies run"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("senile felines"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("now i see bees i won"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("ufo tofu"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("we panic in a pew"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("oozy rat in a sanitary zoo"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("God a red nugget a fat egg under a dog"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("go hang a salami im a lasagna hog"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("bob"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("god dog"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("racecar"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("murder for a jar of red rum"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("some men interpret nine memos"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("was it eliots toilet i saw"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("kay a red nude peeped under a yak"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("dennis sinned"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("dogma i am god"));
		Assert.assertTrue(Q1_4.isPermutationOfPalindrome("no trace not one carton"));

	}
}
