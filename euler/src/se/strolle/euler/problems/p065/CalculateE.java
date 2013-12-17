package se.strolle.euler.problems.p065;

import java.math.BigInteger;

public class CalculateE {
    private static final int MAX_NUM = 100;
    static final int ASCII_POS = 48;

    public static void main(String[] args) throws Exception {
        long result = 0;

        BigInteger num0 = BigInteger.valueOf(1);
        BigInteger num1 = BigInteger.valueOf(2);
        for (int i = 2; i <= MAX_NUM; i++) {
            BigInteger newNum = calculateSingleNum(num0, num1, i);

            System.err.println(i + " - " + newNum);
            num0 = num1;
            num1 = newNum;
        }
        String valString = num1.toString();
        for (int i = 0; i < valString.length(); i++) {
            result += valString.charAt(i) - ASCII_POS;
        }
        System.out.println("Result: " + result);

        System.exit(0);
    }

    private static BigInteger calculateSingleNum(BigInteger num0, BigInteger num1, int loopCnt) {
        long factor = 1;
        if (loopCnt % 3 == 0)
            factor = 2 * loopCnt / 3;

        return num1.multiply(BigInteger.valueOf(factor)).add(num0);
    }
}
