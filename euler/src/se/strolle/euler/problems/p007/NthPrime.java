package se.strolle.euler.problems.p007;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NthPrime {
	final static int PRIME_TO_FIND = 10001;

	public static void main(String[] args) {
		long prime = findPrime(PRIME_TO_FIND);
		System.out.println("Prime: " + prime);

		System.exit(0);
	}

	private static Long findPrime(int maxNumber) {
		List<Long> primes = new LinkedList<Long>();
		primes.add(2L);
		long i = 3;
		while (primes.size() < maxNumber) {
			boolean isPrime = true;
			for (long prime : primes) {
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				primes.add(i);
			i += 2;
		}
		System.out.println("Primes: " + primes.size() + " : "
				+ Arrays.toString(primes.toArray()));
		return primes.get(primes.size() - 1);
	}
}
