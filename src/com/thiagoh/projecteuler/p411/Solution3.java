package com.thiagoh.projecteuler.p411;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

	private static final boolean DEBUG = false;

	static final BigInteger one = BigInteger.valueOf(1L);
	static final BigInteger two = BigInteger.valueOf(2L);
	static final BigInteger three = BigInteger.valueOf(3L);

	Node[] points;

	private long xBoundary = 0;
	private BigInteger xValue = null;

	private long yBoundary = 0;
	private BigInteger yValue = null;

	private long getX(long i, long n) {

		long mod = 0;
		BigInteger nbi = BigInteger.valueOf(n);

		if (xBoundary == 0) {

			BigInteger pow = two.pow((int) i);
			BigInteger bi = pow.mod(nbi);

			mod = bi.longValue();

			if (pow.longValue() > n) {
				xBoundary = i;
				xValue = bi;
			}

		} else {

			BigInteger bi = two.pow((int) (i - xBoundary)).multiply(xValue).mod(nbi);
			mod = bi.longValue();

			xBoundary = i;
			xValue = bi;
		}

		return mod;
	}

	private long getY(long i, long n) {

		long mod = 0;
		BigInteger nbi = BigInteger.valueOf(n);

		if (yBoundary == 0) {

			BigInteger pow = three.pow((int) i);
			BigInteger bi = pow.mod(nbi);

			mod = bi.longValue();

			if (pow.longValue() > n) {
				yBoundary = i;
				yValue = bi;
			}

		} else {

			BigInteger bi = three.pow((int) (i - yBoundary)).multiply(yValue).mod(nbi);
			mod = bi.longValue();

			yBoundary = i;
			yValue = bi;
		}

		return mod;
	}

	private Node[] fill(long n) {

		List<Node> list = new ArrayList<Node>();

		for (long i = 0; i <= 2 * n; i++) {

			long x = getX(i, n);

			if (x > n) {
				continue;
			}

			long y = getY(i, n);

			if (y > n) {
				continue;
			}

			if (x == 0 && y == 0) {
				continue;
			}

			Node node = new Node((int) x, (int) y);

			if (!list.contains(node)) {
				list.add(node);
			}
		}

		return list.toArray(new Node[list.size()]);
	}

	private List<Node> nexts(Node node) {

		if (node.nexts == null) {

			node.nexts = new ArrayList<Node>();

			l1: for (int j = 0; j < points.length; j++) {

				Node next = points[j];

				if (node.equals(next) || next.x < node.x || next.y < node.y) {
					continue l1;
				}

				node.nexts.add(next);
			}
		}

		return node.nexts;
	}

	private List<List<Node>> getPathsFrom(Node current) {

		List<List<Node>> paths = new ArrayList<List<Node>>();
		List<Node> nexts = nexts(current);

		for (Node next : nexts) {

			List<Node> path = new ArrayList<Node>();

			path.add(current);
			path.addAll(getGreaterPathFrom(next));

			paths.add(path);
			break;
		}

		return paths;
	}

	private List<Node> getGreaterPathFrom(Node current) {

		if (current.greatestDistanceToNxN == null) {

			List<Node> greater = new ArrayList<Node>();

			for (Node next : nexts(current)) {

				if (!next.equals(current) && next.x >= current.x && next.y >= current.y) {

					List<Node> tmp = getGreaterPathFrom(next);
					if (tmp.size() > greater.size()) {
						greater = tmp;
					}
				}
			}

			current.greatestDistanceToNxN = new ArrayList<Node>();
			current.greatestDistanceToNxN.add(current);
			current.greatestDistanceToNxN.addAll(greater);
		}

		return current.greatestDistanceToNxN;
	}

	int S(long n) {
		return SPath(n).size();
	}

	List<Node> SPath(long n) {

		int S = 0;
		List<Node> gpath = new ArrayList<Node>();

		points = fill(n);

		for (int i = 0; i < points.length; i++) {

			Node current = points[i];

			List<List<Node>> paths = getPathsFrom(current);

			for (List<Node> path : paths) {

				if (S < path.size()) {
					gpath = path;
					S = path.size();
				}
			}
			break;
		}

		if (DEBUG) {
			System.out.println("S: " + gpath.size() + " " + gpath);
		}

		return gpath;
	}

	public static void main(String[] args) {

		// SUM S(k5) for 1 <= k <= 30.
		long sum = 0;

		List<Thread> threads = new ArrayList<Thread>();
		final Map<Long, Integer> map = Collections.synchronizedMap(new HashMap<Long, Integer>());

		for (int i = 1; i <= 30; i++) {

			final int k = i;

			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {

					long k5 = (long) Math.pow(k, 5);
					int s = new Solution3().S(k5);

					map.put(k5, s);

					System.out.println("k " + k + " k5 " + k5 + " S(" + k5 + ") = " + s);
				}
			});

			thread.start();
			threads.add(thread);
		}

		for (Thread thread : threads) {
			try {

				thread.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(sum);
	}
}
