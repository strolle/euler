package se.strolle.euler.problems.p206;

import java.util.regex.Pattern;

public class ConcealedSquare {
    private static final Pattern pattern = Pattern.compile("1\\d2\\d3\\d4\\d5\\d6\\d7\\d8\\d9\\d0");

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long minSqr = 1020304050607080900L;
        long minVal = (long) Math.sqrt(minSqr);

        long maxSqr = 1929394959697989990L;
        long maxVal = (long) Math.sqrt(maxSqr);
        while (minVal % 10 != 0)
            minVal++;

        System.out.println("testLength: " + (maxVal - minVal) / 10);
        long result = 0;

        for (long val = minVal; val <= maxSqr; val += 10) {
            String valString = "" + (val * val);
            if (pattern.matcher(valString).matches()) {
                result = val;
                break;
            }

        }

        long stop = System.currentTimeMillis();

        System.out.println("result: " + result);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);

    }
}
