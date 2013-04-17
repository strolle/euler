package se.strolle.euler.problems.p014;

import java.util.HashMap;
import java.util.Map;

public class LongestChain {
	static Map<Long, Long> calcMap = new HashMap<Long, Long>();

	public static void main(String[] args) {
		long longestChain = 0;
		long longestStartVal = 0;
		for (long i = 2; i < 1000000; i++) {
			long length = calculateLength(i);

			if (length > longestChain) {
				longestChain = length;
				longestStartVal = i;
			}
		}
		System.out.println("longestStartVal: " + longestStartVal);
		System.out.println("longestChain: " + longestChain);
		System.exit(0);
	}

	private static long calculateLength(long startVal) {
		if (startVal == 1)
			return 1;
		if (calcMap.get(startVal) != null) {
			return calcMap.get(startVal) - 1;
		}
		if (startVal % 2 == 0) {
			long newVal = startVal / 2;
			long length = 1 + calculateLength(newVal);
			calcMap.put(newVal, length);
			return length;
		} else {
			long newVal = 3 * startVal + 1;
			long length = 1 + calculateLength(newVal);
			calcMap.put(newVal, length);
			return length;
		}
	}
}
