package com.thiagoh.projecteuler.p411;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FillFileModPow {

	private static final int FLUSH_INTERVAL = 50000;
	private static final long FILE_SIZE_ROTATION = 30 * 1024 * 1024;

	private final Object writeMonitor = new Object();
	private long n;
	private BigInteger nbi;

	static final BigInteger one = BigInteger.valueOf(1L);
	static final BigInteger two = BigInteger.valueOf(2L);
	static final BigInteger three = BigInteger.valueOf(3L);

	public FillFileModPow(long n) {
		this.n = n;
		this.nbi = BigInteger.valueOf(n);
	}

	private void fill() throws IOException {

		int modPowRotation = 1;
		int pointsRotation = 1;
		File modPowFile = getModPowFile(modPowRotation, true);
		File pointsFile = getPointsFile(pointsRotation, true);

		Comparator<Node> nodeComparator = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {

				int v = 0;
				if (o1.x > o2.x) {
					v = 1;
				} else if (o1.x == o2.x) {
					if (o1.y > o2.y) {
						v = 1;
					} else if (o1.y == o2.y) {
						v = 0;
					} else {
						v = -1;
					}

				} else {
					v = -1;
				}

				return v;
			}
		};

		List<String> linesModPow = new ArrayList<String>();
		List<Node> linesPoints = new ArrayList<Node>();

		for (long i = 0; i <= 2L * n; i++) {

			long x = two.modPow(BigInteger.valueOf(i), nbi).longValue();
			long y = three.modPow(BigInteger.valueOf(i), nbi).longValue();

			if (x > n || y > n || (x == 0 && y == 0)) {
				continue;
			}

			Node node = new Node((int) x, (int) y);

			String s = new StringBuilder().append(i).append("=").append(node.toString()).toString();

			linesModPow.add(s);
			linesPoints.add(node);

			if (linesPoints.size() >= FLUSH_INTERVAL) {
				synchronized (writeMonitor) {

					try {

						linesPoints = new ArrayList<Node>(new HashSet<Node>(linesPoints));
						Collections.sort(linesPoints, nodeComparator);

						FileUtils.writeLines(modPowFile, linesModPow, true);
						FileUtils.writeLines(pointsFile, linesPoints, true);

						linesModPow.clear();
						linesPoints.clear();

						Thread.sleep(30);

						if (modPowFile.length() > FILE_SIZE_ROTATION) {
							modPowFile = getModPowFile(++modPowRotation, true);
							pointsFile = getPointsFile(++pointsRotation, true);
						}

					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		synchronized (writeMonitor) {

			try {

				if (!linesModPow.isEmpty()) {
					FileUtils.writeLines(modPowFile, linesModPow, true);
					linesModPow.clear();
				}

				if (!linesPoints.isEmpty()) {

					linesPoints = new ArrayList<Node>(new HashSet<Node>(linesPoints));
					Collections.sort(linesPoints, nodeComparator);

					FileUtils.writeLines(pointsFile, linesPoints, true);
					linesPoints.clear();
				}

				Thread.sleep(30);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private File getModPowFile(int rotation, boolean recreate) throws IOException {

		File file = new File("files-modpow/modpow-" + n + "-" + rotation + ".txt");

		if (recreate) {
			FileUtils.deleteQuietly(file);
			FileUtils.touch(file);
		}

		return file;
	}

	private File getPointsFile(int rotation, boolean recreate) throws IOException {

		File file = new File("files-points/points-" + n + "-" + rotation + ".txt");

		if (recreate) {
			FileUtils.deleteQuietly(file);
			FileUtils.touch(file);
		}

		return file;
	}

	public static void main(String[] args) {

		try {

			if (true) {

				new FillFileModPow(22).fill();
				new FillFileModPow(123).fill();
				new FillFileModPow(500).fill();
				new FillFileModPow(1000).fill();
				new FillFileModPow(1500).fill();
				new FillFileModPow(2000).fill();
				new FillFileModPow(10000).fill();

				return;
			}

			for (int i = 1; i <= 30; i++) {

				new FillFileModPow((long) Math.pow(i, 5)).fill();
			}

			System.out.println("All files were filled!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}