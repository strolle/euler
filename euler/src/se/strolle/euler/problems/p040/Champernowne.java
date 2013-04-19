package se.strolle.euler.problems.p040;

public class Champernowne {
    static final int ASCII_POS = 48;

    private static final int[] POS = new int[] {1, 100, 1000, 10000, 100000, 1000000};

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int[] digits = new int[POS.length];

        int startPos = 1;
        int arrayPos = 0;

        int i = 0;
        while (arrayPos < POS.length) {
            i++;

            String numString = "" + i;
            while (arrayPos < POS.length && POS[arrayPos] < (startPos + numString.length()) && POS[arrayPos] >= startPos) {
                digits[arrayPos] = getDigit(startPos, numString, POS[arrayPos]);
                arrayPos++;
            }
            startPos += numString.length();
        }

        int val = 1;
        for (int j = 0; j < digits.length; j++) {
            val *= digits[j];
        }

        long stop = System.currentTimeMillis();

        System.out.println("\nresult: " + val);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);

    }

    private static int getDigit(int startPos, String numString, int positionToUse) {
        int pos = positionToUse - startPos;
        return numString.charAt(pos) - ASCII_POS;
    }
}
