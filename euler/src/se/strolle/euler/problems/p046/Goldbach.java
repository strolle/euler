package se.strolle.euler.problems.p046;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Goldbach {

	private static List<Integer> foundPrimes = new LinkedList<Integer>();
	private static Map<Integer, Integer> foundPrimesMap = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int notGoldbach = 0;
		foundPrimesMap.put(1, 1);
		for (int i = 3; true; i++) {
			if (i % 2 == 0)
				continue;
			if (isPrime(i)) {
				foundPrimes.add(i);
				foundPrimesMap.put(i, i);
				continue;
			}

			boolean isGoldbach = isGoldbach(i);
			if (!isGoldbach) {
				notGoldbach = i;
				break;
			}
		}

		long stop = System.currentTimeMillis();

		System.out.println("result: " + notGoldbach);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);

	}

	private static boolean isGoldbach(int number) {
		int start = (int) Math.floor(Math.sqrt(number));
		for (int i = start; i > 0; i--) {
			if (foundPrimesMap.containsKey(number - 2 * i * i))
				return true;
		}
		return false;
	}

	private static boolean isPrime(long numToCheck) {
		for (long prime : foundPrimes) {
			if (numToCheck % prime == 0) {
				return false;
			}
		}
		return true;
	}
}
