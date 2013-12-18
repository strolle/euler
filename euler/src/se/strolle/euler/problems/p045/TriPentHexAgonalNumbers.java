package se.strolle.euler.problems.p045;

public class TriPentHexAgonalNumbers {
    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        long result = 0L;

        for (int i = 286; true; i++) {
            long tri = trianular(i);
            if (isPentagonal(tri) && isHexagonal(tri)) {
                result = tri;
                break;
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("result: " + result);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static long trianular(long num) {
        return num * (num + 1) / 2;
    }

    private static boolean isPentagonal(long valueToTest) {
        double sqrt = Math.sqrt(1 + 24 * valueToTest);

        if (Math.abs(sqrt - (long) (sqrt)) > 0.0001)
            return false;
        if ((1 + (long) sqrt) % 6 == 0)
            return true;
        return false;
    }

    private static boolean isHexagonal(long valueToTest) {
        double sqrt = Math.sqrt(1 + 8 * valueToTest);

        if (Math.abs(sqrt - (long) (sqrt)) > 0.0001)
            return false;
        if ((1 + (long) sqrt) % 4 == 0)
            return true;
        return false;
    }

}
