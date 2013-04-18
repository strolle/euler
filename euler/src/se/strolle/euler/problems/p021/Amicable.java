package se.strolle.euler.problems.p021;

import java.util.HashMap;
import java.util.Map;

public class Amicable {
	private static final int MAX_NUM = 10000;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Map<Integer, Integer> divisorMap = new HashMap<Integer, Integer>();
		for (int i = 2; i < MAX_NUM; i++) {
			divisorMap.put(i, getDivisorSum(i));
		}
		int cnt = 0;

		for (int i = 1; i < MAX_NUM; i++) {
			Integer val = divisorMap.get(i);
			if (val == null || val == i)
				continue;
			Integer val2 = divisorMap.get(val);
			if (val2 == null)
				continue;
			if (i == val2) {
				cnt += i;
			}
		}

		long stop = System.currentTimeMillis();

		System.out.println("\nresult: " + cnt);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);

	}

	private static int getDivisorSum(int number) {
		int sum = 1;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0)
				sum += i;
		}
		return sum;
	}

}
