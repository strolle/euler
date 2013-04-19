package se.strolle.euler.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrimeUtil {
    static long maxTested = 1;
    private static List<Long> foundPrimes = new LinkedList<Long>();
    private static Map<Long, Boolean> foundPrimesMap = new HashMap<Long, Boolean>();

    public static boolean isPrime(long numToCheck) {
        while (maxTested < numToCheck) {
            boolean isPrime = true;
            maxTested++;
            for (long prime : foundPrimes) {
                if (maxTested % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                foundPrimes.add(maxTested);
                foundPrimesMap.put(maxTested, true);
            }
        }

        return foundPrimesMap.containsKey(numToCheck);
    }
}
