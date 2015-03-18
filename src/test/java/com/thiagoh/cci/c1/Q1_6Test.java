package com.thiagoh.cci.c1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Q1_6Test {

	@Test
	public void testRotateImageLeft() throws IOException {

		BufferedImage img = ImageIO.read(new File("lena-small.bmp"));

		int[][] colors = new int[img.getWidth()][img.getHeight()];
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				colors[x][y] = img.getRGB(x, y);
			}
		}

		BufferedImage bufferedImage2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

		Q1_6.rotateLeft(colors);
		for (int y = 0; y < colors.length; y++) {
			for (int x = 0; x < colors[y].length; x++) {
				bufferedImage2.setRGB(x, y, colors[x][y]);
			}
		}

		ImageIO.write(bufferedImage2, "bmp", new File("lena-rotate-left.bmp"));
	}

	@Test
	public void testRotateLeft() throws IOException {

		int[][] arrNull = null;
		Q1_6.rotateLeft(arrNull);

		Assert.assertEquals(arrNull, null);

		int[][] arr1x1 = { { 1 } };
		Q1_6.rotateLeft(arr1x1);

		int[][] arr2x2 = { { 1, 2 }, { 3, 4 } };
		Q1_6.rotateLeft(arr2x2);

		int[][] arr3x3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Q1_6.rotateLeft(arr3x3);

		int[][] arr4x4 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(arr4x4);
		Q1_6.rotateLeft(arr4x4);
		print(arr4x4);

		int[][] arr5x5 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		print(arr5x5);
		Q1_6.rotateLeft(arr5x5);
		print(arr5x5);
	}
	
	@Test
	public void testRotateImageRight() throws IOException {
		
		BufferedImage img = ImageIO.read(new File("lena-small.bmp"));
		
		int[][] colors = new int[img.getWidth()][img.getHeight()];
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				colors[x][y] = img.getRGB(x, y);
			}
		}
		
		BufferedImage bufferedImage2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		Q1_6.rotateRight(colors);
		for (int y = 0; y < colors.length; y++) {
			for (int x = 0; x < colors[y].length; x++) {
				bufferedImage2.setRGB(x, y, colors[x][y]);
			}
		}
		
		ImageIO.write(bufferedImage2, "bmp", new File("lena-rotate-right.bmp"));
	}
	
	@Test
	public void testRotateRight() throws IOException {
		
		int[][] arrNull = null;
		Q1_6.rotateRight(arrNull);
		
		Assert.assertEquals(arrNull, null);
		
		int[][] arr1x1 = { { 1 } };
		Q1_6.rotateRight(arr1x1);
		
		int[][] arr2x2 = { { 1, 2 }, { 3, 4 } };
		Q1_6.rotateRight(arr2x2);
		
		int[][] arr3x3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Q1_6.rotateRight(arr3x3);
		
		int[][] arr4x4 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(arr4x4);
		Q1_6.rotateRight(arr4x4);
		print(arr4x4);
		
		int[][] arr5x5 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		print(arr5x5);
		Q1_6.rotateRight(arr5x5);
		print(arr5x5);
	}

	private void print(int[][] arr) {

		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < arr.length; y++) {
			sb.append(Arrays.toString(arr[y])).append("\n");
		}
		System.out.println(sb.toString());
	}
}
