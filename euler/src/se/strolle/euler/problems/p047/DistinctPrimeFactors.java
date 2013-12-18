package se.strolle.euler.problems.p047;

import java.util.LinkedList;

import se.strolle.euler.util.PrimeUtil;

public class DistinctPrimeFactors {
    private static LinkedList<Long> storedPrimes = new LinkedList<Long>();

    public static void main(String[] args) {
        int FACTORS_TO_FIND = 4;
        long start = System.currentTimeMillis();
        storedPrimes.add(2L);
        storedPrimes.add(3L);
        int okCnt = 0;
        long i = 10;
        while (okCnt < FACTORS_TO_FIND) {
            int factorCnt = countFactors(i);
            i++;
            if (factorCnt == FACTORS_TO_FIND) {
                okCnt++;
            }
            else {
                okCnt = 0;
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("result: " + (i - FACTORS_TO_FIND));
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    // Not the prettiest method...
    private static int countFactors(long i) {
        long remainder = i;
        int factorCnt = 0;
        // Test already calculated primes
        for (long currentTest : storedPrimes) {
            boolean isFactor = false;
            while (remainder % currentTest == 0) {
                isFactor = true;
                remainder /= currentTest;
            }
            if (isFactor)
                factorCnt++;
            if (remainder <= 1)
                return factorCnt;
        }

        // test new primes
        long currentTest = storedPrimes.getLast();
        while (remainder > 1) {
            boolean isFactor = false;
            while (remainder % currentTest == 0) {
                isFactor = true;
                remainder /= currentTest;
            }
            if (isFactor)
                factorCnt++;
            currentTest = nextPrime(currentTest);
        }
        return factorCnt;
    }

    private static long nextPrime(long input) {
        while (storedPrimes.getLast() <= input) {
            long lastFound = storedPrimes.getLast();
            lastFound += 2;
            while (!PrimeUtil.isPrime(lastFound)) {
                lastFound += 2;
            }
            storedPrimes.addLast(lastFound);
        }
        return storedPrimes.getLast();
    }

}
