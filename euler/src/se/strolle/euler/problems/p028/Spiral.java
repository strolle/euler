package se.strolle.euler.problems.p028;

public class Spiral {
	private static final int SIZE = 1001;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int[][] val = new int[SIZE][SIZE];

		int rowPos = SIZE / 2;
		int colPos = SIZE / 2;
		val[rowPos][colPos] = 1;
		colPos++;
		val[rowPos][colPos] = 2;
		rowPos++;

		int dir = 1;

		for (int i = 2; i < SIZE * SIZE; i++) {
			val[rowPos][colPos] = i + 1;

			if ((i + 1) == SIZE * SIZE)
				continue;
			if (dir == 0) {
				rowPos++;
				if (val[rowPos][colPos - 1] > 0) {
					continue;
				}
				dir = 1;
			} else if (dir == 1) {
				colPos--;
				if (val[rowPos - 1][colPos] > 0) {
					continue;
				}
				dir = 2;
			} else if (dir == 2) {
				rowPos--;
				if (val[rowPos][colPos + 1] > 0) {
					continue;
				}
				dir = 3;
			} else if (dir == 3) {
				colPos++;
				if (val[rowPos + 1][colPos] > 0) {
					continue;
				}
				dir = 0;
			}

		}

		int cnt = 0;
		for (int i = 0; i < SIZE; i++) {
			cnt += val[i][i];
			if (i != (SIZE - 1 - i))
				cnt += val[i][SIZE - 1 - i];
		}

		long stop = System.currentTimeMillis();

		System.out.println("\nresult: " + cnt);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);

	}
}
