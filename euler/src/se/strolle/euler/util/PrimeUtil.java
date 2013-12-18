package se.strolle.euler.util;

public class PrimeUtil {
    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        } else {
            for (int divisor = 3; divisor <= Math.sqrt(num); divisor += 2) {
                if (num % divisor == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static long nextPrime(long input) {
        long lastFound = input;
        if (input == 2)
            lastFound++;
        else
            lastFound += 2;

        while (!PrimeUtil.isPrime(lastFound)) {
            lastFound += 2;
        }
        return lastFound;
    }

    public static long previousPrime(long input) {
        long lastFound = input;
        if (input == 2)
            return -1;
        else
            lastFound -= 2;

        while (!PrimeUtil.isPrime(lastFound)) {
            lastFound -= 2;
        }
        return lastFound;
    }

}
