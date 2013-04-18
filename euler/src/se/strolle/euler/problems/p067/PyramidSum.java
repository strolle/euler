package se.strolle.euler.problems.p067;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import se.strolle.euler.util.FileUtil;

public class PyramidSum {
	public static void main(String[] args) throws Exception {
		long result = 0;

		int[][] input = readInput();
		long[][] sum = new long[input.length][];

		for (int row = 0; row < input.length; row++) {
			sum[row] = new long[input[row].length];
			for (int col = 0; col < input[row].length; col++) {
				long val = input[row][col];
				long bestPrevious = 0L;
				if (row - 1 >= 0) {
					if (input[row - 1].length > col)
						bestPrevious = sum[row - 1][col];
					if (col - 1 >= 0 && sum[row - 1][col - 1] > bestPrevious)
						bestPrevious = sum[row - 1][col - 1];
				}
				val += bestPrevious;
				sum[row][col] = val;
				if (row + 1 == input.length && val > result)
					result = val;
			}
		}

		System.out.println("Result: " + result);

		System.exit(0);
	}

	static int[][] readInput() throws Exception {
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								FileUtil.getFile("/se/strolle/euler/problems/p067/triangle.txt"))));
		int[][] input = new int[100][];

		String line = "";
		int i = 0;
		while ((line = buf.readLine()) != null) {
			input[i] = new int[i + 1];
			String[] lineSplit = line.split(" ");
			for (int j = 0; j < lineSplit.length; j++) {
				input[i][j] = Integer.valueOf(lineSplit[j]);
			}
			i++;
		}
		return input;
	}
}
