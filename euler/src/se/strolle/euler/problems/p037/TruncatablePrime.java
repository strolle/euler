package se.strolle.euler.problems.p037;

import se.strolle.euler.util.PrimeUtil;

public class TruncatablePrime {
    private static final int NUM_TO_FIND = 11;

    public static void main(String[] args) {
        long sum = 0L;
        int numFound = 0;

        long i = 3;
        while (numFound < NUM_TO_FIND) {
            boolean isPrime = PrimeUtil.isPrime(i);
            if (isPrime) {
                if (isTruncatable(i)) {
                    numFound++;
                    sum += i;
                    System.out.println("truncatable: " + i + " numFound: " + numFound);
                }
            }

            i += 2;
        }
        System.out.println("Sum: " + sum);

        System.exit(0);
    }

    private static boolean isTruncatable(long i) {
        if (i <= 10)
            return false;
        if (!isTruncatableRight(i))
            return false;
        if (!isTruncatableLeft(i))
            return false;

        return true;

    }

    private static boolean isTruncatableRight(long i) {
        long num = i / 10;
        while (num >= 1) {
            // System.out.println("right test: " + i + " - " + num + " - " + primes.containsKey(num));
            if (!PrimeUtil.isPrime(num)) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    private static boolean isTruncatableLeft(long i) {
        int digits = ("" + i).length();
        digits--;
        while (digits > 0) {
            long num = i % (long) Math.pow(10, digits);
            // System.out.println("left test: " + i + " - " + num + " - " + primes.containsKey(num));
            if (!PrimeUtil.isPrime(num))
                return false;
            digits--;
        }
        return true;
    }
}
