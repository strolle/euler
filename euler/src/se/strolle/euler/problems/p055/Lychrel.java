package se.strolle.euler.problems.p055;

import java.math.BigInteger;

public class Lychrel {
	public static int MAX_TEST = 50;
	public static int MAX_VALUE = 10000;

	public static void main(String args[]) {
		long start = System.currentTimeMillis();

		int cnt = 0;

		mainLoop: for (int i = 0; i < MAX_VALUE; i++) {
			BigInteger value = new BigInteger("" + i);
			for (int j = 0; j < MAX_TEST; j++) {
				value = value.add(reverse(value));
				if (isPalindrome(value)) {
					continue mainLoop;
				}
			}
			cnt++;
		}

		long stop = System.currentTimeMillis();

		System.out.println("result: " + cnt);
		System.out.println("time: " + (stop - start) + "ms");

		System.exit(0);
	}

	private static boolean isPalindrome(BigInteger current) {
		char[] currentStringArr = current.toString().toCharArray();

		for (int i = 0; i < currentStringArr.length / 2; i++) {
			if (currentStringArr[i] != currentStringArr[currentStringArr.length
					- 1 - i])
				return false;
		}
		return true;
	}

	private static BigInteger reverse(BigInteger current) {
		char[] currentStringArr = current.toString().toCharArray();
		String out = "";
		for (int i = currentStringArr.length - 1; i >= 0; i--) {
			out += currentStringArr[i];
		}
		return new BigInteger(out);
	}
}
