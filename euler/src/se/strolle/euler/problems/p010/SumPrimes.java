package se.strolle.euler.problems.p010;

import java.util.LinkedList;
import java.util.List;

public class SumPrimes {
	final static int TOP_NUM = 2000000;

	public static void main(String[] args) {
		long sum = 0L;
		long startTime = System.currentTimeMillis();
		List<Integer> primes = new LinkedList<Integer>();
		for (int i = 2; i < TOP_NUM; i++) {
			long testFactor = i / 2;
			if (i % 100000 == 0) {
				System.out.println(i + " - " + primes.size() + " - " + sum
						+ " - " + (System.currentTimeMillis() - startTime));
				startTime = System.currentTimeMillis();
			}
			boolean isPrime = true;
			for (int prime : primes) {
				if (prime > testFactor)
					break;
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
				sum += i;
			}
		}
		System.out.println("Sum: " + sum);
	}
}
