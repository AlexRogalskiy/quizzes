package com.thiagoh.projecteuler.p14;

import java.util.HashMap;
import java.util.Map;

public class Problem14 {

	private static final Map<Long, Integer> cache = new HashMap<Long, Integer>();

	public static int solve(long max) {

		cache.put(1L, 1);
		int longest = 1, length = 1;
		for (int i = 2; i <= max; i++) {
			int _curLength = collatz(i);
			cache.put((long) i, _curLength);
			if (_curLength > length) {
				length = _curLength;
				longest = i;
			}
		}

		return longest;
	}

	static int collatz(long n) {
		Integer length = cache.get(n);
		if (length == null) {
			length = collatz((n % 2 == 0) ? n / 2 : 3 * n + 1) + 1;
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
