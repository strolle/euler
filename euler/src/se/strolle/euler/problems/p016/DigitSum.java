package se.strolle.euler.problems.p016;

import java.math.BigInteger;

public class DigitSum {
	static int POW = 1000;

	public static void main(String[] args) {
		BigInteger val = new BigInteger("2");
		val = val.shiftLeft(POW - 1);

		long result = 0;
		char[] resultArr = val.toString().toCharArray();
		int charVal = '0';
		for (char character : resultArr) {
			result += (character - charVal);
		}
		System.out.println("Result: " + result);
		System.exit(0);
	}
}
