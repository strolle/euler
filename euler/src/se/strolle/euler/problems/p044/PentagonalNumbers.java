package se.strolle.euler.problems.p044;

public class PentagonalNumbers {
    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        long lowestDiff = Long.MAX_VALUE;
        mainLoop: for (int i = 1; true; i++) {
            long pentaI = pentagonal(i);
            if ((pentaI - pentagonal(i - 1)) > lowestDiff)
                break mainLoop;

            for (int j = i - 1; j > 0; j--) {
                long pentaJ = pentagonal(j);
                long diff = pentaI - pentaJ;
                if (diff > lowestDiff)
                    break;
                long sum = pentaI + pentaJ;
                if (!isPentagonal(sum) || !isPentagonal(diff))
                    continue;
                lowestDiff = diff;
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("result: " + lowestDiff);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static long pentagonal(long num) {
        return num * (3 * num - 1) / 2;
    }

    private static boolean isPentagonal(long valueToTest) {
        double sqrt = Math.sqrt(1 + 24 * valueToTest);

        if (Math.abs(sqrt - (long) (sqrt)) > 0.0001)
            return false;
        if ((1 + (long) sqrt) % 6 == 0)
            return true;
        return false;
    }
}
