package se.strolle.euler.problems.p050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitPowers {
	private static final int POWER = 5;

	public static void main(String args[]) {
		Map<Integer, Integer> powers = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			int val = (int) (Math.pow(i, POWER) + 0.1);
			powers.put(i, val);
		}
		int maxDigits = 1;
		while (true) {
			int pow = (int) (Math.pow(10, maxDigits) + 0.1);
			int sum = powers.get(9) * maxDigits;
			if (pow > sum)
				break;
			maxDigits++;
		}
		System.err.println(maxDigits);

		List<Integer> hits = new ArrayList<Integer>();
		int maxVal = (int) (Math.pow(10, maxDigits) + 0.1);
		System.err.println(maxVal);
		for (int i = 2; i < maxVal; i++) {
			int sum = 0;
			int tmpVal = i;
			while (tmpVal > 0) {
				int digit = tmpVal % 10;
				sum += powers.get(digit);
				tmpVal /= 10;
			}
			// System.err.println("sum: " + sum);

			if (sum == i)
				hits.add(i);
		}

		int result = 0;
		for (int hit : hits) {
			result += hit;
		}
		System.out.println("result: " + result);

		System.exit(0);
	}

}
