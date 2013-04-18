package se.strolle.euler.problems.p029;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DistinctPowers {
	private static final int MAX = 100;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Map<BigInteger, Boolean> values = new HashMap<BigInteger, Boolean>();

		for (int i = 2; i <= MAX; i++) {
			for (int j = 2; j <= MAX; j++) {
				BigInteger a = new BigInteger("" + i);
				BigInteger result = a.pow(j);
				values.put(result, true);
			}
		}

		int cnt = values.size();
		long stop = System.currentTimeMillis();

		System.out.println("\nresult: " + cnt);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);

	}
}
