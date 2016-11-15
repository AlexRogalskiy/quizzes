package com.thiagoh.cci.c1;

public class Q1_4 {

	public static boolean isPermutationOfPalindrome(String s) {

		if (s == null || s.trim().isEmpty()) {
			return false;
		}

		int[] chars = new int[255];
		s = s.toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			chars[((int) s.charAt(i)) % 255]++;
		}
		int odds = 0;
		for (int i = 0; i < chars.length; i++) {

			if (chars[i] <= 0) {
				continue;
			}

			if ((chars[i] & 1) != 0) {
				odds++;
			}
		}

		if (odds > 1) {
			return false;
		}

		return true;
	}
}
