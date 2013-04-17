package se.strolle.euler.problems.p056;

import java.math.BigInteger;

public class DigitSum {
	public static int MAX_VALUES = 100;

	public static void main(String args[]) {
		long start = System.currentTimeMillis();

		long max = 0L;

		for (int a = 1; a < MAX_VALUES; a++) {
			BigInteger current = new BigInteger("" + a);
			for (int b = 1; b <= MAX_VALUES; b++) {
				// System.err.println(a + "^" + b + "=" + current);
				long val = sumDigits(current);
				if (val > max)
					max = val;
				current = current.multiply(new BigInteger("" + a));
			}
		}

		long stop = System.currentTimeMillis();

		System.out.println("result: " + max);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);
	}

	private static long sumDigits(BigInteger current) {
		long cnt = 0;
		char[] numberStringArr = current.toString().toCharArray();
		for (char digitChar : numberStringArr) {
			cnt += (int) digitChar - 48;
		}
		return cnt;

	}
}
