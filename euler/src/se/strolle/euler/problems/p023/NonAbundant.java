package se.strolle.euler.problems.p023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonAbundant {
	private static final int MAX_NUM = 28123;

	static List<Integer> abundantList = new ArrayList<Integer>();
	static Map<Integer, Integer> abundantMap = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		long cnt = 0;
		for (int i = 1; i < MAX_NUM; i++) {
			int sum = getDivisorSum(i);
			if (sum > i) {
				abundantList.add(i);
				abundantMap.put(i, i);
			}
			if (!isAbundantSize(i)) {
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

	private static boolean isAbundantSize(int number) {
		for (int abundant : abundantList) {
			if (abundantMap.containsKey(number - abundant)) {
				return true;
			}
		}
		return false;
	}
}
