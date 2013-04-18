package se.strolle.euler.problems.p081;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import se.strolle.euler.util.FileUtil;

public class MatrixPath {
	static final int ROWS = 80;
	static final int COLS = 80;
	static int[][] rawData;
	static long[][] cacheData;

	public static void main(String args[]) throws IOException {
		init();

		long start = System.currentTimeMillis();

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				long leftCache = 0;
				long topCache = 0;
				if (row > 0)
					leftCache = cacheData[row - 1][col];
				if (col > 0)
					topCache = cacheData[row][col - 1];

				int boxValue = rawData[row][col];

				long newValue = 0;
				if (leftCache <= 0)
					newValue = boxValue + topCache;
				else if (topCache <= 0)
					newValue = boxValue + leftCache;
				else if (leftCache < topCache)
					newValue = boxValue + leftCache;
				else
					newValue = boxValue + topCache;

				cacheData[row][col] = newValue;
			}
		}
		String result = "" + cacheData[ROWS - 1][COLS - 1];
		long stop = System.currentTimeMillis();

		System.out.println("result: " + result);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);
	}

	private static void init() throws IOException {
		rawData = new int[ROWS][COLS];
		cacheData = new long[ROWS][COLS];

		BufferedReader br = new BufferedReader(new FileReader(
				FileUtil.getFile("/se/strolle/euler/problems/p081/matrix.txt")));

		try {
			int row = 0;
			String line = "";
			while ((line = br.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				for (int i = 0; tokenizer.hasMoreTokens(); i++) {
					rawData[row][i] = Integer.parseInt(tokenizer.nextToken());
				}
				row++;
			}

		} finally {
			br.close();
		}

	}
}
