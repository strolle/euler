package se.strolle.euler.problems.p026;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReciprocalCycles {
    private static final int MAX_NUM = 1000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int maxCycle = 0;
        int maxCycleValue = 0;
        for (int i = 3; i <= MAX_NUM; i++) {
            BigDecimal d = new BigDecimal(1);
            BigDecimal result = d.divide(new BigDecimal(i), 5000,
                    RoundingMode.DOWN);

            int cycle = detectCycle(result);
            if (cycle > maxCycle) {
                maxCycle = cycle;
                maxCycleValue = i;
            }

        }

        long stop = System.currentTimeMillis();

        System.out.println("\nresult: " + maxCycleValue);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);

    }

    private static int detectCycle(BigDecimal result) {
        String decimals = result.toString().substring(2);

        for (int i = 1; i < decimals.length() / 4; i++) {
            String substring = decimals.substring(decimals.length() - i, decimals.length());
            if (decimals.endsWith(substring + substring + substring)) {
                return substring.length();
            }
        }
        return -1;
    }
}
