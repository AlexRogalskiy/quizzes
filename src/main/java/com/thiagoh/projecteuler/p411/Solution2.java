package com.thiagoh.projecteuler.p411;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Solution2 {

	private static final boolean DEBUG = false;

	static final int INTERVAL = 50;
	Map<Long, BigInteger> _2pow = new HashMap<Long, BigInteger>();
	static Map<Long, BigInteger> _3pow = new HashMap<Long, BigInteger>();

	static final BigInteger one = BigInteger.valueOf(1L);
	static final BigInteger TWO = BigInteger.valueOf(2L);
	static final BigInteger THREE = BigInteger.valueOf(3L);

	static final BigInteger TWO_EXP_1 = TWO;
	static final BigInteger THREE_EXP_1 = THREE;

	static final BigInteger TWO_EXP_30 = TWO.pow(30);
	static final BigInteger THREE_EXP_30 = THREE.pow(30);

	static final BigInteger TWO_EXP_100 = TWO.pow(100);
	static final BigInteger THREE_EXP_100 = THREE.pow(100);

	BigInteger N;

	BigInteger TWO_EXP_1_MOD_N;
	BigInteger THREE_EXP_1_MOD_N;

	BigInteger TWO_EXP_30_MOD_N;
	BigInteger THREE_EXP_30_MOD_N;

	BigInteger TWO_EXP_100_MOD_N;
	BigInteger THREE_EXP_100_MOD_N;

	Node[] points;
	long n;

	public Solution2(long n) {

		this.n = n;
		this.N = BigInteger.valueOf(n);

		this.TWO_EXP_1_MOD_N = TWO_EXP_1.mod(N);
		this.THREE_EXP_1_MOD_N = THREE_EXP_1.mod(N);

		this.TWO_EXP_30_MOD_N = TWO_EXP_30.mod(N);
		this.THREE_EXP_30_MOD_N = THREE_EXP_30.mod(N);

		this.TWO_EXP_100_MOD_N = TWO_EXP_100.mod(N);
		this.THREE_EXP_100_MOD_N = THREE_EXP_100.mod(N);
	}

	void draw() {

		JFrame testFrame = new JFrame();

		testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		MatrixComponent comp = new MatrixComponent(n, 800);

		testFrame.setPreferredSize(new Dimension(1000, 1000));
		testFrame.getContentPane().add(comp, BorderLayout.CENTER);
		testFrame.pack();
		testFrame.setVisible(true);
	}

	// calculates a^n (mod m)
	private static long fastModPow(long a, long n, long m) {

		/*
		 * Integer fastExp( Integer a, Integer n, Integer m)
		 * x = a; // x = a20
		 * y = (odd(n) ) ? a : 1; // y = an0
		 * n' = [n/2];
		 * while ( n' > 0 )
		 * x = x^2 (mod m); // x = a2i–1 -> x = a2i
		 * if (odd(n') )
		 * y = (y==1) ? x : yx (mod m); // y = ani–1 -> y = ani
		 * n' = [n'/2];
		 * return y;
		 */

		long x = a;
		long y = odd(n) ? a : 1;
		long nl = n / 2;

		while (nl > 0) {

			x = (long) (Math.pow(x, 2) % m);
			if (odd(nl)) {
				y = (y == 1L) ? x : (y * x) % m;
			}
			nl = nl / 2;
		}

		return y;
	}

	private static boolean odd(long n) {

		return (n & 1) == 1;
	}

	private long getX(long i) {

		long mod = fastModPow(2, i, n);

		return mod;
	}

	private long getY(long i) {

		long mod = fastModPow(3, i, n);
		
		return mod;
	}

	private Node[] fill() {

		List<Node> list = new ArrayList<Node>();

		for (long i = 0; i <= 2 * n; i++) {

			long x = getX(i);

			if (x > n) {
				continue;
			}

			long y = getY(i);

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

	int S() {
		return SPath().size();
	}

	List<Node> SPath() {

		int S = 0;
		List<Node> gpath = new ArrayList<Node>();

		points = fill();

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

		long t1 = System.currentTimeMillis();

		System.out.println(new Solution2(22).S());
		System.out.println(new Solution2(123).S());
		System.out.println(new Solution2(10000).S());
		System.out.println(new Solution2(100000).S());
		System.out.println(new Solution2(200000).S());
		System.out.println(new Solution2(400000).S());

		long t2 = System.currentTimeMillis();

		System.out.println("Costs " + (t2 - t1) + "ms");

		if (true)
			return;

		System.out.println(new Solution2(800000).S());

		// SUM S(k5) for 1 <= k <= 30.
		long sum = 0;

		for (int k = 1; k <= 30; k++) {

			long k5 = (long) Math.pow(k, 5);

			System.out.println("k " + k + " k5 " + k5);
			sum += new Solution2(k5).S();
		}

		System.out.println(sum);
	}
}
