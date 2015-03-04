package com.thiagoh.projecteuler.p411;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

public class Solution4 {

	private static final boolean DEBUG = true;

	private Range loadedRange;
	private static Map<Range, File> _fileMap = new ConcurrentHashMap<Range, File>();

	private Map<Long, Node> _map = new HashMap<Long, Node>();
	private static boolean loaded = false;
	private static Object monitor = new Object();

	private Node[] points;

	private long n;

	public Solution4(long n) {
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

				File files = new File("files-modpow/");

				Collection<File> listFiles = FileUtils.listFiles(files, new IOFileFilter() {

					@Override
					public boolean accept(File file) {

						return file.getName().contains("modpow-" + n + "-");
					}

					@Override
					public boolean accept(File dir, String name) {

						return name.contains("modpow-" + n + "-");
					}
				}, null);

				for (File file : listFiles) {

					List<String> lines = FileUtils.readLines(file);
					String lineFrom = lines.get(0);
					String lineTo = lines.get(lines.size() - 1);

					Integer from = Integer.valueOf(lineFrom.split("=")[0]);
					Integer to = Integer.valueOf(lineTo.split("=")[0]);

					_fileMap.put(new Range(from, to), file);
				}

				synchronized (monitor) {
					loaded = true;
				}
			}
		}
	}

	private Map<Long, Node> getForI(long i) throws IOException {

		if (loadedRange != null && loadedRange.from <= i && loadedRange.to >= i) {
			return _map;
		}

		_map.clear();

		Set<Range> keys = _fileMap.keySet();
		Range range = null;

		for (Range curRange : keys) {

			if (curRange.from <= i && curRange.to >= i) {
				range = curRange;
				break;
			}
		}

		if (range != null) {

			File file = _fileMap.get(range);

			List<String> lines = FileUtils.readLines(file);

			for (String line : lines) {

				String[] split = line.split("=");

				Long lineI = Long.valueOf(split[0]);
				String[] xyArray = split[1].split(",");
				Long x = Long.valueOf(xyArray[0]);
				Long y = Long.valueOf(xyArray[1]);

				_map.put(lineI, new Node(x.intValue(), y.intValue()));
			}

			if (DEBUG) {
				System.out.println("Values from " + file.getName() + " Loaded");
			}

			loadedRange = range;
		}

		return _map;
	}

	private void fill() throws IOException {

		loadFiles();

		List<Node> list = new ArrayList<Node>();

		for (long i = 0; i <= 2 * n; i++) {

			Map<Long, Node> map = getForI(i);
			Node node = map.get(i);

			if (node.x > n || node.y > n || (node.x == 0 && node.y == 0)) {
				continue;
			}

			if (!list.contains(node)) {
				list.add(node);
			}
		}

		points = list.toArray(new Node[list.size()]);
		Arrays.sort(points);
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

	int S() throws IOException {
		return SPath().size();
	}

	List<Node> SPath() throws IOException {

		int S = 0;
		List<Node> gpath = new ArrayList<Node>();

		fill();

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

		try {

			if (false) {

				long t1 = System.currentTimeMillis();

				System.out.println(new Solution4(22).S());
				System.out.println(new Solution4(123).S());
				System.out.println(new Solution4(10000).S());
				System.out.println(new Solution4(100000).S());
				System.out.println(new Solution4(200000).S());
				System.out.println(new Solution4(400000).S());

				long t2 = System.currentTimeMillis();

				System.out.println("Costs " + (t2 - t1) + "ms");

				if (true)
					return;
			}

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

						try {

							int s = new Solution4(k5).S();

							map.put(k5, s);

							System.out.println("k " + k + " k5 " + k5 + " S(" + k5 + ") = " + s);

						} catch (IOException e) {
							e.printStackTrace();
						}
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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Range {

	long from;
	long to;

	public Range(long from, long to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (from ^ (from >>> 32));
		result = prime * result + (int) (to ^ (to >>> 32));
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
		Range other = (Range) obj;
		if (from != other.from)
			return false;
		if (to != other.to)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[from=" + from + ", to=" + to + "]";
	}

}