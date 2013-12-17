package se.strolle.euler.problems.p039;

import java.util.HashMap;
import java.util.Map;

public class RightTriangles {

    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        Map<Integer, Integer> results = new HashMap<Integer, Integer>();

        for (int a = 1; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                double c = Math.sqrt(a * a + b * b);
                int perimeter = a + b + (int) c;
                if (perimeter > 1000)
                    break;
                if (Math.abs(c - (long) c) > 0.001) {
                    continue;
                }
                int cnt = 0;
                if (results.containsKey(perimeter)) {
                    cnt = results.get(perimeter);
                }
                cnt++;
                results.put(perimeter, cnt);
            }
        }
        System.out.println("p120: " + results.get(120));

        int maxP = 0;
        int maxVal = -1;
        for (int key : results.keySet()) {
            int val = results.get(key);
            if (val > maxVal) {
                maxVal = val;
                maxP = key;
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("result: " + maxP);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }
}
