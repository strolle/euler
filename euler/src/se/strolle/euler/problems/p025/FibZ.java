package se.strolle.euler.problems.p025;

import java.math.BigInteger;

public class FibZ {
	private static final int NUM_DIGITS = 1000;

	public static void main(String args[]) {
		System.out.println("result: " + getFibonacciOfXDigits(NUM_DIGITS));

		System.exit(0);
	}

	private static long getFibonacciOfXDigits(int x) {
		BigInteger lastVal = new BigInteger("0");
		BigInteger val = new BigInteger("1");
		long fibId = 1L;

		while (val.toString().length() < x) {
			BigInteger newVal = val.add(lastVal);
			fibId++;
			lastVal = val;
			val = newVal;

			if (fibId % 10000 == 0)
				System.out.println("" + fibId + ": " + val);
		}
		return fibId;
	}
}
