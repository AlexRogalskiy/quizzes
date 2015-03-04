package com.thiagoh.projecteuler.p411;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FillFile {

	private static final int FLUSH_INTERVAL = 40000;
	private static final long FILE_SIZE_ROTATION = 15 * 1024 * 1024;

	private final Object writeMonitor = new Object();
	private long n;

	public FillFile(long n) {
		this.n = n;
	}

	private void fill() throws IOException {

		int rotation = 1;
		File file = getFile(rotation, true);

		final ModPowCalculator calc = new ModPowCalculator(n);

		List<String> lines = new ArrayList<String>();

		for (long i = 0; i <= 2L * n; i++) {

			long x = calc.getX(i);

			if (x > n) {
				continue;
			}

			long y = calc.getY(i);

			if (y > n) {
				continue;
			}

			if (x == 0 && y == 0) {
				continue;
			}

			String s = new StringBuilder().append(i).append("=").append(x).append(",").append(y).toString();

			lines.add(s);

			if (lines.size() >= FLUSH_INTERVAL) {
				synchronized (writeMonitor) {

					try {

						FileUtils.writeLines(file, lines, true);

						lines.clear();

						Thread.sleep(30);

						if (file.length() > FILE_SIZE_ROTATION) {
							file = getFile(++rotation, true);
						}

					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private File getFile(int rotation, boolean recreate) throws IOException {

		File file = new File("files/modpow-" + rotation + ".txt");

		if (recreate){
			FileUtils.deleteQuietly(file);
			FileUtils.touch(file);
		}

		return file;
	}

	public static void main(String[] args) {

		try {

			int k30Pow5 = (int) Math.pow(30, 5);

			new FillFile(k30Pow5).fill();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}