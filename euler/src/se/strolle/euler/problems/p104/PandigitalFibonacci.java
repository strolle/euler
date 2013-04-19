package se.strolle.euler.problems.p104;

import java.math.BigInteger;

public class PandigitalFibonacci {
    static int ASCII_POS = '0';

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int pos = 1;
        BigInteger fibVal1 = new BigInteger("0");
        BigInteger fibVal2 = new BigInteger("1");

        BigInteger fibVal1End = new BigInteger("0");
        BigInteger fibVal2End = new BigInteger("1");

        while (true) {
            pos++;
            BigInteger newFib = fibVal1.add(fibVal2);
            fibVal1 = fibVal2;
            fibVal2 = newFib;

            if (pos < 2749)
                continue;
            if (pos == 2749) {
                String numberString = fibVal1.toString();
                fibVal1End = new BigInteger(numberString.toString().substring(numberString.length() - 9, numberString.length()));

                numberString = fibVal2.toString();
                fibVal2End = new BigInteger(numberString.toString().substring(numberString.length() - 9, numberString.length()));
            }
            else {
                BigInteger newFibEnd = fibVal1End.add(fibVal2End);
                String numberString = newFibEnd.toString();
                if (numberString.length() > 9)
                    newFibEnd = new BigInteger(numberString.toString().substring(numberString.length() - 9, numberString.length()));
                fibVal1End = fibVal2End;
                fibVal2End = newFibEnd;
            }
            if (isPandigital(fibVal2End.toString())) {
                // System.out.println("endPan: " + pos);
                if (isStartPandigital(newFib)) {
                    break;
                }
            }

            if (pos % 10000 == 0)
                System.out.println(pos + " - " + newFib.toString().length());
        }

        long stop = System.currentTimeMillis();

        System.out.println("result: " + pos);
        System.out.println("fibVal2: " + fibVal2.toString().length());
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);

    }

    private static boolean isStartPandigital(BigInteger number) {
        String numberString = number.toString();
        String number1 = numberString.substring(0, 9);
        if (!isPandigital(number1))
            return false;

        // String number2 = numberString.substring(numberString.length() - 9, numberString.length());
        // if (!isPandigital(number2))
        // return false;
        return true;
    }

    private static boolean isPandigital(String number) {
        boolean[] used = new boolean[10];

        for (int i = 0; i < number.length(); i++) {
            int val = number.charAt(i) - ASCII_POS;
            if (used[val] || val == 0)
                return false;
            used[val] = true;
        }

        return true;
    }

}
