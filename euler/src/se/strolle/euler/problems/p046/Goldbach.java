package se.strolle.euler.problems.p046;

import se.strolle.euler.util.PrimeUtil;

public class Goldbach {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int notGoldbach = 0;

        for (int i = 3; true; i++) {
            if (i % 2 == 0)
                continue;
            if (PrimeUtil.isPrime(i)) {
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
            if (PrimeUtil.isPrime(number - 2 * i * i))
                return true;
        }
        return false;
    }

}
