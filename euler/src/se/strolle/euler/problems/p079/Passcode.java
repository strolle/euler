package se.strolle.euler.problems.p079;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Passcode {
    static int ASCII_BASE = 48;
    static String[] codes = new String[] {"319", "680", "180", "690", "129",
            "620", "762", "689", "762", "318", "368", "710", "720", "710",
            "629", "168", "160", "689", "716", "731", "736", "729", "316",
            "729", "729", "710", "769", "290", "719", "680", "318", "389",
            "162", "289", "162", "718", "729", "319", "790", "680", "890",
            "362", "319", "760", "316", "729", "380", "319", "728", "716"};

    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        Map<Integer, Map<Integer, Integer>> numbersBefore = new HashMap<Integer, Map<Integer, Integer>>();

        for (int i = 0; i < codes.length; i++) {
            System.err.println("\nCode: " + codes[i]);
            for (int j = 0; j < 3; j++) {
                Map<Integer, Integer> map = numbersBefore.get((int) codes[i].charAt(j));
                if (map == null) {
                    map = new HashMap<Integer, Integer>();
                    numbersBefore.put((int) codes[i].charAt(j), map);
                }
                for (int k = 0; k < j; k++) {
                    map.put((int) codes[i].charAt(k), codes[i].charAt(k) - ASCII_BASE);
                    System.err.println("put: " + codes[i].charAt(k) + " before " + codes[i].charAt(j));
                }
                System.err.println("map " + codes[i].charAt(j) + ": " + Arrays.toString(map.values().toArray()));
                numbersBefore.put((int) codes[i].charAt(j), map);
            }
        }

        for (int number : numbersBefore.keySet()) {
            System.err.println((number - ASCII_BASE)
                    + ": "
                    + Arrays.toString(numbersBefore.get(number).values()
                            .toArray()));
        }

        String result = "";
        long stop = System.currentTimeMillis();

        System.out.println("result: " + result);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }
}
