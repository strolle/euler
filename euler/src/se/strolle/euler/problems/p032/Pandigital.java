package se.strolle.euler.problems.p032;

import java.util.HashMap;
import java.util.Map;

public class Pandigital {
	static final int ASCII_POS = 48;

	static final int FALSE = 1;
	static final int FALSE_BREAK = 2;
	static final int TRUE = 3;

	public static void main(String args[]) {
		int max = 987654321;

		long start = System.currentTimeMillis();

		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		long sum = 0;

		loop1: for (int i = 1; i < max; i++) {
			for (int j = i + 1; j < max; j++) {
				int val = i * j;
				int test = isPandigital(i, j, val);
				if (test == FALSE_BREAK && j == i + 1)
					break loop1;
				if (test == FALSE_BREAK)
					break;

				if (test == TRUE && !map.containsKey(val)) {
					map.put(val, true);
					sum += val;
				}
			}
		}
		long stop = System.currentTimeMillis();

		System.out.println("result: " + sum);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);
	}

	private static int isPandigital(int factor1, int factor2, int product) {
		boolean[] used = new boolean[10];

		String valString = "" + factor1 + factor2 + product;
		if (valString.length() > 9)
			return FALSE_BREAK;
		if (valString.length() < 9)
			return FALSE;
		for (int i = 0; i < valString.length(); i++) {
			int val = valString.charAt(i) - ASCII_POS;
			if (used[val] || val == 0)
				return FALSE;
			used[val] = true;
		}

		return TRUE;
	}
}
