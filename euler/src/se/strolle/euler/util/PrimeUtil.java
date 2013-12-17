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

}
