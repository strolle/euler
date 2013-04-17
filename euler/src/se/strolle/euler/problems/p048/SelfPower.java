package se.strolle.euler.problems.p048;

import java.math.BigInteger;

public class SelfPower {
	private static final int MAX_NUMBER = 1000;
	private static final int NUM_DIGITS = 10;

	public static void main(String args[]) {
		long result = 0;
		long modFilter = (long) (Math.pow(10, (NUM_DIGITS)) + 0.1);

		for (int i = 1; i <= MAX_NUMBER; i++) {
			BigInteger currentVal = new BigInteger("" + i);
			currentVal = currentVal.pow(i);

			String stringVal = currentVal.toString();
			if (stringVal.length() > 11) {
				stringVal = stringVal.substring(stringVal.length() - 11);
			}
			result += Long.parseLong(stringVal);
			result = result % modFilter;
		}
		System.out.println("result: " + result);

		System.exit(0);
	}

}
