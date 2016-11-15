package com.thiagoh.projecteuler.p14;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CopyOfProblem14 {

	public static int solve(long max) {
		Map<Long, Long> collatzLengthOf = new HashMap<Long, Long>();
		long longest = 1;
		long longestLength = 1;
		collatzLengthOf.put(1l, 1l);
		for (long i = 2; i < max; i++) {
			if (!collatzLengthOf.containsKey(i)) {
				long length = collatzLength(collatzLengthOf, i);
				collatzLengthOf.put(i, length);
				if (length > longestLength) {
					longestLength = length;
					longest = i;
				}
			}
		}
		
		int maxSequenceLength = new CollatzSequence(longest).sequence.size();
		
		if (longestLength != maxSequenceLength)
			throw new RuntimeException("Something went wrong");
			
		return maxSequenceLength;
	}

	static long calc(long n) {
		return (n % 2 == 0) ? n / 2 : 3 * n + 1;
	}

	static long collatzLength(Map<Long, Long> collatzLengthOf, long n) {
		Long length = collatzLengthOf.get(n);
		if (length == null) {
			length = 1 + collatzLength(collatzLengthOf, calc(n));
		}
		return length;
	}

	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();
		int solution = solve(1_000_000);
		long t2 = System.currentTimeMillis();
		System.out.println(String.format("Solução: %d em %dms", solution, (t2 - t1)));

	}

	static class CollatzSequence {

		private List<Long> sequence;

		public CollatzSequence(long num) {
			this.sequence = generateSequence(num);
		}

		private List<Long> generateSequence(long num) {
			List<Long> list = new LinkedList<Long>();
			for (long i = num; i > 1; i = calc(i)) {
				list.add(i);
			}
			list.add(1L);
			return list;
		}

	}
}
