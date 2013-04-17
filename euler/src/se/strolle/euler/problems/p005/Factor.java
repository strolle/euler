package se.strolle.euler.problems.p005;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Factor {
	final static int TOP_NUM = 20;

	public static void main(String[] args) {
		Map<Integer, Integer> factorMap = new HashMap<Integer, Integer>();

		List<Integer> primes = createPrimes(TOP_NUM);
		System.out.println("Primes: " + Arrays.toString(primes.toArray()));

		for (int i = 2; i <= TOP_NUM; i++) {
			Map<Integer, Integer> numberFactorMap = factorNumber(i, primes);
			for (int key : numberFactorMap.keySet()) {
				if (factorMap.get(key) != null) {
					if (factorMap.get(key) < numberFactorMap.get(key)) {
						factorMap.put(key, numberFactorMap.get(key));
					}
				} else {
					factorMap.put(key, numberFactorMap.get(key));
				}
			}
		}

		StringBuffer buf = new StringBuffer();
		int result = 1;
		for (int key : factorMap.keySet()) {
			int val = factorMap.get(key);
			buf.append("" + key + "^" + val + "+");
			for (int i = 0; i < val; i++)
				result *= key;
		}
		buf.replace(buf.length() - 1, buf.length(), "=");
		buf.append(result);
		System.out.println(buf.toString());

		System.exit(0);
	}

	private static List<Integer> createPrimes(int maxNumber) {
		List<Integer> primes = new LinkedList<Integer>();
		for (int i = 2; i < maxNumber; i++) {
			boolean isPrime = true;
			for (int prime : primes) {
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				primes.add(i);
		}
		return primes;
	}

	private static Map<Integer, Integer> factorNumber(int number,
			List<Integer> primes) {
		// int startNumber = number;
		List<Integer> result = new LinkedList<Integer>();
		while (number > 1) {
			for (int prime : primes) {
				if (number % prime == 0) {
					result.add(prime);
					number /= prime;
					break;
				}
			}
		}
		// System.out.println("" + startNumber + ": "+
		// Arrays.toString(result.toArray()));

		Map<Integer, Integer> numberFactorMap = new HashMap<Integer, Integer>();
		for (int factor : result) {
			if (numberFactorMap.get(factor) != null) {
				numberFactorMap.put(factor, numberFactorMap.get(factor) + 1);
			} else {
				numberFactorMap.put(factor, 1);
			}
		}

		return numberFactorMap;
	}
}
