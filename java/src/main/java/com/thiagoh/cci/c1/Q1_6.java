package com.thiagoh.cci.c1;

public class Q1_6 {

	public static String compress(String s) {

		if (s == null || s.trim().isEmpty()) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		int occurences = 1;
		sb.append(s.charAt(0));
		
		for (int i = 0; i < s.length(); i++) {

			char currentChar = s.charAt(i);

			if (i + 1 >= s.length()) {
				sb.append(occurences);
				
			} else  { 
				
				char nextChar = s.charAt(i + 1);
				
				if (currentChar != nextChar) {
					sb.append(occurences);
					sb.append(nextChar);
					occurences = 1;
				} else {
					occurences++;
				}
			}
		}

		return sb.toString();
	}
}
