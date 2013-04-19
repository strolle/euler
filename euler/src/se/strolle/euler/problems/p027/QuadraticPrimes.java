package se.strolle.euler.problems.p027;

import se.strolle.euler.util.PrimeUtil;

public class QuadraticPrimes {
    private static final int MAX_A = 1000;
    private static final int MAX_B = 1000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int bestA = 0;
        int bestB = 0;
        int bestValue = 0;

        for (int a = -MAX_A; a < MAX_A; a++) {
            for (int b = -MAX_B; b < MAX_B; b++) {
                int n = 0;
                while (true) {
                    int val = n * n + a * n + b;
                    if (!PrimeUtil.isPrime(val))
                        break;
                    n++;
                }
                if (n > bestValue) {
                    System.out.println("" + a + " - " + b + " => " + n);
                    bestValue = n;
                    bestA = a;
                    bestB = b;
                }
            }
        }

        long stop = System.currentTimeMillis();

        System.out.println("result: " + bestA * bestB);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);

    }
}
