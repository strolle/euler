package se.strolle.euler.problems.p092;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SquareDigitChain {
    static int ASCII_BASE = 48;
    static int MAX_VAL = 10000000;

    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        Map<Integer, Boolean> foundMap = new HashMap<Integer, Boolean>();
        int cnt = 0;
        for (int i = MAX_VAL - 1; i > 0; i--) {
            // System.err.println(i);
            List<Integer> usedList = new ArrayList<Integer>();
            int newVal = i;
            if (i % 500000 == 0) {
                foundMap = new HashMap<Integer, Boolean>(MAX_VAL);
            }

            while (true) {
                if (foundMap.containsKey(newVal)) {
                    // System.err.println("found: " + newVal);
                    if (foundMap.get(newVal)) {
                        cnt++;
                        addToFoundMap(foundMap, usedList, Boolean.TRUE);
                        break;
                    }
                    else if (!foundMap.get(newVal)) {
                        addToFoundMap(foundMap, usedList, Boolean.FALSE);
                        break;
                    }
                    else {
                        System.err.println("WFT!");
                        break;
                    }
                }
                newVal = squreDigit(newVal);
                if (usedList.size() == 0)
                    usedList.add(i);
                if (newVal == 89) {
                    cnt++;
                    addToFoundMap(foundMap, usedList, Boolean.TRUE);
                    break;
                }
                else if (newVal == 1) {
                    addToFoundMap(foundMap, usedList, Boolean.FALSE);
                    break;
                }
                usedList.add(newVal);

            }
        }

        long stop = System.currentTimeMillis();

        System.out.println("result: " + cnt);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static void addToFoundMap(Map<Integer, Boolean> foundMap, List<Integer> usedList, Boolean value) {
        for (int i : usedList) {
            // System.err.println("addfound: " + i + " - " + value + " (" + foundMap.containsKey(i) + ")");
            foundMap.put(i, value);
        }
    }

    private static int squreDigit(int number) {
        char[] charArray = ("" + number).toCharArray();

        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            sum += (charArray[i] - ASCII_BASE) * (charArray[i] - ASCII_BASE);
        }
        return sum;
    }
}
