package com.thiagoh.projecteuler.p411;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.google.code.externalsorting.ExternalSort;

public class SortPointsFiles {

	private long n;

	public SortPointsFiles(long n) {
		this.n = n;
	}

	private void sort() throws IOException {

		File pointsJoinedSorted = new File("files-points-joined-sorted/joined-sorted-" + n);

		FileUtils.deleteQuietly(pointsJoinedSorted);
		FileUtils.touch(pointsJoinedSorted);

		OutputStream output = new FileOutputStream(pointsJoinedSorted);

		File joinedFile = new File("files-points-joined/joined-" + n);

		List<File> sortedFiles = ExternalSort.sortInBatch(joinedFile, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				String[] split1 = o1.split(",");
				Node node1 = new Node(Integer.valueOf(split1[0]), Integer.valueOf(split1[1]));

				String[] split2 = o2.split(",");
				Node node2 = new Node(Integer.valueOf(split2[0]), Integer.valueOf(split2[1]));

				return node1.compareTo(node2);
			}
		}, true);

		for (File file : sortedFiles) {

			IOUtils.copyLarge(new FileInputStream(file), output);
		}
	}

	public static void main(String[] args) {

		try {

			if (true) {

				new SortPointsFiles(22).sort();
				new SortPointsFiles(123).sort();
				new SortPointsFiles(10000).sort();

				return;
			}

			for (int i = 1; i <= 30; i++) {

				new SortPointsFiles((long) Math.pow(i, 5)).sort();
			}

			System.out.println("All files were filled!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
