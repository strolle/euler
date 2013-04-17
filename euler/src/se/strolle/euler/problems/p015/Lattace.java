package se.strolle.euler.problems.p015;

public class Lattace {
	static int SIZE = 21;
	static long[][] values = new long[SIZE][SIZE];

	public static void main(String[] args) {
		values[0][0] = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = i; j < SIZE; j++) {
				if (i == j && j == 0)
					continue;
				values[i][j] = calcualtePaths(i, j);
				values[j][i] = calcualtePaths(j, i);
				System.out.println("" + i + "," + j + ":"+values[i][j] + ","+values[j][i]);
			}
		}

		System.out.println("Result: " + values[SIZE-1][SIZE-1] +"\n");
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(values[i][j] +", ");
			}
			System.out.println();
		}

		System.exit(0);
	}

	private static long calcualtePaths(int row, int col) {
		long val = 0;
		if (row - 1 >= 0)
			val += values[row-1][col];
		if (col - 1 >= 0)
			val += values[row][col-1];
		return val;
	}
}
