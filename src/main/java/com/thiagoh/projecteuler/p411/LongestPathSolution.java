package com.thiagoh.projecteuler.p411;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;

import org.apache.commons.io.IOUtils;

public class LongestPathSolution {

	private static final boolean DEBUG = false;

	List<Node> points;

	private long n;

	public LongestPathSolution(long n) {
		this.n = n;
	}

	int calc(File pointsJoinedSorted) throws IOException {

		points = new ArrayList<Node>();

		List<String> lines = IOUtils.readLines(new FileInputStream(pointsJoinedSorted));

		for (String line : lines) {
			
			String[] split = line.split(",");

			points.add(new Node(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
		}

		for (Node node : points) {

			int ix = 0;
			l1: for (int i = 0; i < points.size(); i++) {
				if (node.equals(points.get(i))) {
					ix = i;
					break l1;
				}
			}

			l2: for (; ix >= 0; ix--) {

				Node previousToAdd = points.get(ix);

				if (node.equals(previousToAdd) || previousToAdd.x > node.x || previousToAdd.y > node.y) {
					continue l2;
				}

				node.previous.add(previousToAdd);
			}
		}

		for (Node node : points) {
			getPathsTo(node);
		}

		int len = 0;
		for (Node node : points) {
			len = Math.max(node.maxLength, len);
		}

		return len;
	}

	void draw() {

		JFrame testFrame = new JFrame();

		testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		MatrixComponent comp = new MatrixComponent(n, 1200);

		testFrame.setPreferredSize(new Dimension(1200, 1200));
		testFrame.getContentPane().add(comp, BorderLayout.CENTER);
		testFrame.pack();
		testFrame.setVisible(true);
	}

	int S() throws IOException {

		File pointsJoinedSorted = new File("files-points-joined-sorted/joined-sorted-" + n);

		if (!pointsJoinedSorted.exists()) {
			throw new RuntimeException("There are no files for n " + n);
		}

		int s = calc(pointsJoinedSorted);

		System.out.println("S(" + n + ") = " + s);

		return s;
	}

	private void getPathsTo(Node to) {

		if (to.maxLength != null) {
			return;
		}

		Iterator<Node> iterator = to.previous.iterator();
		int maxLength = 1;

		while (iterator.hasNext()) {

			Node prev = (Node) iterator.next();

			Integer length = to.length.get(prev);

			if (length == null) {
				length = prev.maxLength;
				to.length.put(prev, length);
			}

			length = length + 1;

			to.length.put(prev, length);

			getPathsTo(prev);
		}

		Set<Entry<Node, Integer>> entrySet = to.length.entrySet();

		for (Entry<Node, Integer> entry : entrySet) {
			maxLength = Math.max(maxLength, entry.getValue());
		}

		to.length.clear();
		to.length = null;
		to.previous.clear();
		to.previous = null;
		to.maxLength = maxLength;
	}

	public static void main(String[] args) {

		if (false) {

			try {

				System.out.println(new LongestPathSolution(22).S());
				System.out.println(new LongestPathSolution(123).S());
				System.out.println(new LongestPathSolution(500).S());
				System.out.println(new LongestPathSolution(1000).S());
				System.out.println(new LongestPathSolution(1500).S());
				System.out.println(new LongestPathSolution(2000).S());
				System.out.println(new LongestPathSolution(10000).S());

			} catch (IOException e) {
				e.printStackTrace();
			}

			return;
		}

		// SUM S(k5) for 1 <= k <= 30.
		long sum = 0L;

		for (int k = 1; k <= 30; k++) {

			long k5 = (long) Math.pow(k, 5);

			try {

				int s = new LongestPathSolution(k5).S();

				sum += s;

				System.out.println("k " + k + " k5 " + k5 + " S(" + k5 + ") = " + s);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		System.out.println("Sum is: " + sum);
	}
}

class Edge {

	Node from;
	Node to;
	int length;

	public Edge(Node from, Node to, int length) {
		this.from = from;
		this.to = to;
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

}