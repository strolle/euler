package se.strolle.euler.problems.p036;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubleBasePalindromes {
	private static final int MAX_NUM = 1000000;

	static List<Integer> abundantList = new ArrayList<Integer>();
	static Map<Integer, Integer> abundantMap = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		long cnt = 0;

		for (int i = 0; i < MAX_NUM; i++) {
			if (isPalindrome("" + i)) {
				if (isPalindrome(Integer.toBinaryString(i))) {
					cnt += i;
				}
			}
		}

		long stop = System.currentTimeMillis();

		System.out.println("\nresult: " + cnt);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);

	}

	private static boolean isPalindrome(String input) {

		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - i - 1))
				return false;
		}

		return true;
	}
}
