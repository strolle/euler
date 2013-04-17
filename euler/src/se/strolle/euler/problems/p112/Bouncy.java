package se.strolle.euler.problems.p112;

public class Bouncy {
    static int ASCII_BASE = 48;

    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        int cnt = 1;
        int bouncyCnt = 0;
        while (true) {
            if (isBouncy(cnt))
                bouncyCnt++;

            double frac = ((double) bouncyCnt) / cnt;
            if (frac >= 0.99)
                break;
            cnt++;
        }
        System.err.println("bouncyCnt: " + bouncyCnt);
        System.err.println("frac: " + ((double) bouncyCnt) / cnt);

        long stop = System.currentTimeMillis();

        System.out.println("result: " + cnt);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static boolean isBouncy(long number) {
        boolean hasIncrease = false;
        boolean hasDecrease = false;

        char[] charArray = ("" + number).toCharArray();
        int foundMax = (int) charArray[0];
        int foundMin = (int) charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            int val = (int) charArray[i];
            if (val > foundMax)
                foundMax = val;
            if (val < foundMin)
                foundMin = val;

            if (val < foundMax)
                hasDecrease = true;
            if (val > foundMin)
                hasIncrease = true;
            if (hasIncrease && hasDecrease)
                return true;
        }
        return false;
    }
}
