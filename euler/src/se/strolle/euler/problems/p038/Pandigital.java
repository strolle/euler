package se.strolle.euler.problems.p038;

public class Pandigital {
	static final int ASCII_POS = 48;

	static final int FALSE = 1;
	static final int FALSE_BREAK = 2;
	static final int TRUE = 3;
	static final int FALSE_BREAK_INNER = 4;

	public static void main(String args[]) {
		int max = 987654321;

		long start = System.currentTimeMillis();
		int largestFound = 0;

		loop1: for (int i = 1; i < max; i++) {
			String valString = "" + i;
			for (int j = 2; j < max; j++) {
				valString += (i * j);

				int test = isPandigital(valString);
				if (test == FALSE_BREAK && j == 2)
					break loop1;
				if (test == FALSE_BREAK || test == FALSE_BREAK_INNER)
					break;

				if (test == TRUE) {
					System.out.println("" + i + " - " + j + " -> " + valString);
					if (Integer.parseInt(valString) > largestFound)
						largestFound = Integer.parseInt(valString);
				}
			}
		}
		long stop = System.currentTimeMillis();

		System.out.println("result: " + largestFound);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);
	}

	private static int isPandigital(String valString) {
		boolean[] used = new boolean[10];

		if (valString.length() > 9)
			return FALSE_BREAK;
		if (valString.length() < 9)
			return FALSE;
		for (int i = 0; i < valString.length(); i++) {
			int val = valString.charAt(i) - ASCII_POS;
			if (used[val] || val == 0)
				return FALSE_BREAK_INNER;
			used[val] = true;
		}

		return TRUE;
	}
}
