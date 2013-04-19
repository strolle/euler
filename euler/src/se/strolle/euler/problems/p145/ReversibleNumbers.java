package se.strolle.euler.problems.p145;

public class ReversibleNumbers {
    static final int ASCII_POS = '0';
    static final int DOUBLE_ASCII_POS = ASCII_POS * 2;

    static int MAX = 1000000000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int cnt = 0;
        for (int i = 11; i < MAX; i++) {
            if (isReversible(i)) {

                // String numberString = "" + i;
                // String reverse = "";
                // for (int j = 0; j < numberString.length(); j++) {
                // reverse += numberString.charAt(numberString.length() - j - 1) - ASCII_POS;
                // }
                // System.out.println(i + " - " + (i + Integer.parseInt(reverse)));
                cnt++;
            }

            if (i % 10000000 == 0) {
                long stop = System.currentTimeMillis();
                System.out.println(i + " Expected time: " + (MAX / i) * (stop - start));
            }
        }
        long stop = System.currentTimeMillis();

        System.out.println("result: " + cnt);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);

    }

    private static boolean isReversible(int number) {
        String numberString = "" + number;
        int val = 0;
        int length = numberString.length();
        // System.out.println("ns" + numberString);
        for (int i = 0; i < length; i++) {
            if (i == 0 && numberString.charAt(length - i - 1) == '0')
                return false;
            int newVal = val + numberString.charAt(i) + numberString.charAt(length - i - 1) - DOUBLE_ASCII_POS;
            // System.out.println(i + ":" + newVal);
            if (newVal % 2 == 0)
                return false;
            val = newVal / 10;
        }
        if (val != 0 && val % 2 == 0)
            return false;
        return true;
    }
}
