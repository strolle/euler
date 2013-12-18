package se.strolle.euler.problems.p049;

import se.strolle.euler.util.PrimeUtil;

public class PrimePermutations {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long prime = PrimeUtil.nextPrime(1001);
        while (prime < 10000) {
            midLoop: for (int i = 2; i < 10000; i += 2) {
                boolean ok = true;
                for (int j = 0; j < 2; j++) {
                    long valToTest = prime + i * (j + 1);
                    if (valToTest > 10000)
                        break midLoop;
                    if (!isPermutation(prime, valToTest) || !PrimeUtil.isPrime(valToTest)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println(prime + ":" + (prime + i) + ":" + (prime + i * 2) + "=>" + prime + "" + (prime + i) + "" + (prime + i * 2));
                }
            }
            prime = PrimeUtil.nextPrime(prime);
        }

        long stop = System.currentTimeMillis();
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static boolean isPermutation(long prime, long test2) {
        int[] nums1 = new int[] {(int) prime / 1000, (int) (prime / 100) % 10, (int) (prime / 10) % 10, (int) prime % 10};
        int[] nums2 = new int[] {(int) test2 / 1000, (int) (test2 / 100) % 10, (int) (test2 / 10) % 10, (int) test2 % 10};
        for (int n1 : nums1) {
            boolean ok = false;
            for (int i = 0; i < nums2.length; i++) {
                int n2 = nums2[i];
                if (n1 == n2) {
                    nums2[i] = -1;
                    ok = true;
                    break;
                }
            }
            if (!ok)
                return false;
        }
        return true;
    }
}
