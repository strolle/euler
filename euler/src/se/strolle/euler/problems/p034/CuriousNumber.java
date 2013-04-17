package se.strolle.euler.problems.p034;

import java.util.HashMap;
import java.util.Map;

public class CuriousNumber {
	public static void main(String args[]) {
		Map<Integer, Integer> factorials = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			int val = calculateFactorial(i);
			factorials.put(i, val);
		}

		int maxDigits = 1;
		while (true) {
			int pow = (int) (Math.pow(10, maxDigits) + 0.1);
			int sum = factorials.get(9) * maxDigits;
			if (pow > sum)
				break;
			maxDigits++;
		}
		System.err.println(maxDigits);

		long result = 0;
		int maxVal = (int) (Math.pow(10, maxDigits) + 0.1);
		for (int i = 10; i <= maxVal; i++) {
			int sum = 0;
			int tmpVal = i;
			while (tmpVal > 0) {
				int digit = tmpVal % 10;
				sum += factorials.get(digit);
				tmpVal /= 10;
			}

			if (sum == i) {
				result += i;
			}
		}
		System.out.println("result: " + result);

		System.exit(0);
	}

	private static int calculateFactorial(int num) {
		int res = 1;
		for (int i = 1; i <= num; i++)
			res *= i;
		return res;
	}

}
