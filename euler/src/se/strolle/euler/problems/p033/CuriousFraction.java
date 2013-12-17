package se.strolle.euler.problems.p033;

public class CuriousFraction {

    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        long totalNum = 1L;
        long totalDenom = 1L;
        for (int numerator = 11; numerator < 100; numerator++) {
            if (numerator % 10 == 0)
                continue;
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                if (denominator % 10 == 0)
                    continue;

                if (isCuriousFraction(numerator, denominator)) {
                    System.out.println("Yes!: " + numerator + "/" + denominator);
                    totalNum *= numerator;
                    totalDenom *= denominator;
                }
            }
        }

        System.out.println("Product: " + totalNum + "/" + totalDenom);
        long stop = System.currentTimeMillis();

        System.out.println("result: ");
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static boolean isCuriousFraction(int numerator, int denominator) {
        if ((numerator % 10) == (denominator / 10)) {
            int tmpNum = numerator / 10;
            int tmpDenom = denominator % 10;
            double fraction = ((double) numerator) / denominator;
            double tmpFraction = ((double) tmpNum) / tmpDenom;
            if (Math.abs(tmpFraction - fraction) < 0.00001)
                return true;
        }

        return false;
    }
}
