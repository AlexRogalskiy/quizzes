package com.thiagoh.projecteuler.p411;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.apache.commons.io.IOUtils;

public class SimpleLongestPathSolution {

	private static final boolean DEBUG = false;

	List<Integer> points;

	private long n;

	public SimpleLongestPathSolution(long n) {
		this.n = n;
	}

	int calc(File pointsJoinedSorted) throws IOException {

		points = new ArrayList<Integer>();

		List<String> lines = IOUtils.readLines(new FileInputStream(pointsJoinedSorted));

		for (String line : lines) {

			String[] split = line.split(",");

			points.add(Integer.valueOf(split[1]));
		}

		lines.clear();
		lines = null;

		return getLonguestLength();
	}

	private int getLonguestLength() {

		// length = len(sequence)
		// if length == 0:
		// return 0
		// subsequence = [sequence[0]]
		// for i in range(1, length):
		// n = sequence[i]
		// if n >= subsequence[-1]:
		// subsequence.append(n)
		// else:
		// subsequence[bisect.bisect_right(subsequence, n)] = n
		// return len(subsequence)

		int length = points.size();

		if (length == 0)
			return 0;

		List<Integer> subsequence = new ArrayList<Integer>();
		subsequence.add(points.get(0));

		for (int i = 1; i < points.size(); i++) {

			Integer n = points.get(i);

			if (n >= subsequence.get(subsequence.size() - 1)) {
				subsequence.add(n);
			} else {
				l2: for (int j = 0; j < subsequence.size(); j++) {
					if (n < subsequence.get(j)) {
						subsequence.set(j, n);
						break l2;
					}
				}
			}
		}

		return subsequence.size();
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

		if (DEBUG) {
			System.out.println("S(" + n + ") = " + s);
		}

		return s;
	}

	public static void main(String[] args) {

		if (false) {

			try {

				System.out.println(new SimpleLongestPathSolution(22).S());
				System.out.println(new SimpleLongestPathSolution(123).S());
				System.out.println(new SimpleLongestPathSolution(500).S());
				System.out.println(new SimpleLongestPathSolution(1000).S());
				System.out.println(new SimpleLongestPathSolution(1500).S());
				System.out.println(new SimpleLongestPathSolution(2000).S());
				System.out.println(new SimpleLongestPathSolution(10000).S());

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

				int s = new SimpleLongestPathSolution(k5).S();

				sum += s;

				System.out.println("k " + k + " k5 " + k5 + " S(" + k5 + ") = " + s);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Sum is: " + sum);
	}
}