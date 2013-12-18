package se.strolle.euler.problems.p050;

import java.util.ArrayList;
import java.util.List;

import se.strolle.euler.util.PrimeUtil;

public class PrimeSequence {
    private static int MAX_NUM = 1000000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int longestSeq = 0;
        int longestSeqStartPos = 0;

        List<Long> primeList = buildPrimeList(MAX_NUM - 1);

        for (int i = 0; i < primeList.size(); i++) {
            int maxSeq = getPrimeSeq(primeList, i, longestSeq);
            if (maxSeq > longestSeq) {
                longestSeq = maxSeq;
                longestSeqStartPos = i;
            }
        }

        long result = 0;
        for (int i = longestSeqStartPos; i < longestSeqStartPos + longestSeq; i++) {
            result += primeList.get(i);
        }
        long stop = System.currentTimeMillis();
        System.out.println("result: " + result);
        System.out.println(primeList.get(longestSeqStartPos) + "->" + primeList.get(longestSeqStartPos + longestSeq - 1) + ": " + longestSeq);
        System.out.println("time: " + (stop - start) + "ms");

        System.exit(0);
    }

    private static List<Long> buildPrimeList(int maxNum) {
        List<Long> primeList = new ArrayList<Long>();
        primeList.add(2L);
        primeList.add(3L);
        long prime = PrimeUtil.nextPrime(3);
        while (prime < maxNum) {
            primeList.add(prime);
            prime = PrimeUtil.nextPrime(prime);
        }
        return primeList;
    }

    private static int getPrimeSeq(List<Long> primeList, int listPos, long longestSeq) {
        int maxSeq = 0;
        long sum = 0;
        for (int i = listPos; i < primeList.size() && sum < MAX_NUM; i++) {
            long prime = primeList.get(i);
            sum += prime;
            if ((1 + i - listPos) <= longestSeq)
                continue;
            if (PrimeUtil.isPrime(sum)) {
                maxSeq = 1 + i - listPos;
            }
        }
        return maxSeq;
    }
}
