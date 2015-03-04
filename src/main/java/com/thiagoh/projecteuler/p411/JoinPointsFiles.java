package com.thiagoh.projecteuler.p411;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

public class JoinPointsFiles {

	private long n;

	public JoinPointsFiles(long n) {
		this.n = n;
	}

	private void join() throws IOException {

		File pointsJoined = new File("files-points-joined/joined-" + n);

		FileUtils.deleteQuietly(pointsJoined);
		FileUtils.touch(pointsJoined);

		OutputStream output = new FileOutputStream(pointsJoined);

		File pointsDir = new File("files-points/");

		Collection<File> listFiles = FileUtils.listFiles(pointsDir, new IOFileFilter() {

			@Override
			public boolean accept(File file) {

				return file.getName().contains("points-" + n + "-");
			}

			@Override
			public boolean accept(File dir, String name) {

				return name.contains("points-" + n + "-");
			}
		}, null);

		for (File file : listFiles) {

			IOUtils.copyLarge(new FileInputStream(file), output);
		}
	}

	public static void main(String[] args) {

		try {

			if (true) {

				new JoinPointsFiles(22).join();
				new JoinPointsFiles(123).join();
				new JoinPointsFiles(10000).join();

				return;
			}

			for (int i = 1; i <= 30; i++) {

				new JoinPointsFiles((long) Math.pow(i, 5)).join();
			}

			System.out.println("All files were filled!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
