package com.thiagoh.projecteuler.p14;

import java.util.HashMap;
import java.util.Map;

public class Copy_2_of_Problem14 {

	public static int solve(long max) {

		Map<Long, Integer> collatzLengthOf = new HashMap<Long, Integer>();
		int longest = 1;
		int longestLength = 1;
		collatzLengthOf.put(1L, 1);

		for (int i = 2; i < max; i++) {
			if (collatzLengthOf.containsKey(i)) {
				continue;
			}
			int _curLength = collatzLength(collatzLengthOf, i);
			collatzLengthOf.put((long) i, _curLength);
			if (_curLength > longestLength) {
				longestLength = _curLength;
				longest = i;
			}
		}

		return longest;
	}

	static int collatzLength(Map<Long, Integer> collatzLengthOf, long n) {
		Integer length = collatzLengthOf.get(n);
		if (length == null) {
			length = 1 + collatzLength(collatzLengthOf, (n % 2 == 0) ? n / 2 : 3 * n + 1);
		}
		return length;
	}

	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();
		int solution = solve(1_000_000);
		long t2 = System.currentTimeMillis();
		System.out.println(String.format("Solução: %d em %dms", solution, (t2 - t1)));
	}
}
