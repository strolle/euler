package se.strolle.euler.problems.p035;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CircularPrimes {
	private static final int MAX_NUMBER = 1000000;

	private static int maxTestedPrime = 2;

	private static List<Integer> foundPrimes = new LinkedList<Integer>();
	private static Map<String, Integer> foundPrimesMap = new HashMap<String, Integer>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int circularPrimeCount = 0;
		initPrimes();
		createPrimes(1000);
		System.out.println("Primes created");
		// System.out.println(Arrays.toString(foundPrimes.toArray()));
		for (int i = 0; i < MAX_NUMBER; i++) {
			if (i % 10000 == 1) {
				System.out.println(i);
			}
			if (isCircular(i)) {
				System.out.println("Cirkular: " + i);
				circularPrimeCount++;
			}
		}

		long stop = System.currentTimeMillis();

		System.out.println("\nresult: " + circularPrimeCount);
		System.out.println("\nmaxPrime: "
				+ foundPrimes.get(foundPrimes.size() - 1));
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);

	}

	private static void initPrimes() {
		foundPrimes.add(2);
		foundPrimesMap.put("" + 2, 2);
	}

	private static void createPrimes(int maxNumber) {
		int start = maxTestedPrime;
		if (start % 2 == 0)
			start++;
		for (int i = start; i <= maxNumber; i += 2) {
			// if (i % 10000 == 1) {
			// System.out.println(i + " - " + foundPrimes.size());
			// }

			boolean isPrime = true;
			for (int prime : foundPrimes) {
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
				if (prime > i / 2)
					break;
			}
			if (isPrime) {
				foundPrimes.add(i);
				foundPrimesMap.put("" + i, i);
			}
		}
		maxTestedPrime = maxNumber;
	}

	private static boolean isCircular(int number) {
		String strNumber = "" + number;

		List<String> permutations = new ArrayList<String>();
		// System.out.println("isCircular: " + strNumber);
		for (int i = 0; i < strNumber.length(); i++) {
			String newStr = strNumber.substring(i, strNumber.length())
					+ strNumber.substring(0, i);
			// System.out.println("test: " + newStr);
			permutations.add(newStr);
		}
		Collections.sort(permutations);

		for (String permutation : permutations) {
			if (!isPrime(permutation))
				return false;
		}
		return true;
	}

	// private static boolean isCircular(String numString, int fixedNumbers) {
	// if (fixedNumbers == numString.length()) {
	// System.out.println("test: " + numString);
	// return isPrime(numString);
	// }
	// for (int i = fixedNumbers; i < numString.length(); i++) {
	// String newString = numString.substring(0, fixedNumbers);
	//
	// newString += numString.charAt(i);
	//
	// newString += numString.substring(fixedNumbers, i)
	// + numString.substring(i + 1, numString.length());
	//
	// // System.out.println("newString: " + newString);
	// boolean circular = isCircular(newString, fixedNumbers + 1);
	// if (!circular)
	// return false;
	// }
	// return true;
	// }

	private static boolean isPrime(String number) {
		int num = Integer.parseInt(number);
		if (num > maxTestedPrime)
			createPrimes(num);
		return foundPrimesMap.containsKey(number);
	}
}
