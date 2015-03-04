package com.thiagoh.projecteuler.p411;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Solution1 {

	private static final boolean DEBUG = false;

	static final int INTERVAL = 50;
	Map<Long, BigInteger> _2pow = new HashMap<Long, BigInteger>();
	static Map<Long, BigInteger> _3pow = new HashMap<Long, BigInteger>();

	static final BigInteger one = BigInteger.valueOf(1L);
	static final BigInteger two = BigInteger.valueOf(2L);
	static final BigInteger three = BigInteger.valueOf(3L);

	Node[] points;

	void draw(int n) {

		JFrame testFrame = new JFrame();

		testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		MatrixComponent comp = new MatrixComponent(n, 800);

		testFrame.setPreferredSize(new Dimension(1000, 1000));
		testFrame.getContentPane().add(comp, BorderLayout.CENTER);
		testFrame.pack();
		testFrame.setVisible(true);
	}

	private long xBoundary = 0;
	private BigInteger xValue = null;

	private long yBoundary = 0;
	private BigInteger yValue = null;

	private long getX(long i, long n) {

		long t1 = System.currentTimeMillis();
		long mod = 0;
		BigInteger nbi = BigInteger.valueOf(n);

		if (xBoundary == 0) {

			BigInteger pow = two.pow((int) i);
			BigInteger bi = pow.mod(nbi);

			mod = bi.longValue();

			if (pow.compareTo(nbi) == 1) {
				xBoundary = i;
				xValue = bi;
			}

		} else {

			// System.out.println((4 % 3) + " " + ((2 * (2 % 3)) % 3));

			BigInteger bi = two.pow((int) (i - xBoundary)).multiply(xValue).mod(nbi);
			mod = bi.longValue();

			xBoundary = i;
			xValue = bi;
		}

		// BigInteger v = _2pow.get(i);
		//
		// if (v == null) {
		// v = two.pow((int) i);
		// _2pow.put(i, v);
		// }
		//
		// long mod = v.mod(BigInteger.valueOf(n)).longValue();

		long t2 = System.currentTimeMillis();

		if (t2 - t1 > INTERVAL)
			System.out.println("getX for " + i + " costs " + (t2 - t1) + "ms");

		return mod;
	}

	private long getY(long i, long n) {

		long t1 = System.currentTimeMillis();
		long mod = 0;
		BigInteger nbi = BigInteger.valueOf(n);

		if (yBoundary == 0) {

			BigInteger pow = three.pow((int) i);
			BigInteger bi = pow.mod(nbi);

			mod = bi.longValue();

			if (pow.compareTo(nbi) == 1) {
				yBoundary = i;
				yValue = bi;
			}

		} else {

			// System.out.println((4 % 3) + " " + ((2 * (2 % 3)) % 3));

			BigInteger bi = three.pow((int) (i - yBoundary)).multiply(yValue).mod(nbi);
			mod = bi.longValue();

			yBoundary = i;
			yValue = bi;
		}

		// BigInteger v = _3pow.get(i);
		//
		// if (v == null) {
		// v = three.pow((int) i);
		// _3pow.put(i, v);
		// }
		//
		// long mod = v.mod(BigInteger.valueOf(n)).longValue();

		long t2 = System.currentTimeMillis();

		if (t2 - t1 > INTERVAL)
			System.out.println("getY for " + i + " costs " + (t2 - t1) + "ms");

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

				if (node.nexts.size() > 1) {

					Node last = node.nexts.get(node.nexts.size() - 1);

					if (next.x > last.x && next.y > last.y) {
						continue l1;
					}
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
		}

		if (DEBUG) {
			System.out.println("S: " + gpath.size() + " " + gpath);
		}

		return gpath;
	}

	public static void main(String[] args) {

		if (true) {

			long t1 = System.currentTimeMillis();

			System.out.println(new Solution1().SPath(22));
			System.out.println(new Solution1().SPath(123));
			System.out.println(new Solution1().SPath(10000));

			long t2 = System.currentTimeMillis();

			System.out.println("Costs " + (t2 - t1) + "ms");

			return;
		}

		// SUM S(k5) for 1 <= k <= 30.
		long sum = 0;

		for (int k = 1; k <= 30; k++) {

			long k5 = (long) Math.pow(k, 5);
			int s = new Solution1().S(k5);

			sum += s;

			System.out.println("k " + k + " k5 " + k5 + " S(" + k5 + ") = " + s);
		}

		System.out.println(sum);
	}
}
