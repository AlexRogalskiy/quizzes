package com.thiagoh.projecteuler.p411;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class LongestPathSolution {

	private static final boolean DEBUG = true;

	private static boolean loaded = false;
	private static Object monitor = new Object();

	private List<Node> points;

	private long n;

	public LongestPathSolution(long n) {
		this.n = n;
	}

	void loadFiles() throws IOException {

		boolean load = false;

		if (!loaded) {

			synchronized (monitor) {

				if (!loaded) {
					load = true;
				}
			}

			if (load) {

				File pointsJoinedSorted = new File("files-points-joined-sorted/joined-sorted-" + n);

				points = new ArrayList<Node>();
				
				List<String> readLines = IOUtils.readLines(new FileInputStream(pointsJoinedSorted));

				for (String line : readLines) {

					String[] split = line.split(",");

					Node node = new Node(Integer.valueOf(split[0]), Integer.valueOf(split[1]));

					points.add(node);
				}

				synchronized (monitor) {
					loaded = true;
				}
			}
		}
	}

	private void fill() throws IOException {

		loadFiles();
	}

	private List<Node> nexts(Node node) {

		if (node.nexts == null) {

			node.nexts = new ArrayList<Node>();

			l1: for (int j = 0; j < points.size(); j++) {

				Node next = points.get(j);

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
			path.add(next);

			path = getGreaterPathFrom(next, path);

			paths.add(path);
		}

		return paths;
	}

	private List<Node> getGreaterPathFrom(Node current, List<Node> pathToHere) {

		if (current.greatestDistanceFrom0x0 == null) {
			current.greatestDistanceFrom0x0 = new ArrayList<Node>(pathToHere);
		}

		if (current.greatestDistanceFrom0x0.size() > pathToHere.size()) {
			return current.greatestDistanceFrom0x0;
		}

		List<Node> greater = pathToHere;

		for (Node next : nexts(current)) {

			if (!next.equals(current) && next.x >= current.x && next.y >= current.y) {

				List<Node> tmp = getGreaterPathFrom(next, new ArrayList<Node>(pathToHere));

				if (tmp.size() > greater.size()) {
					greater = tmp;
				}
			}
		}

		current.greatestDistanceFrom0x0 = greater;

		return current.greatestDistanceFrom0x0;
	}

	int S() throws IOException {
		return SPath().size();
	}

	List<Node> SPath() throws IOException {

		int S = 0;
		List<Node> gpath = new ArrayList<Node>();

		fill();

		for (int i = 0; i < points.size(); i++) {

			Node current = points.get(i);

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

			try {

				System.out.println(new LongestPathSolution(22).S());
				System.out.println(new LongestPathSolution(123).S());
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