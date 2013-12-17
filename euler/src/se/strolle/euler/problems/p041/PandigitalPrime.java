package se.strolle.euler.problems.p041;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import se.strolle.euler.util.PrimeUtil;

public class PandigitalPrime {

    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        long result = 0;
        List<Integer> res = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> numList = new ArrayList<Integer>();
        numList.addAll(res);
        while (result == 0 && res.size() > 0) {
            result = scrambleAndTest("", numList);
            numList.remove(0);
        }
        long stop = System.currentTimeMillis();
        System.out.println("result: " + result);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static long scrambleAndTest(String string, List<Integer> res) {
        if (res.size() == 0) {
            boolean isPrime = PrimeUtil.isPrime(Long.parseLong(string));
            if (isPrime)
                return Long.parseLong(string);
        }
        else {
            long result = 0;
            for (int i = 0; i < res.size(); i++) {
                int num = res.get(i);
                String newString = string + num;
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(res);
                newList.remove(i);
                result = scrambleAndTest(newString, newList);
                if (result > 0)
                    return result;
            }
        }
        return 0L;
    }
}
