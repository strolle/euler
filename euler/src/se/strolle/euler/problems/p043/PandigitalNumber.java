package se.strolle.euler.problems.p043;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PandigitalNumber {

    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        long result = 0;
        List<Integer> numList = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        result = scrambleAndTest("", numList);
        long stop = System.currentTimeMillis();
        System.out.println("result: " + result);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static long scrambleAndTest(String string, List<Integer> res) {
        long result = 0;
        if (res.size() == 0) {
            if (hasDivisorProperty(string))
                return Long.parseLong(string);
        }
        else {
            for (int i = 0; i < res.size(); i++) {
                int num = res.get(i);
                String newString = string + num;
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(res);
                newList.remove(i);
                result += scrambleAndTest(newString, newList);
            }
        }
        return result;
    }

    private static boolean hasDivisorProperty(String numberString) {
        if (Integer.parseInt(numberString.substring(1, 4)) % 2 != 0)
            return false;
        if (Integer.parseInt(numberString.substring(2, 5)) % 3 != 0)
            return false;
        if (Integer.parseInt(numberString.substring(3, 6)) % 5 != 0)
            return false;
        if (Integer.parseInt(numberString.substring(4, 7)) % 7 != 0)
            return false;
        if (Integer.parseInt(numberString.substring(5, 8)) % 11 != 0)
            return false;
        if (Integer.parseInt(numberString.substring(6, 9)) % 13 != 0)
            return false;
        if (Integer.parseInt(numberString.substring(7)) % 17 != 0)
            return false;

        return true;
    }
}
